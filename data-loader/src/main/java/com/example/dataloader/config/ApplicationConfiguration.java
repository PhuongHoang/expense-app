package com.example.dataloader.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvParser;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {

  @Bean
  @Qualifier("csvMapper")
  public CsvMapper csvMapper() {
    final CsvMapper csvMapper = new CsvMapper();
    csvMapper.enable(CsvParser.Feature.SKIP_EMPTY_LINES).enable(CsvParser.Feature.TRIM_SPACES)
        .findAndRegisterModules();
    return csvMapper;
  }

  @Bean
  @Qualifier("jsonMapper")
  public ObjectMapper objectMapper() {
    return new ObjectMapper();
  }
}
