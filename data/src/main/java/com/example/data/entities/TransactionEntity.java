package com.example.data.entities;

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
public class TransactionEntity {

  @Setter(AccessLevel.PRIVATE)
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String name;
  @OneToOne
  private TransactionCategory defaultCategory;

  public TransactionEntity(String name, TransactionCategory defaultCategory) {
    this.name = name;
    this.defaultCategory = defaultCategory;
  }
}
