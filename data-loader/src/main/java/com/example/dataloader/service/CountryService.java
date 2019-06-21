package com.example.dataloader.service;

import static java.nio.file.Files.newBufferedReader;

import com.example.dataloader.dto.CountryDto;
import com.example.dataloader.dto.ISOCountryDto;
import com.example.dataloader.dto.RegionDto;
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
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class CountryService {

  private CsvMapper csvMapper;
  private ObjectMapper objectMapper;
  private Map<String, String> countrNameToCountryCode;
  private RegionCountryRegistry regionCountryRegistry;

  @Autowired
  public CountryService(@Qualifier("csvMapper") CsvMapper csvMapper,
      @Qualifier("jsonMapper") ObjectMapper objectMapper, RegionCountryRegistry regionCountryRegistry)
      throws IOException {
    this.csvMapper = csvMapper;
    this.objectMapper = objectMapper;
    countrNameToCountryCode = loadCountryCodes();
    this.regionCountryRegistry = regionCountryRegistry;
  }

  private Map<String, String> loadCountryCodes() throws IOException {
    final CsvSchema schema = CsvSchema.emptySchema().withHeader();
    try (BufferedReader reader = newBufferedReader(Paths.get("countrycode.csv"))) {
      final MappingIterator<ISOCountryDto> iterator = csvMapper.readerFor(
          ISOCountryDto.class).with(schema).readValues(reader);
      final List<ISOCountryDto> countryDtoList = iterator.readAll();
      return countryDtoList.stream()
          .collect(Collectors.toMap(ISOCountryDto::getCountryName, ISOCountryDto::getCountryCode));

    }
  }

  public void loadCsv(Path csvFile) throws IOException {
    final CsvSchema schema = CsvSchema.emptySchema().withHeader();
    try (BufferedReader reader = newBufferedReader(csvFile)) {
      final MappingIterator<CountryDto> iterator = csvMapper.readerFor(CountryDto.class)
          .with(schema).readValues(reader);
      final List<CountryDto> countryDtoList = iterator.readAll();
      final Map<String, Set<ISOCountryDto>> results = Arrays.stream(RegionDto.values())
          .collect(Collectors.toMap(region -> region.getRegionName(), region -> new HashSet<>()));
      for (CountryDto country : countryDtoList) {
        final String africa = country.getAfrica().trim();
        if (africa != null && !africa.isBlank()) {
          results.get(RegionDto.AFRICA.getRegionName())
              .add(new ISOCountryDto(getCountryCode(africa), africa));
        }
        final String northAfrica = country.getNorthAfrica().trim();
        if (northAfrica != null && !northAfrica.isBlank()) {
          results.get(RegionDto.NORTH_AFRICA.getRegionName())
              .add(new ISOCountryDto(getCountryCode(northAfrica), northAfrica));
        }
        final String northAmerica = country.getNorthAmerica().trim();
        if (northAmerica != null && !northAmerica.isBlank()) {
          results.get(RegionDto.NORTH_AMERICA.getRegionName())
              .add(new ISOCountryDto(getCountryCode(northAmerica), northAmerica));
        }
        final String latinAmerica = country.getLatinAmerica().trim();
        if (latinAmerica != null && !latinAmerica.isBlank()) {
          results.get(RegionDto.LATIN_AMERICA.getRegionName())
              .add(new ISOCountryDto(getCountryCode(latinAmerica), latinAmerica));
        }
        final String theCaribbean = country.getTheCaribbean().trim();
        if (theCaribbean != null && !theCaribbean.isBlank()) {
          results.get(RegionDto.THE_CARIBBEAN.getRegionName())
              .add(new ISOCountryDto(getCountryCode(theCaribbean), theCaribbean));
        }
        final String southEastEurope = country.getSouthEastEurope().trim();
        if (southEastEurope != null && !southEastEurope.isBlank()) {
          results.get(RegionDto.SOUTH_EAST_EUROPE.getRegionName())
              .add(new ISOCountryDto(getCountryCode(southEastEurope), southEastEurope));
        }
        final String northEastEurope = country.getNorthEastEurope().trim();
        if (northEastEurope != null && !northEastEurope.isBlank()) {
          results.get(RegionDto.NORTH_EAST_EUROPE.getRegionName())
              .add(new ISOCountryDto(getCountryCode(northEastEurope), northEastEurope));
        }
        final String southWestEurope = country.getSouthWestEurope().trim();
        if (southWestEurope != null && !southWestEurope.isBlank()) {
          results.get(RegionDto.SOUTH_WEST_EUROPE.getRegionName())
              .add(new ISOCountryDto(getCountryCode(southWestEurope), southWestEurope));
        }
        final String northWestEurope = country.getNorthWestEurope().trim();
        if (northWestEurope != null && !northWestEurope.isBlank()) {
          results.get(RegionDto.NORTH_WEST_EUROPE.getRegionName())
              .add(new ISOCountryDto(getCountryCode(northWestEurope), northWestEurope));
        }
        final String nordics = country.getNordics().trim();
        if (nordics != null && !nordics.isBlank()) {
          results.get(RegionDto.NORDICS.getRegionName())
              .add(new ISOCountryDto(getCountryCode(nordics), nordics));
        }
        final String middleEast = country.getMiddleEast().trim();
        if (middleEast != null && !middleEast.isBlank()) {
          results.get(RegionDto.MIDDLE_EAST.getRegionName())
              .add(new ISOCountryDto(getCountryCode(middleEast), middleEast));
        }

        final String oceania = country.getOceania().trim();
        if (oceania != null && !oceania.isBlank()) {
          results.get(RegionDto.OCEANIA.getRegionName())
              .add(new ISOCountryDto(getCountryCode(oceania), oceania));
        }
        final String centralAsia = country.getCentralAsia().trim();
        if (centralAsia != null && !centralAsia.isBlank()) {
          results.get(RegionDto.CENTRAL_ASIA.getRegionName())
              .add(new ISOCountryDto(getCountryCode(centralAsia), centralAsia));
        }
        final String eastAsia = country.getEastAsia().trim();
        if (eastAsia != null && !eastAsia.isBlank()) {
          results.get(RegionDto.EAST_ASIA.getRegionName())
              .add(new ISOCountryDto(getCountryCode(eastAsia), eastAsia));
        }
        final String southAsia = country.getSouthAsia().trim();
        if (southAsia != null && !southAsia.isBlank()) {
          results.get(RegionDto.SOUTH_ASIA.getRegionName())
              .add(new ISOCountryDto(getCountryCode(southAsia), southAsia));
        }
        final String southEastAsia = country.getSouthEastAsia().trim();
        if (southEastAsia != null && !southEastAsia.isBlank()) {
          results.get(RegionDto.SOUTH_EAST_ASIA.getRegionName())
              .add(new ISOCountryDto(getCountryCode(southEastAsia), southEastAsia));
        }
        final String northAsia = country.getNorthAsia().trim();
        if (northAsia != null && !northAsia.isBlank()) {
          results.get(RegionDto.NORTH_ASIA.getRegionName())
              .add(new ISOCountryDto(getCountryCode(northAsia), northAsia));
        }
      }
      regionCountryRegistry.setRegionNameToCountryMap(results);
      objectMapper.writeValue(Files.newBufferedWriter(Paths.get("country_codes.json")), results);
    }
  }

  private String getCountryCode(String countryName) {
    return countrNameToCountryCode.get(countryName);
  }

}
