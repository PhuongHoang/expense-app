package com.example.data.entities;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@Entity
public class Transaction {

  @Setter(AccessLevel.PRIVATE)
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
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
