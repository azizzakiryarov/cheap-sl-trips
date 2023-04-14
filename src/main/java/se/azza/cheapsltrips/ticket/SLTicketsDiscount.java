package se.azza.cheapsltrips.ticket;

import lombok.Getter;

@Getter
public enum SLTicketsDiscount {

    ENKELBILLJET("Enkelbilljet", 26),
    TJUGOFYRATIMMARSBILLJET("24-timmarsbilljet", 110),
    SJUTTIOTVATIMMARSBILLJET("72-timmarsbilljet", 220),
    SJUDAGARSBILLJET("7-dagarsbilljet", 290),
    TRETTIODAGARSBILLJET("30-dagarsbilljet", 650),
    NITTIODAGARSBILLJET("90-dagarsbilljet", 1880),
    ARSBILLJET("Årsbilljet", 6830),

    PENDELTAGTILLFRANARLANDAC("Pendeltåg till/från Arlanda C", 132),
    TILLAGTILLSLRABATTERADTILLFRANARLANDAC("Billjet gäller för resa i zon 1, 2 och 5 i Uppsala län. Lägg till SL-billjet, rabatterad", 26);

    private final String name;
    private final int price;

    SLTicketsDiscount(String name, int price) {
        this.name = name;
        this.price = price;
    }
}
