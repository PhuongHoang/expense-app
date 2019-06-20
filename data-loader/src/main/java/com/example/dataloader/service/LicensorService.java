package com.example.dataloader.service;

import com.example.dataloader.dto.CountryDto;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class LicensorService {

  private CsvMapper csvMapper;
  private ObjectMapper objectMapper;

  @Autowired
  public LicensorService(@Qualifier("csvMapper") CsvMapper csvMapper, @Qualifier("jsonMapper") ObjectMapper objectMapper)
      throws IOException {
    this.csvMapper = csvMapper;
    this.objectMapper = objectMapper;
  }

  public void loadCsv(Path csvFile) throws IOException {
    final CsvSchema schema = CsvSchema.emptySchema().withHeader();
    System.out.println("Display Licensors");
    try (BufferedReader reader = Files.newBufferedReader(csvFile)) {

      final MappingIterator<CountryDto> iterator = csvMapper.readerFor(
          CountryDto.class).with(schema).readValues(reader);
      final List<CountryDto> countryDtoList = iterator.readAll();
      Map<String, List<Country>> results = new HashMap<>();
      results.put("AFRICA", new ArrayList<>());
      results.put("NORTH AMERICA", new ArrayList<>());
      results.put("LATIN AMERICA", new ArrayList<>());
      results.put("THE CARIBBEAN", new ArrayList<>());
      results.put("SOUTH EAST EUROPE", new ArrayList<>());
      results.put("NORTH EAST EUROPE", new ArrayList<>());
      results.put("SOUTH WEST EUROPE", new ArrayList<>());
      results.put("NORTH WEST EUROPE", new ArrayList<>());
      results.put("NORDICS", new ArrayList<>());
      results.put("MIDDLE EAST", new ArrayList<>());
      results.put("OCEANIA", new ArrayList<>());
      results.put("CENTRAL ASIA", new ArrayList<>());
      results.put("EAST ASIA", new ArrayList<>());
      results.put("SOUTH ASIA", new ArrayList<>());
      results.put("SOUTHEAST ASIA", new ArrayList<>());
      results.put("NORTH ASIA", new ArrayList<>());
      for (CountryDto country : countryDtoList) {
        final String africa = country.getAfrica();
        if (africa != null && !africa.isBlank()) {
          results.get("AFRICA").add(new Country(getCountryCode(africa), africa));
        }
        final String northAmerica = country.getNorthAmerica();
        if (northAmerica != null && !northAmerica.isBlank()) {
          results.get("NORTH AMERICA").add(new Country(getCountryCode(northAmerica), northAmerica));
        }
        final String latinAmerica = country.getLatinAmerica();
        if (latinAmerica != null && !latinAmerica.isBlank()) {
          results.get("LATIN AMERICA").add(new Country(getCountryCode(latinAmerica), latinAmerica));
        }
        final String theCaribbean = country.getTheCaribbean();
        if (theCaribbean != null && !theCaribbean.isBlank()) {
          results.get("THE CARIBBEAN").add(new Country(getCountryCode(theCaribbean), theCaribbean));
        }
        final String southEastEurope = country.getSouthEastEurope();
        if (southEastEurope != null && !southEastEurope.isBlank()) {
          results.get("SOUTH EAST EUROPE").add(new Country(getCountryCode(southEastEurope), southEastEurope));
        }
        final String northEastEurope = country.getNorthEastEurope();
        if (northEastEurope != null && !northEastEurope.isBlank()) {
          results.get("NORTH EAST EUROPE").add(new Country(getCountryCode(northEastEurope), northEastEurope));
        }
        final String southWestEurope = country.getSouthWestEurope();
        if (southWestEurope != null && !southWestEurope.isBlank()) {
          results.get("SOUTH WEST EUROPE").add(new Country(getCountryCode(southWestEurope), southWestEurope));
        }
        final String northWestEurope = country.getNorthWestEurope();
        if (northWestEurope != null && !northWestEurope.isBlank()) {
          results.get("NORTH WEST EUROPE").add(new Country(getCountryCode(northWestEurope), northWestEurope));
        }
        final String nordics = country.getNordics();
        if (nordics != null && !nordics.isBlank()) {
          results.get("NORDICS").add(new Country(getCountryCode(nordics), nordics));
        }
        final String middleEast = country.getMiddleEast();
        if (middleEast != null && !middleEast.isBlank()) {
          results.get("MIDDLE EAST").add(new Country(getCountryCode(middleEast), middleEast));
        }

        final String oceania = country.getOceania();
        if (oceania != null && !oceania.isBlank()) {
          results.get("OCEANIA").add(new Country(getCountryCode(oceania), oceania));
        }
        final String centralAsia = country.getCentralAsia();
        if (centralAsia != null && !centralAsia.isBlank()) {
          results.get("CENTRAL ASIA").add(new Country(getCountryCode(centralAsia), centralAsia));
        }
        final String eastAsia = country.getEastAsia();
        if (eastAsia != null && !eastAsia.isBlank()) {
          results.get("EAST ASIA").add(new Country(getCountryCode(eastAsia), eastAsia));
        }
        final String southAsia = country.getSouthAsia();
        if (southAsia != null && !southAsia.isBlank()) {
          results.get("SOUTH ASIA").add(new Country(getCountryCode(southAsia), southAsia));
        }
        final String southEastAsia = country.getSouthEastAsia();
        if (southEastAsia != null && !southEastAsia.isBlank()) {
          results.get("SOUTHEAST ASIA").add(new Country(getCountryCode(southEastAsia), southEastAsia));
        }
        final String northAsia = country.getNorthAsia();
        if (northAsia != null && !northAsia.isBlank()) {
          results.get("NORTH ASIA").add(new Country(getCountryCode(northAsia), northAsia));
        }
      }
      final String resultString = objectMapper.writeValueAsString(results);
      System.out.println(resultString);
    }
  }

  private String getCountryCode(String countryName) {
    return countryName;
  }

}
