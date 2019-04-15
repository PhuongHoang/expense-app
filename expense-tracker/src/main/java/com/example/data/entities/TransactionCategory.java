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
import org.springframework.lang.Nullable;

@Data
@NoArgsConstructor
@Entity
public class TransactionCategory {

  @Setter(AccessLevel.PRIVATE)
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  @Nullable
  @OneToOne
  private TransactionCategory parentCategory;
  private Type type;

  public TransactionCategory(@Nullable TransactionCategory parentCategory, Type type) {
    this.parentCategory = parentCategory;
    this.type = type;
  }

  public TransactionCategory(Type type) {
    this.type = type;
  }

  public enum Type {
    SALARY,
    SAVING,
    GROCERY,
    DRUGS,
    GAS,
    INTERNET,
    PHONE,
    INSURANCE,
    MORTGAGE,
    WATER_PAYMENT,
    HYDRO_PAYMENT,
    HEATING,
    SHOPPING,
    DINING,
    PARKING,
    OTHER_SERVICES,
    CREDIT_PAYMENT
  }
}
