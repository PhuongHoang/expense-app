package com.example.dataloader.mappers;

import com.example.data.entities.TransactionEntity;
import com.example.data.repositories.TransactionEntityRepository;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DescriptionMapper {

  private TransactionEntityRepository transactionEntityRepository;
  private Map<String, TransactionEntity> actorMap = new HashMap<>();

  @Autowired
  public DescriptionMapper(TransactionEntityRepository transactionEntityRepository) {
    this.transactionEntityRepository = transactionEntityRepository;
    transactionEntityRepository.findAll().iterator()
        .forEachRemaining(entity -> actorMap.put(entity.getName().toLowerCase(), entity));
  }

  public TransactionEntity toTransactionEntity(String description) {
    final String lowerCaseDescription = description.toLowerCase();
    return actorMap.keySet().stream().filter(lowerCaseDescription::contains).findAny()
        .map(key -> actorMap.get(key))
        .orElseThrow(() -> new IllegalStateException("Cannot find mapping for " + description));
  }

}
