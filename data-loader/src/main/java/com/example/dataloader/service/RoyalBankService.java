package com.example.dataloader.service;

import com.example.dataloader.dto.RoyalBankTransactionDto;
import com.example.dataloader.mappers.RoyalBankTransactionMapper;
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
public class RoyalBankService {

  private CsvMapper csvMapper;
  private RoyalBankTransactionMapper transactionMapper;

  @Autowired
  public RoyalBankService(CsvMapper csvMapper,
      RoyalBankTransactionMapper transactionMapper) {
    this.csvMapper = csvMapper;
    this.transactionMapper = transactionMapper;
  }

  public void loadCsv(Path csvFile) throws IOException {
    final CsvSchema schema = CsvSchema.emptySchema().withHeader();
    System.out.println("Display Royal Bank transactions");
    try (BufferedReader reader = Files.newBufferedReader(csvFile)) {
      final MappingIterator<RoyalBankTransactionDto> iterator = csvMapper.readerFor(
          RoyalBankTransactionDto.class)
          .with(schema).readValues(reader);
      final List<RoyalBankTransactionDto> transactionDtoList = iterator.readAll();
      transactionDtoList.forEach(System.out::println);
      System.out.println("Display Royal Bank transactions: DB entities");
      transactionDtoList.parallelStream().map(transactionMapper::toTransaction)
          .forEach(System.out::println);
    }
  }
}
