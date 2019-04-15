package com.example.dataloader;

import com.example.dataloader.CsvController.CsvType;
import com.example.dataloader.dto.CapitalOneTransactionDto;
import com.example.dataloader.dto.RoyalBankTransactionDto;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.configuration.EnableTask;
import org.springframework.context.annotation.Bean;

@EnableTask
@SpringBootApplication
public class DataLoaderApplication {

  public static void main(String[] args) {
    SpringApplication.run(DataLoaderApplication.class, args);
  }

  @Bean
  public ApplicationRunner runner(CsvController csvController) {
    return new DataLoader(csvController);
  }

  public static class DataLoader implements ApplicationRunner {

    private CsvController csvController;

    @Autowired
    public DataLoader(CsvController csvController) {
      this.csvController = csvController;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
      csvController.loadCsv(Paths.get("/home/phuonghoang/projects/personal/data-loader/test_data.csv"), CsvType.CAPITAL_ONE_FORMAT);
      csvController.loadCsv(Paths.get("/home/phuonghoang/projects/personal/data-loader/rbc_transactions.csv"), CsvType.RBC_FORMAT);
      System.out.println("Got the task running");
    }
  }

}
