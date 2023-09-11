package se.azza.cheapsltrips.utilities;

import se.azza.cheapsltrips.traveler.Traveler;
import se.azza.cheapsltrips.traveler.Type;

public class CheckTypeOfTraveler {

    private CheckTypeOfTraveler() {
    }

    public static boolean isAdult(Traveler traveler) {
        return traveler.getAge() > 19 && traveler.getAge() <= 64;
    }

    public static boolean isDiscounted(Traveler traveler) {
        return traveler.getAge() < 20 || traveler.getAge() >= 65;
    }

    public static boolean isTurist(Traveler traveler) {
        return traveler.getTypeOfTraveler().name().equals(Type.TURIST.name());
    }
}