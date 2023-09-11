package se.azza.cheapsltrips.ticket;

import lombok.Getter;

@Getter
public enum SLTicketsAdult {

    ENKELBILLJET("Enkelbilljet", 39),
    TJUGOFYRATIMMARSBILLJET("24-timmarsbilljet", 165),
    SJUTTIOTVATIMMARSBILLJET("72-timmarsbilljet", 330),
    SJUDAGARSBILLJET("7-dagarsbilljet", 430),
    TRETTIODAGARSBILLJET("30-dagarsbilljet", 970),
    NITTIODAGARSBILLJET("90-dagarsbilljet", 2810),
    ARSBILLJET("Årsbilljet", 10190),

    PENDELTAGTILLFRANARLANDAC("Pendeltåg till/från Arlanda C", 132),
    TILLAGTILLSLVUXEN("Lägg till SL-billjet, vuxen", 39);

    private final String name;
    private final int price;

    SLTicketsAdult(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public static SLTicketsAdult valueOfSLTicketsAdult(String name) {
        for (SLTicketsAdult typ : values()) {
            if (typ.getName().equals(name)) {
                return typ;
            }
        }
        throw new IllegalArgumentException("No matching SLTicketsAdult found for name=" + name);
    }
}
