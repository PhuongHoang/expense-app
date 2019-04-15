package com.example.dataloader.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDate;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CapitalOneTransactionDto {

  @JsonProperty(value = "Transaction Date")
  private LocalDate transactionDate;
  @JsonProperty(value = "Posted Date")
  private LocalDate postedDate;
  @JsonProperty(value = "Card No.")
  private int cardNumber;
  @JsonProperty(value = "Description")
  private String description;
  @JsonProperty(value = "Category")
  private String category;
  @JsonProperty(value = "Debit")
  private double debit;
  @JsonProperty(value = "Credit")
  private double credit;
}