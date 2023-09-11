package se.azza.cheapsltrips.traveler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Traveler {

    private int age;
    private City city;
    private Type typeOfTraveler;
    private int amountOfTripDays;
    private int amountOfTurnAndReturnTimesInOneDay;
    private LocalDate startDate;
    private LocalDate endDate;
}