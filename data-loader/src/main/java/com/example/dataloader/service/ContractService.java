package com.example.dataloader.service;

import com.example.dataloader.dto.LicensorRegionDto;
import com.example.dataloader.dto.LicensorRegionDto.Country;
import com.example.dataloader.dto.ServiceContractDto;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ContractService {

  private static final Logger LOGGER = LoggerFactory.getLogger(ContractService.class);
  private static final Set<String> UNKNOWN_REGIONS = new HashSet<>();
  private CsvMapper csvMapper;
  private ObjectMapper objectMapper;
  private RegionCountryRegistry regionCountryRegistry;

  @Autowired
  public ContractService(@Qualifier("csvMapper") CsvMapper csvMapper,
      @Qualifier("jsonMapper") ObjectMapper objectMapper,
      RegionCountryRegistry regionCountryRegistry) {
    this.csvMapper = csvMapper;
    this.objectMapper = objectMapper;
    this.regionCountryRegistry = regionCountryRegistry;
  }

  private static List<ServiceContract> combineLists(List<ServiceContract> list1,
      List<ServiceContract> list2) {
    var list = new ArrayList<>(list1);
    list.addAll(list2);
    return list;
  }

  private static String cleanTerritories(String territories) {
    var territoryList = Arrays.stream(territories.split(",")).map(String::trim)
        .map(String::toUpperCase).collect(Collectors.toList());
    return territoryList.stream().flatMap(territory -> toTerritories(territory).stream())
        .collect(Collectors.joining(","));
  }

  private static Map<String, List<ServiceContract>> toMapLicensorNameToServiceContracts(
      Stream<ServiceContract> serviceContractStream) {
    return serviceContractStream.collect(
        Collectors.toMap(contract -> contract.getLegalName(), contract -> List.of(contract),
            (value1, value2) -> combineLists(value1, value2)));
  }

  private static List<String> toTerritories(String territory) {
    switch (territory) {
      case "ASIA":
        return Arrays
            .asList("CENTRAL ASIA", "EAST ASIA", "SOUTH ASIA", "SOUTHEAST ASIA", "NORTH ASIA");
      case "AFRICA":
        return Arrays.asList("AFRICA");
      case "WORLDWIDE":
        return Arrays.asList("AFRICA", "NORTH AMERICA", "LATIN AMERICA", "THE CARIBBEAN",
            "SOUTH EAST EUROPE", "NORTH EAST EUROPE", "SOUTH WEST EUROPE", "NORTH WEST EUROPE",
            "NORDICS", "MIDDLE EAST", "OCEANIA", "CENTRAL ASIA", "EAST ASIA", "SOUTH ASIA",
            "SOUTHEAST ASIA", "NORTH ASIA");
      case "NORTH AMERICA":
        return Arrays.asList("NORTH AMERICA");
      case "SOUTH AMERICA":
        return Arrays.asList("SOUTH AMERICA");
      case "SEE":
        return Arrays.asList("SOUTH EAST EUROPE");
      case "MENA":
        return Arrays.asList("MIDDLE EAST", "NORTH AFRICA");
      case "OCEANIA":
        return Arrays.asList("OCEANIA");
      case "LATAM":
        return Arrays.asList("LATIN AMERICA");
      case "CARIBBEAN":
        return Arrays.asList("THE CARIBBEAN");
      case "EUROPE":
        return Arrays.asList("SOUTH EAST EUROPE", "NORTH EAST EUROPE", "SOUTH WEST EUROPE",
            "NORTH WEST EUROPE", "NORDICS");
      case "":
        return Arrays.asList(territory);
      default:
        UNKNOWN_REGIONS.add(territory);
    }
    return Arrays.asList(territory);
  }

  public void loadCsv(Path csvFile) throws IOException {
    final CsvSchema schema = CsvSchema.emptySchema().withHeader();
    System.out.println("Display contract service");
    try (BufferedReader reader = Files.newBufferedReader(csvFile)) {

      final MappingIterator<ServiceContractDto> iterator = csvMapper.readerFor(
          ServiceContractDto.class).with(schema).readValues(reader);
      final List<ServiceContractDto> serviceContractDtos = iterator.readAll();
      var cleanedContractDtos = serviceContractDtos.stream().map(
          dto -> new ServiceContractDto(dto.getLegalName().trim(),
              cleanTerritories(dto.getTerritories().trim()),
              dto.getApplicableCountries().trim(), dto.getTerritoryNotes().trim()))
          .collect(Collectors.toList());
      var serviceContracts = cleanedContractDtos.stream().map(
          dto -> new ServiceContract(dto.getLegalName(), dto.getTerritories(),
              dto.getApplicableCountries(), dto.getTerritoryNotes())).collect(Collectors.toList());
      // Find any contracts that can be converted without any problems
      var serviceContractsWithSomeInterventions = serviceContracts.stream()
          .filter(contract -> contract.getTerritoryNotes().isEmpty())
          .filter(contract -> {
            var list = new ArrayList<>(contract.getTerritories());
            list.retainAll(UNKNOWN_REGIONS);
            return list.isEmpty();
          }).collect(Collectors.toList());
      var serviceContractsWithoutAnyIntervention = toMapLicensorNameToServiceContracts(
          serviceContractsWithSomeInterventions.stream()
              .filter(contract -> contract.getApplicableCountries().isBlank()));
      final List<LicensorRegionDto> licensorRegionDtoWithoutIntervention = serviceContractsWithoutAnyIntervention
          .entrySet()
          .stream().map(entry -> toLicensorRegionDto(entry)).collect(
              Collectors.toList());
      objectMapper
          .writeValue(Files.newBufferedWriter(Paths.get("output_without_intervention.json")),
              licensorRegionDtoWithoutIntervention);
      var serviceContractsWithMinorIntervention = toMapLicensorNameToServiceContracts(
          serviceContractsWithSomeInterventions.stream()
              .filter(contract -> !contract.getApplicableCountries().isBlank()));
      objectMapper
          .writeValue(Files.newBufferedWriter(Paths.get("output_with_minor_intervention.json")),
              serviceContractsWithMinorIntervention);
      // Find all contracts that have to be manually inspected
      serviceContracts.removeAll(serviceContractsWithSomeInterventions);
      final Map<String, List<ServiceContract>> results = toMapLicensorNameToServiceContracts(
          serviceContracts.stream());

      objectMapper.writeValue(Files.newBufferedWriter(Paths.get("output.json")), results);
      LOGGER.warn("Unable to process this territory {}", UNKNOWN_REGIONS);
    }
  }

  private LicensorRegionDto toLicensorRegionDto(Entry<String, List<ServiceContract>> entry) {
    var licensorRegionDto = new LicensorRegionDto();
    licensorRegionDto.setLicensorName(entry.getKey());
    var territorySet = entry.getValue().stream()
        .flatMap(serviceContract -> serviceContract.getTerritories().stream())
        .filter(territory -> !territory.isBlank())
        .collect(Collectors.toSet());
    final Map<String, Set<Country>> regionTerritoryMap = territorySet.stream()
        .collect(Collectors.toMap(Function.identity(),
            territory -> regionCountryRegistry.getRegionNameToCountryMap().get(territory).stream()
                .map(countryDto -> new Country(countryDto.getCountryCode(),
                    countryDto.getCountryName())).collect(Collectors.toSet())));
    licensorRegionDto.setRegionTerritoryMap(regionTerritoryMap);
    return licensorRegionDto;
  }
}