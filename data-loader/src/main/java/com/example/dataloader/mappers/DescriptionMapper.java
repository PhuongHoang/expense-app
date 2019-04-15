package com.example.dataloader.mappers;

import com.example.data.entities.TransactionCategory;
import com.example.data.entities.TransactionCategory.Type;
import com.example.data.entities.TransactionEntity;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

@Component
public class DescriptionMapper {

  private Map<String, TransactionEntity> actorMap = new HashMap<>();

  public DescriptionMapper() {
    actorMap.computeIfAbsent("FOOD BASICS".toLowerCase(),
        key -> new TransactionEntity(key, new TransactionCategory(Type.GROCERY)));
    actorMap.computeIfAbsent("PRODUCE DEPOT".toLowerCase(),
        key -> new TransactionEntity(key, new TransactionCategory(Type.GROCERY)));
    actorMap.computeIfAbsent("KOWLOON MARKET".toLowerCase(),
        key -> new TransactionEntity(key, new TransactionCategory(Type.GROCERY)));
    actorMap.computeIfAbsent("REXALL PHARMACY".toLowerCase(),
        key -> new TransactionEntity(key, new TransactionCategory(Type.DRUGS)));
    actorMap.computeIfAbsent("COSTCO WHOLESALE".toLowerCase(),
        key -> new TransactionEntity(key, new TransactionCategory(Type.GROCERY)));
    actorMap.computeIfAbsent("COSTCO GAS".toLowerCase(),
        key -> new TransactionEntity(key, new TransactionCategory(Type.GAS)));
    actorMap.computeIfAbsent("TIM HORTONS".toLowerCase(),
        key -> new TransactionEntity(key, new TransactionCategory(Type.DINING)));
    actorMap.computeIfAbsent("CHEO FOUNDATION PARKIN".toLowerCase(),
        key -> new TransactionEntity(key, new TransactionCategory(Type.PARKING)));
    actorMap.computeIfAbsent("TSI INTERNET".toLowerCase(),
        key -> new TransactionEntity(key, new TransactionCategory(Type.INTERNET)));
    actorMap.computeIfAbsent("T&T SUPERMARKET".toLowerCase(),
        key -> new TransactionEntity(key, new TransactionCategory(Type.GROCERY)));
    actorMap.computeIfAbsent("VIDEOTRON S.E.N.C.".toLowerCase(),
        key -> new TransactionEntity(key, new TransactionCategory(Type.PHONE)));
    actorMap.computeIfAbsent("ONT-GOVT-BIRTH/OTHER C".toLowerCase(),
        key -> new TransactionEntity(key, new TransactionCategory(Type.OTHER_SERVICES)));
    actorMap.computeIfAbsent("TOYS \"\"R\"\" US".toLowerCase(),
        key -> new TransactionEntity(key, new TransactionCategory(Type.SHOPPING)));
    actorMap.computeIfAbsent("OTTAWA HOSPITAL - GENE".toLowerCase(),
        key -> new TransactionEntity(key, new TransactionCategory(Type.PARKING)));
    actorMap.computeIfAbsent("BEST BUY".toLowerCase(),
        key -> new TransactionEntity(key, new TransactionCategory(Type.SHOPPING)));
    actorMap.computeIfAbsent("SUBWAY".toLowerCase(),
        key -> new TransactionEntity(key, new TransactionCategory(Type.DINING)));
    actorMap.computeIfAbsent("IMPARK00110024U".toLowerCase(),
        key -> new TransactionEntity(key, new TransactionCategory(Type.PARKING)));
    actorMap.computeIfAbsent("PAYMENT".toLowerCase(),
        key -> new TransactionEntity(key, new TransactionCategory(Type.CREDIT_PAYMENT)));
    actorMap.computeIfAbsent("THE HOME DEPOT".toLowerCase(),
        key -> new TransactionEntity(key, new TransactionCategory(Type.SHOPPING)));
    actorMap.computeIfAbsent("WAL-MART".toLowerCase(),
        key -> new TransactionEntity(key, new TransactionCategory(Type.GROCERY)));
    actorMap.computeIfAbsent("WMT SUPRCTR".toLowerCase(),
        key -> actorMap.get("WAL-MART".toLowerCase()));
    actorMap.computeIfAbsent("IKEA OTTAWA".toLowerCase(),
        key -> new TransactionEntity(key, new TransactionCategory(Type.SHOPPING)));
    actorMap.computeIfAbsent("METRO".toLowerCase(),
        key -> new TransactionEntity(key, new TransactionCategory(Type.GROCERY)));
    actorMap.computeIfAbsent("MCDONALD'S".toLowerCase(),
        key -> new TransactionEntity(key, new TransactionCategory(Type.DINING)));
    actorMap.computeIfAbsent("CHATIME".toLowerCase(),
        key -> new TransactionEntity(key, new TransactionCategory(Type.DINING)));
    actorMap.computeIfAbsent("RA-BAYSHORE".toLowerCase(),
        key -> new TransactionEntity(key, new TransactionCategory(Type.SHOPPING)));
    actorMap.computeIfAbsent("PANDA GARDEN".toLowerCase(),
        key -> new TransactionEntity(key, new TransactionCategory(Type.DINING)));
    actorMap.computeIfAbsent("ACMS".toLowerCase(),
        key -> new TransactionEntity(key, new TransactionCategory(Type.SALARY)));
    actorMap.computeIfAbsent("LIM BANGKOK".toLowerCase(),
        key -> new TransactionEntity(key, new TransactionCategory(Type.GROCERY)));
    actorMap.computeIfAbsent("PHUOC LOI".toLowerCase(),
        key -> new TransactionEntity(key, new TransactionCategory(Type.GROCERY)));
    actorMap.computeIfAbsent("MUTUAL FUNDS".toLowerCase(),
        key -> new TransactionEntity(key, new TransactionCategory(Type.SAVING)));
    actorMap.computeIfAbsent("BELAIR INS/ASS.".toLowerCase(),
        key -> new TransactionEntity(key, new TransactionCategory(Type.INSURANCE)));
    actorMap.computeIfAbsent("MCAP - RMG MTG".toLowerCase(),
        key -> new TransactionEntity(key, new TransactionCategory(Type.MORTGAGE)));
    actorMap.computeIfAbsent("OTT WTR & SEWER".toLowerCase(),
        key -> new TransactionEntity(key, new TransactionCategory(Type.WATER_PAYMENT)));
    actorMap.computeIfAbsent("OTTAWA WATER".toLowerCase(),
        key -> actorMap.get("OTT WTR & SEWER".toLowerCase()));
    actorMap.computeIfAbsent("HYDRO OTTAWA".toLowerCase(),
        key -> new TransactionEntity(key, new TransactionCategory(Type.HYDRO_PAYMENT)));
    actorMap.computeIfAbsent("ENBRIDGE".toLowerCase(),
        key -> new TransactionEntity(key, new TransactionCategory(Type.HEATING)));
    actorMap.computeIfAbsent("ENBRIDGE GAS".toLowerCase(),
        key -> actorMap.get("ENBRIDGE".toLowerCase()));
    actorMap.computeIfAbsent("CAPITAL ONE".toLowerCase(),
        key -> new TransactionEntity(key, new TransactionCategory(Type.CREDIT_PAYMENT)));
    actorMap.computeIfAbsent("MONTHLY FEE".toLowerCase(),
        key -> new TransactionEntity(key, new TransactionCategory(Type.OTHER_SERVICES)));
    actorMap.computeIfAbsent("MULTIPRODUCT REBATE".toLowerCase(),
        key -> new TransactionEntity(key, new TransactionCategory(Type.OTHER_SERVICES)));
    actorMap.computeIfAbsent("WWW TRF DDA".toLowerCase(),
        key -> new TransactionEntity(key, new TransactionCategory(Type.SAVING)));
    actorMap.computeIfAbsent("INTERAC E-TRF".toLowerCase(),
        key -> new TransactionEntity(key, new TransactionCategory(Type.OTHER_SERVICES)));
    actorMap.computeIfAbsent("ITEM RETURNED NSF".toLowerCase(),
        key -> new TransactionEntity(key, new TransactionCategory(Type.OTHER_SERVICES)));
    actorMap.computeIfAbsent("NSF ITEM FEE".toLowerCase(),
        key -> new TransactionEntity(key, new TransactionCategory(Type.OTHER_SERVICES)));
    actorMap.computeIfAbsent("PTB DEP".toLowerCase(),
        key -> new TransactionEntity(key, new TransactionCategory(Type.OTHER_SERVICES)));
    actorMap.computeIfAbsent("E-TRF AUTODEPOSIT".toLowerCase(),
        key -> new TransactionEntity(key, new TransactionCategory(Type.OTHER_SERVICES)));

  }

  public TransactionEntity toTransactionEntity(String description) {
    final String lowerCaseDescription = description.toLowerCase();
    return actorMap.keySet().stream().filter(lowerCaseDescription::contains).findAny()
        .map(key -> actorMap.get(key))
        .orElseThrow(() -> new IllegalStateException("Cannot find mapping for " + description));
  }

}
