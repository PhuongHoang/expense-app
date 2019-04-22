package com.example.data.entities;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Transaction extends EntityWithUUID {

  @OneToOne
  private TransactionCategory category;
  private double amount;
  @OneToOne
  private TransactionEntity recipient;
  private LocalDate transactionDate;
  private String accountNumber;

  public Transaction(double amount, TransactionEntity recipient,
      LocalDate transactionDate, TransactionCategory category, String accountNumber) {
    this.amount = amount;
    this.recipient = recipient;
    this.transactionDate = transactionDate;
    this.category = category;
    this.accountNumber = accountNumber;
  }
}
