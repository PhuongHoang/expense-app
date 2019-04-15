package com.example.dataloader.mappers;

import com.example.dataloader.dto.RoyalBankTransactionDto;
import com.example.data.entities.Transaction;
import com.example.data.entities.TransactionEntity;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@NoArgsConstructor
public abstract class RoyalBankMapperDecorator implements RoyalBankTransactionMapper {

  @Autowired
  @Qualifier("delegate")
  private RoyalBankTransactionMapper delegate;
  @Autowired
  private DescriptionMapper descriptionMapper;


  @Override
  public Transaction toTransaction(RoyalBankTransactionDto dto) {
    Transaction transaction = delegate.toTransaction(dto);
    final TransactionEntity transactionEntity = descriptionMapper
        .toTransactionEntity(dto.getDescription1() + " " + dto.getDescription2());
    transaction.setRecipient(transactionEntity);
    transaction.setCategory(transactionEntity.getDefaultCategory());
    return transaction;
  }
}
