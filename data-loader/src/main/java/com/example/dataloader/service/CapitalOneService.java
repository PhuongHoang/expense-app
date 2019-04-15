package com.example.dataloader.service;

import com.example.dataloader.dto.CapitalOneTransactionDto;
import com.example.dataloader.mappers.CapitalOneTransactionMapper;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CapitalOneService {

  private CsvMapper csvMapper;
  private CapitalOneTransactionMapper transactionMapper;

  @Autowired
  public CapitalOneService(CsvMapper csvMapper,
      CapitalOneTransactionMapper transactionMapper) {
    this.csvMapper = csvMapper;
    this.transactionMapper = transactionMapper;
  }

  public void loadCsv(Path csvFile) throws IOException {
    final CsvSchema schema = CsvSchema.emptySchema().withHeader();
    System.out.println("Display Capital One transactions");
    try (BufferedReader reader = Files.newBufferedReader(csvFile)) {

      final MappingIterator<CapitalOneTransactionDto> iterator = csvMapper.readerFor(
          CapitalOneTransactionDto.class)
          .with(schema).readValues(reader);
      final List<CapitalOneTransactionDto> transactionDtoList = iterator.readAll();
      transactionDtoList.forEach(System.out::println);
      System.out.println("Display Capital One transactions: DB entities");
      transactionDtoList.parallelStream().map(transactionMapper::toTransaction)
          .forEach(System.out::println);
    }
  }
}
