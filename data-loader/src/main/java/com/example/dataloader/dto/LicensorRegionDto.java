package com.example.dataloader.dto;

import java.util.Map;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LicensorRegionDto {

  private String licensorName;
  private Map<String, Set<Country>> regionTerritoryMap;

  @Getter
  @Setter
  @EqualsAndHashCode
  @AllArgsConstructor
  @NoArgsConstructor
  public static class Country {

    private String countryCode;
    private String countryName;
  }
}
