package com.example.dataloader.mappers;

import com.example.dataloader.dto.CapitalOneTransactionDto;
import com.example.data.entities.Transaction;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = DescriptionMapper.class)
public interface CapitalOneTransactionMapper {

  @Mapping(source = "cardNumber", target = "accountNumber")
  @Mapping(target = "amount", expression = "java( Math.abs(dto.getCredit() - dto.getDebit()) )")
  @Mapping(target = "category", expression = "java( transaction.getRecipient().getDefaultCategory() )")
  @Mapping(source = "description", target = "recipient")
  Transaction toTransaction(CapitalOneTransactionDto dto);
}
