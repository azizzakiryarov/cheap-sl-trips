package se.azza.cheapsltrips.ticket;

import lombok.Getter;

@Getter
public enum SLTicketsAdult {

    ENKELBILLJET("Enkelbilljet", 43),
    TJUGOFYRATIMMARSBILLJET("24-timmarsbilljet", 180),
    SJUTTIOTVATIMMARSBILLJET("72-timmarsbilljet", 360),
    SJUDAGARSBILLJET("7-dagarsbilljet", 470),
    TRETTIODAGARSBILLJET("30-dagarsbilljet", 1060),
    NITTIODAGARSBILLJET("90-dagarsbilljet", 3070),
    ARSBILLJET("Årsbilljet", 11130),

    PENDELTAGTILLFRANARLANDAC("Pendeltåg till/från Arlanda C", 147),
    TILLAGTILLSLVUXEN("Lägg till SL-billjet, vuxen", 43);

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
