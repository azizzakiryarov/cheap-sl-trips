package se.azza.cheapsltrips.ticket;

import lombok.Getter;

@Getter
public enum ULTicketsAdditionalDiscount {

    RESTILLFRANUPPSALA("Resa till/från Uppsala (Zon 1,2,5)", 60),
    TILLAGTILLSLRABATTERADTILLFRANUPPSALA("Billjet gäller för resa i zon 1, 2 och 5 i Uppsala län. Lägg till SL-billjet, rabatterad", 20),
    RESTILLFRANKNIVSTA("Resa till/från Knivsta (Zon 2,5)", 40),
    TILLAGTILLSLRABATTERADTILLFRANKNIVSTA("Billjet gäller för resa i zon 2 och 5 i Uppsala län. Billjet måste kombineras med en giltig SL-billjet. " +
            "Lägg till SL-billjet, rabatterad", 22);

    private final String name;
    private final int price;

    ULTicketsAdditionalDiscount(String name, int price) {
        this.name = name;
        this.price = price;
    }
}
