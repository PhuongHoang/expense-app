package com.example.dataloader.service;

import com.example.dataloader.dto.ISOCountryDto;
import java.util.Map;
import java.util.Set;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class RegionCountryRegistry {

  private Map<String, Set<ISOCountryDto>> regionNameToCountryMap;

}
