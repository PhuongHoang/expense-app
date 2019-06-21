package com.example.dataloader.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDate;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CountryDto {

  public static final String WORLD_WIDE = "WORLDWIDE";
  public static final String AFRICA = "AFRICA";
  public static final String NORTH_AFRICA = "NORTH AFRICA";
  public static final String NORTH_AMERICA = "NORTH AMERICA";
  public static final String SOUTH_AMERICA = "SOUTH AMERICA";
  public static final String LATIN_AMERICA = "LATIN AMERICA";
  public static final String THE_CARIBBEAN = "THE CARIBBEAN";
  public static final String SOUTH_EAST_EUROPE = "SOUTH EAST EUROPE";
  public static final String NORTH_EAST_EUROPE = "NORTH EAST EUROPE";
  public static final String SOUTH_WEST_EUROPE = "SOUTH WEST EUROPE";
  public static final String NORTH_WEST_EUROPE = "NORTH WEST EUROPE";
  public static final String NORDICS = "NORDICS";
  public static final String MIDDLE_EAST = "MIDDLE EAST";
  public static final String OCEANIA = "OCEANIA";
  public static final String CENTRAL_ASIA = "CENTRAL ASIA";
  public static final String EAST_ASIA = "EAST ASIA";
  public static final String SOUTH_ASIA = "SOUTH ASIA";
  public static final String SOUTH_EAST_ASIA = "SOUTHEAST ASIA";
  public static final String NORTH_ASIA = "NORTH ASIA";

  @JsonProperty(value = WORLD_WIDE)
  private String worldWide;
  @JsonProperty(value = AFRICA)
  private String africa;
  @JsonProperty(value = NORTH_AFRICA)
  private String northAfrica;
  @JsonProperty(value = NORTH_AMERICA)
  private String northAmerica;
  @JsonProperty(value = SOUTH_AMERICA)
  private String southAmerica;
  @JsonProperty(value = LATIN_AMERICA)
  private String latinAmerica;
  @JsonProperty(value = THE_CARIBBEAN)
  private String theCaribbean;
  @JsonProperty(value = SOUTH_EAST_EUROPE)
  private String southEastEurope;
  @JsonProperty(value = NORTH_EAST_EUROPE)
  private String northEastEurope;
  @JsonProperty(value = SOUTH_WEST_EUROPE)
  private String southWestEurope;
  @JsonProperty(value = NORTH_WEST_EUROPE)
  private String northWestEurope;
  @JsonProperty(value = NORDICS)
  private String nordics;
  @JsonProperty(value = MIDDLE_EAST)
  private String middleEast;
  @JsonProperty(value = OCEANIA)
  private String oceania;
  @JsonProperty(value = CENTRAL_ASIA)
  private String centralAsia;
  @JsonProperty(value = EAST_ASIA)
  private String eastAsia;
  @JsonProperty(value = SOUTH_ASIA)
  private String southAsia;
  @JsonProperty(value = SOUTH_EAST_ASIA)
  private String southEastAsia;
  @JsonProperty(value = NORTH_ASIA)
  private String northAsia;
}