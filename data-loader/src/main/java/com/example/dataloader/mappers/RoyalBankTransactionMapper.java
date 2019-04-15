package com.example.dataloader.mappers;

import com.example.dataloader.dto.RoyalBankTransactionDto;
import com.example.data.entities.Transaction;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
@DecoratedWith(RoyalBankMapperDecorator.class)
public interface RoyalBankTransactionMapper {

  @Mapping(source = "amountInCAD", target = "amount")
  @Mapping(target = "recipient", ignore = true)
  @Mapping(target = "category", ignore = true)
  Transaction toTransaction(RoyalBankTransactionDto dto);
}