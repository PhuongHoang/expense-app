package com.example.expensetracker;

import com.example.data.NoOpClass;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackageClasses = NoOpClass.class)
public class ExpenseTrackerApplication {

  public static void main(String[] args) {
    SpringApplication.run(ExpenseTrackerApplication.class, args);
  }
}