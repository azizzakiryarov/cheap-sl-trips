package se.azza.cheapsltrips.traveler;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Traveler {

    private int age;
    private Type typeOfTraveler;
    private int amountWorkDays;
    private boolean isLivingInStokholmCity;
    private boolean isLivingInUppsalaCity;
    private LocalDate tripDate;
    private int amountOfTrips;
}