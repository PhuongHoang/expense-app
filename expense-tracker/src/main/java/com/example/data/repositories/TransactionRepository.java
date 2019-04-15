package com.example.data.repositories;

import com.example.data.entities.Transaction;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TransactionRepository extends PagingAndSortingRepository<Transaction, Long> {

}
