package com.example.dataloader.service;

import com.example.data.repositories.TransactionRepository;
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
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CapitalOneService {

  private CsvMapper csvMapper;
  private CapitalOneTransactionMapper transactionMapper;
  private TransactionRepository transactionRepository;

  @Autowired
  public CapitalOneService(CsvMapper csvMapper,
      CapitalOneTransactionMapper transactionMapper, TransactionRepository transactionRepository) {
    this.csvMapper = csvMapper;
    this.transactionMapper = transactionMapper;
    this.transactionRepository = transactionRepository;
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
      System.out.println("Saving Capital One transactions");
      transactionRepository.saveAll(
          transactionDtoList.parallelStream().map(transactionMapper::toTransaction).collect(
              Collectors.toList()));
    }
  }
}
