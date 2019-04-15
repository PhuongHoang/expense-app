package com.example.data.repositories;

import com.example.data.entities.TransactionCategory;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TransactionCategoryRepository extends
    PagingAndSortingRepository<TransactionCategory, Long> {

}
