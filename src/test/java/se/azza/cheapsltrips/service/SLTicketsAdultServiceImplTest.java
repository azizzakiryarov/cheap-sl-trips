package se.azza.cheapsltrips.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import se.azza.cheapsltrips.ticket.SLTicketsAdult;
import se.azza.cheapsltrips.traveler.City;
import se.azza.cheapsltrips.traveler.Traveler;
import se.azza.cheapsltrips.traveler.Type;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;
import static se.azza.cheapsltrips.utilities.CheckTypeOfTraveler.isAdult;

class SLTicketsAdultServiceImplTest {

    private SLTicketsAdultServiceImpl slTicketsAdultServiceImpl;

    @BeforeEach
    void setUp() {
        SwedishHolidaysServiceImpl swedishHolidaysServiceImpl = new SwedishHolidaysServiceImpl();
        slTicketsAdultServiceImpl = new SLTicketsAdultServiceImpl(swedishHolidaysServiceImpl);

    }

    @Test
    void verifyThatGetRightSuggestionForAdultThrownIllegalArgumentExceptionIfTravelerIsNull() {

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            slTicketsAdultServiceImpl.getRightSuggestionForAdult(null);
        });

        String expectedMessage = "Traveler object is null!";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void verifyThatGetRightSuggestionForAdultReturnResponseBodyBadRequestIfTravelerAgeIsLessThanTwentyOrGreaterThanSixtyFive() {

        ResponseEntity<String> expectedResponseEntity = ResponseEntity.badRequest().body("Age should be between 20 and 65 to travel with Adult ticket!");

        Traveler newTraveler = createNewTraveler(19,
                City.STOCKHOLM,
                Type.ADULT,
                2,
                2,
                LocalDate.of(LocalDate.now().getYear(), 4, 1),
                LocalDate.of(LocalDate.now().getYear(), 4, 30));

        ResponseEntity<?> actualResponseEntity = slTicketsAdultServiceImpl.getRightSuggestionForAdult(newTraveler);

        Assertions.assertEquals(expectedResponseEntity, actualResponseEntity);
    }

    @Test
    void verifyThatGetRightSuggestionForAdultReturnResponseBodyOkWithNewSuggestionEnkelbilljetTypeAnd39Price() {

        Traveler newTraveler = createNewTraveler(20,
                City.STOCKHOLM,
                Type.ADULT,
                2,
                2,
                LocalDate.of(LocalDate.now().getYear(), 4, 1),
                LocalDate.of(LocalDate.now().getYear(), 4, 30));

        ResponseEntity<?> expectedResponseEntity = ResponseEntity.ok(slTicketsAdultServiceImpl.buildNewSuggestion(
                newTraveler,
                SLTicketsAdult.ENKELBILLJET.getName(),
                SLTicketsAdult.ENKELBILLJET.getPrice(),
                SLTicketsAdult.ENKELBILLJET.getPrice()));

        ResponseEntity<?> actualResponseEntity = slTicketsAdultServiceImpl.getRightSuggestionForAdult(newTraveler);
        Assertions.assertEquals(expectedResponseEntity, actualResponseEntity);

        Traveler newTraveler2 = createNewTraveler(20,
                City.STOCKHOLM,
                Type.ADULT,
                3,
                1,
                LocalDate.of(LocalDate.now().getYear(), 4, 1),
                LocalDate.of(LocalDate.now().getYear(), 4, 30));

        ResponseEntity<?> expectedResponseEntity2 = ResponseEntity.ok(slTicketsAdultServiceImpl.buildNewSuggestion(
                newTraveler2,
                SLTicketsAdult.ENKELBILLJET.getName(),
                SLTicketsAdult.ENKELBILLJET.getPrice(),
                SLTicketsAdult.ENKELBILLJET.getPrice()));

        ResponseEntity<?> actualResponseEntity2 = slTicketsAdultServiceImpl.getRightSuggestionForAdult(newTraveler2);
        Assertions.assertEquals(expectedResponseEntity2, actualResponseEntity2);

        Traveler newTraveler3 = createNewTraveler(20,
                City.STOCKHOLM,
                Type.ADULT,
                4,
                1,
                LocalDate.of(LocalDate.now().getYear(), 4, 1),
                LocalDate.of(LocalDate.now().getYear(), 4, 30));

        ResponseEntity<?> expectedResponseEntity3 = ResponseEntity.ok(slTicketsAdultServiceImpl.buildNewSuggestion(
                newTraveler3,
                SLTicketsAdult.ENKELBILLJET.getName(),
                SLTicketsAdult.ENKELBILLJET.getPrice(),
                SLTicketsAdult.ENKELBILLJET.getPrice()));

        ResponseEntity<?> actualResponseEntity3 = slTicketsAdultServiceImpl.getRightSuggestionForAdult(newTraveler3);
        Assertions.assertEquals(expectedResponseEntity3, actualResponseEntity3);


    }

    @Test
    void verifyThatTravelerIsAdultAndReturnTrue() {
        Traveler newTraveler = createNewTraveler(20,
                City.STOCKHOLM,
                Type.ADULT,
                4,
                1,
                LocalDate.of(LocalDate.now().getYear(), 4, 1),
                LocalDate.of(LocalDate.now().getYear(), 4, 30));

        Traveler newTraveler2 = createNewTraveler(64,
                City.STOCKHOLM,
                Type.ADULT,
                4,
                1,
                LocalDate.of(LocalDate.now().getYear(), 4, 1),
                LocalDate.of(LocalDate.now().getYear(), 4, 30));

        Assertions.assertTrue(isAdult(newTraveler));
        Assertions.assertTrue(isAdult(newTraveler2));
    }

    @Test
    void verifyThatTravelerIsNotAdultAndReturnFalse() {
        Traveler newTraveler = createNewTraveler(19,
                City.STOCKHOLM,
                Type.DISCOUNTED,
                4,
                1,
                LocalDate.of(LocalDate.now().getYear(), 4, 1),
                LocalDate.of(LocalDate.now().getYear(), 4, 30));

        Traveler newTraveler2 = createNewTraveler(65,
                City.STOCKHOLM,
                Type.DISCOUNTED,
                4,
                1,
                LocalDate.of(LocalDate.now().getYear(), 4, 1),
                LocalDate.of(LocalDate.now().getYear(), 4, 30));

        Assertions.assertFalse(isAdult(newTraveler));
        Assertions.assertFalse(isAdult(newTraveler2));
    }

    @Test
    void isDiscounted() {
    }

    @Test
    void isTurist() {
    }

    @Test
    void countTotalPriceInAMonth() {
    }

    @Test
    void countAmountOfMoneyToSaveOrLoseForOneMonth() {
    }

    private Traveler createNewTraveler(int age,
                                       City city,
                                       Type typeOfTraveler,
                                       int amountOfTripsForOneDay,
                                       int amountWorkDaysInAOffice,
                                       LocalDate startDate,
                                       LocalDate endDate) {
        Traveler newTraveler = new Traveler();
        newTraveler.setAge(age);
        newTraveler.setCity(city);
        newTraveler.setTypeOfTraveler(typeOfTraveler);
        newTraveler.setAmountOfTurnAndReturnTimesInOneDay(amountOfTripsForOneDay);
        newTraveler.setAmountOfTripDays(amountWorkDaysInAOffice);
        newTraveler.setStartDate(startDate);
        newTraveler.setEndDate(endDate);
        return newTraveler;
    }
}