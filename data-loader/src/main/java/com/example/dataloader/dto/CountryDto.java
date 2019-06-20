package com.example.dataloader.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDate;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CountryDto {

  @JsonProperty(value = "WORLDWIDE")
  private String worldWide;
  @JsonProperty(value = "AFRICA")
  private String africa;
  @JsonProperty(value = "NORTH AMERICA")
  private String northAmerica;
  @JsonProperty(value = "LATIN AMERICA")
  private String latinAmerica;
  @JsonProperty(value = "THE CARIBBEAN")
  private String theCaribbean;
  @JsonProperty(value = "SOUTH EAST EUROPE")
  private String southEastEurope;
  @JsonProperty(value = "NORTH EAST EUROPE")
  private String northEastEurope;
  @JsonProperty(value = "SOUTH WEST EUROPE")
  private String southWestEurope;
  @JsonProperty(value = "NORTH WEST EUROPE")
  private String northWestEurope;
  @JsonProperty(value = "NORDICS")
  private String nordics;
  @JsonProperty(value = "MIDDLE EAST")
  private String middleEast;
  @JsonProperty(value = "OCEANIA")
  private String oceania;
  @JsonProperty(value = "CENTRAL ASIA")
  private String centralAsia;
  @JsonProperty(value = "EAST ASIA")
  private String eastAsia;
  @JsonProperty(value = "SOUTH ASIA")
  private String southAsia;
  @JsonProperty(value = "SOUTHEAST ASIA")
  private String southEastAsia;
  @JsonProperty(value = "NORTH ASIA")
  private String northAsia;
}