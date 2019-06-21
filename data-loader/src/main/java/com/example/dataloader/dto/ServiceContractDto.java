package com.example.dataloader.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ServiceContractDto {

  @JsonProperty(value = "Legal Name")
  private String legalName;
  @JsonProperty(value = "Territory(ies) Included in Contract")
  private String territories;
  @JsonProperty(value = "Applicable Countries")
  private String applicableCountries;
  @JsonProperty(value = "Territory Notes")
  private String territoryNotes;
}
