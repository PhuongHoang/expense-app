package com.example.expensetracker;

import com.example.data.NoOpClass;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackageClasses = NoOpClass.class)
@EnableJpaRepositories(basePackageClasses = NoOpClass.class)
public class ExpenseTrackerApplication {

  public static void main(String[] args) {
    SpringApplication.run(ExpenseTrackerApplication.class, args);
  }
}