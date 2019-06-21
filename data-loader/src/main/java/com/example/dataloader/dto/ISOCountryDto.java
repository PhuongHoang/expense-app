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
public class ISOCountryDto {

  @JsonProperty(value = "Code")
  private String countryCode;
  @JsonProperty(value = "Name")
  private String countryName;
}
