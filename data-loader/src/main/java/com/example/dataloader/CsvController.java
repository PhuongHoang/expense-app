package com.example.dataloader;

import com.example.dataloader.service.CapitalOneService;
import com.example.dataloader.service.RoyalBankService;
import java.io.IOException;
import java.nio.file.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class CsvController {

  private CapitalOneService capitalOneService;
  private RoyalBankService royalBankService;

  @Autowired
  public CsvController(CapitalOneService capitalOneService,
      RoyalBankService royalBankService) {
    this.capitalOneService = capitalOneService;
    this.royalBankService = royalBankService;
  }

  public void loadCsv(Path csvPath, CsvType csvType) throws IOException {
    switch (csvType) {
      case RBC_FORMAT:
        royalBankService.loadCsv(csvPath);
        break;
      case CAPITAL_ONE_FORMAT:
        capitalOneService.loadCsv(csvPath);
        break;
      default:
        throw new IllegalArgumentException("Unhandled type");
    }
  }

  public enum CsvType {
    RBC_FORMAT,
    CAPITAL_ONE_FORMAT
  }
}
