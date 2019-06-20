package com.example.dataloader;

import com.example.dataloader.service.CapitalOneService;
import com.example.dataloader.service.CountryService;
import com.example.dataloader.service.RoyalBankService;
import java.io.IOException;
import java.nio.file.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class CsvController {

  private CapitalOneService capitalOneService;
  private RoyalBankService royalBankService;
  private CountryService countryService;

  @Autowired
  public CsvController(CapitalOneService capitalOneService,
      RoyalBankService royalBankService, CountryService countryService) {
    this.capitalOneService = capitalOneService;
    this.royalBankService = royalBankService;
    this.countryService = countryService;
  }

  public void loadCsv(Path csvPath, CsvType csvType) throws IOException {
    switch (csvType) {
      case RBC_FORMAT:
        royalBankService.loadCsv(csvPath);
        break;
      case CAPITAL_ONE_FORMAT:
        capitalOneService.loadCsv(csvPath);
        break;
      case COUNTRY_FORMAT:
        countryService.loadCsv(csvPath);
        break;
      default:
        throw new IllegalArgumentException("Unhandled categoryType");
    }
  }

  public enum CsvType {
    RBC_FORMAT,
    CAPITAL_ONE_FORMAT,
    COUNTRY_FORMAT;
  }
}
