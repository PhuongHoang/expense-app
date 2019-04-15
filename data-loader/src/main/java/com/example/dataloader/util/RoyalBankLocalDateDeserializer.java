package com.example.dataloader.util;

import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

public class RoyalBankLocalDateDeserializer extends LocalDateDeserializer {

  private static final DateTimeFormatter FORMATTER = new DateTimeFormatterBuilder().
      appendOptional(DateTimeFormatter.ofPattern("MM/dd/yyyy"))
      .appendOptional(DateTimeFormatter.ofPattern("M/d/yyyy"))
      .appendOptional(DateTimeFormatter.ofPattern("M/dd/yyyy"))
      .appendOptional(DateTimeFormatter.ofPattern("MM/d/yyyy"))
      .toFormatter();

  public RoyalBankLocalDateDeserializer() {
    this(FORMATTER);
  }

  public RoyalBankLocalDateDeserializer(DateTimeFormatter dtf) {
    super(dtf);
  }
}
