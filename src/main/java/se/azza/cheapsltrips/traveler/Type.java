package se.azza.cheapsltrips.traveler;

import lombok.Getter;

@Getter
public enum Type {
    ADULT("Vuxen, som fyllt i 20 men inte 65 år"),
    DISCOUNTED("Ungdomar, pensionär, som fyllt i 65 år eller som är under 20 år, och för studenter med giltig svensk studentlegitimation med SL-logotyp"),
    TURIST("Turist som kom på besök till Sverige");

    private final String description;

    Type(String description) {
        this.description = description;
    }
}