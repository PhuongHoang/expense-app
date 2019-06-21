package com.example.dataloader;

import com.example.data.NoOpClass;
import com.example.dataloader.CsvController.CsvType;
import java.nio.file.Paths;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.configuration.EnableTask;
import org.springframework.context.annotation.Bean;

@EnableTask
@SpringBootApplication(scanBasePackageClasses = {NoOpClass.class, CsvController.class})
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
//      csvController.loadCsv(Paths.get("test_data.csv"), CsvType.CAPITAL_ONE_FORMAT);
//      csvController.loadCsv(Paths.get("rbc_transactions.csv"), CsvType.RBC_FORMAT);
      csvController.loadCsv(Paths.get("List_of_Countries_by_Region_21.05.csv"), CsvType.COUNTRY_FORMAT);
      csvController.loadCsv(Paths.get("ServiceContractItem_UK_territories.csv"), CsvType.SERVICE_CONTRACT);
      System.out.println("Got the task running");
    }
  }

}
