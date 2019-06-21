package com.example.dataloader.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum RegionDto {

  WORLD_WIDE(CountryDto.WORLD_WIDE),
  AFRICA(CountryDto.AFRICA),
  NORTH_AFRICA(CountryDto.NORTH_AFRICA),
  NORTH_AMERICA(CountryDto.NORTH_AMERICA),
  SOUTH_AMERICA(CountryDto.SOUTH_AMERICA),
  LATIN_AMERICA(CountryDto.LATIN_AMERICA),
  THE_CARIBBEAN(CountryDto.THE_CARIBBEAN),
  SOUTH_EAST_EUROPE(CountryDto.SOUTH_EAST_EUROPE),
  NORTH_EAST_EUROPE(CountryDto.NORTH_EAST_EUROPE),
  SOUTH_WEST_EUROPE(CountryDto.SOUTH_WEST_EUROPE),
  NORTH_WEST_EUROPE(CountryDto.NORTH_WEST_EUROPE),
  NORDICS(CountryDto.NORDICS),
  MIDDLE_EAST(CountryDto.MIDDLE_EAST),
  OCEANIA(CountryDto.OCEANIA),
  CENTRAL_ASIA(CountryDto.CENTRAL_ASIA),
  EAST_ASIA(CountryDto.EAST_ASIA),
  SOUTH_ASIA(CountryDto.SOUTH_ASIA),
  SOUTH_EAST_ASIA(CountryDto.SOUTH_EAST_ASIA),
  NORTH_ASIA(CountryDto.NORTH_ASIA);

  private final String regionName;
}
