package com.example.dataloader.dto;

import com.example.dataloader.util.RoyalBankLocalDateDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.time.LocalDate;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RoyalBankTransactionDto {

  @JsonProperty(value = "Account Type")
  private String accountType;
  @JsonProperty(value = "Account Number")
  private String accountNumber;
  @JsonDeserialize(using = RoyalBankLocalDateDeserializer.class)
  @JsonProperty(value = "Transaction Date")
  private LocalDate transactionDate;
  @JsonProperty(value = "Cheque Number")
  private String chequeNumber;
  @JsonProperty(value = "Description 1")
  private String description1;
  @JsonProperty(value = "Description 2")
  private String description2;
  @JsonProperty(value = "CAD$")
  private double amountInCAD;
  @JsonProperty(value = "USD$")
  private double amountInUSD;
}
