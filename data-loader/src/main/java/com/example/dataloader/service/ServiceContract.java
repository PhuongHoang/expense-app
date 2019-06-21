package com.example.dataloader.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ServiceContract {

  private String legalName;
  private List<String> territories;
  private String applicableCountries;
  private List<String> territoryNotes;

  public ServiceContract(String legalName, String territories, String applicableCountries,
      String territoryNotes) {
    this.legalName = legalName;
    this.territories = Arrays.stream(territories.split(",")).collect(Collectors.toList());
    this.applicableCountries = applicableCountries;
    this.territoryNotes = territoryNotes.lines().filter(line -> !line.isBlank())
        .collect(Collectors.toList());
  }
}
