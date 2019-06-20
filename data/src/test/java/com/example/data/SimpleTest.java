package com.example.data;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.data.repositories.TransactionRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@DataJpaTest
public class SimpleTest {

  private TestEntityManager entityManager;
  private TransactionRepository repository;

  @Autowired
  SimpleTest(TestEntityManager entityManager, TransactionRepository repository) {
    this.entityManager = entityManager;
    this.repository = repository;
  }

  @DisplayName("Simple test for demo")
  @Test
  void runTest() {
    assertEquals(2, 1 + 1, "1 + 1 must be 2");
  }

}
