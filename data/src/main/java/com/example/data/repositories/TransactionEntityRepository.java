package com.example.data.repositories;

import com.example.data.entities.TransactionEntity;
import java.util.UUID;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TransactionEntityRepository extends
    PagingAndSortingRepository<TransactionEntity, UUID> {

}
