package com.example.dataloader.config;

import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvParser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {

  @Bean
  public CsvMapper csvMapper() {
    final CsvMapper csvMapper = new CsvMapper();
    csvMapper.enable(CsvParser.Feature.SKIP_EMPTY_LINES).enable(CsvParser.Feature.TRIM_SPACES)
        .findAndRegisterModules();
    return csvMapper;
  }
}
