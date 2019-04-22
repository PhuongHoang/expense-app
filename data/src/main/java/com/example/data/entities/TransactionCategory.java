package com.example.data.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

@Data
@NoArgsConstructor
@Entity
public class TransactionCategory extends EntityWithUUID {

  @Nullable
  @OneToOne
  private TransactionCategory parentCategory;
  @Column(name = "category_type")
  private String categoryType;

  public TransactionCategory(@Nullable TransactionCategory parentCategory, String categoryType) {
    this.parentCategory = parentCategory;
    this.categoryType = categoryType;
  }

  public TransactionCategory(String categoryType) {
    this.categoryType = categoryType;
  }
}
