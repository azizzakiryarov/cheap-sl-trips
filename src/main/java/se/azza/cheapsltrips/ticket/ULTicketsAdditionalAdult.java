package se.azza.cheapsltrips.ticket;

import lombok.Getter;

@Getter
public enum ULTicketsAdditionalAdult {

    RESTILLFRANUPPSALA("Resa till/från Uppsala (Zon 1,2,5)", 99),
    TILLAGTILLSLVUXENTILLFRANUPPSALA("Billjet gäller för resa i zon 1, 2 och 5 i Uppsala län. Lägg till SL-billjet, vuxen", 24),
    RESTILLFRANKNIVSTA("Resa till/från Knivsta (Zon 2,5)", 66),
    TILLAGTILLSLVUXENTILLFRANKNIVSTA("Billjet gäller för resa i zon 2 och 5 i Uppsala län. Billjet måste kombineras med en giltig SL-billjet. " +
            "Lägg till SL-billjet, vuxen", 29);

    private final String name;
    private final int price;

    ULTicketsAdditionalAdult(String name, int price) {
        this.name = name;
        this.price = price;
    }
}
