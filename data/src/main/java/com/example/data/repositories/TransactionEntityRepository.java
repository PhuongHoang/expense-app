package com.example.data.repositories;

import com.example.data.entities.TransactionEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TransactionEntityRepository extends
    PagingAndSortingRepository<TransactionEntity, Long> {

}
