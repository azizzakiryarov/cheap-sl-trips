package se.azza.cheapsltrips.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Consequence {
    private int priceInAMonth;
    private int amountOfMoneyToSaveOrLoseForOneMonth;
    private int amountOfMoneyToSaveOrLoseForOneYear;
}