package se.azza.cheapsltrips.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.time.Month;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static se.azza.cheapsltrips.calendar.SwedishHolidays.getListOfSwedishHolidays;

class SwedishHolidaysImplTest {

    private SwedishHolidaysServiceImpl swedishHolidaysImpl;
    @BeforeEach
    void setUp() {
        swedishHolidaysImpl = new SwedishHolidaysServiceImpl();
    }

    @Test
    void verifyThatCountingOfBusinessDaysBetweenTwoDatesIsCorrect() {

        LocalDate startDateJanuari1 = LocalDate.of(LocalDate.now().getYear(), Month.JANUARY, 1);
        LocalDate endDateJanuari31 = LocalDate.of(LocalDate.now().getYear(), Month.JANUARY, 31);
        assertEquals(21, swedishHolidaysImpl.countBusinessDaysBetween(
                startDateJanuari1, 
                endDateJanuari31,
                Optional.of(getListOfSwedishHolidays())).size());

        LocalDate startDateFebruari1 = LocalDate.of(LocalDate.now().getYear(), Month.FEBRUARY, 1);
        LocalDate endDateFebruari28 = LocalDate.of(LocalDate.now().getYear(), Month.FEBRUARY, 28);
        assertEquals(20, swedishHolidaysImpl.countBusinessDaysBetween(
                startDateFebruari1,
                endDateFebruari28,
                Optional.of(getListOfSwedishHolidays())).size());

        LocalDate startDateMarch1 = LocalDate.of(LocalDate.now().getYear(), Month.MARCH, 1);
        LocalDate endDateMarch28 = LocalDate.of(LocalDate.now().getYear(), Month.MARCH, 31);
        assertEquals(21, swedishHolidaysImpl.countBusinessDaysBetween(
                startDateMarch1,
                endDateMarch28,
                Optional.of(getListOfSwedishHolidays())).size());

        LocalDate startDateApril1 = LocalDate.of(LocalDate.now().getYear(), Month.APRIL, 1);
        LocalDate endDateApril30 = LocalDate.of(LocalDate.now().getYear(), Month.APRIL, 30);
        assertEquals(19, swedishHolidaysImpl.countBusinessDaysBetween(
                startDateApril1,
                endDateApril30,
                Optional.of(getListOfSwedishHolidays())).size());

        LocalDate startDateMay1 = LocalDate.of(LocalDate.now().getYear(), Month.MAY, 1);
        LocalDate endDateMay31 = LocalDate.of(LocalDate.now().getYear(), Month.MAY, 31);
        assertEquals(20, swedishHolidaysImpl.countBusinessDaysBetween(
                startDateMay1,
                endDateMay31,
                Optional.of(getListOfSwedishHolidays())).size());

        LocalDate startDateJune1 = LocalDate.of(LocalDate.now().getYear(), Month.JUNE, 1);
        LocalDate endDateJune30 = LocalDate.of(LocalDate.now().getYear(), Month.JUNE, 30);
        assertEquals(19, swedishHolidaysImpl.countBusinessDaysBetween(
                startDateJune1,
                endDateJune30,
                Optional.of(getListOfSwedishHolidays())).size());

        LocalDate startDateJuly1 = LocalDate.of(LocalDate.now().getYear(), Month.JULY, 1);
        LocalDate endDateJuly31 = LocalDate.of(LocalDate.now().getYear(), Month.JULY, 31);
        assertEquals(23, swedishHolidaysImpl.countBusinessDaysBetween(
                startDateJuly1,
                endDateJuly31,
                Optional.of(getListOfSwedishHolidays())).size());

        LocalDate startDateAugust1 = LocalDate.of(LocalDate.now().getYear(), Month.AUGUST, 1);
        LocalDate endDateAugust31 = LocalDate.of(LocalDate.now().getYear(), Month.AUGUST, 31);
        assertEquals(21, swedishHolidaysImpl.countBusinessDaysBetween(
                startDateAugust1,
                endDateAugust31,
                Optional.of(getListOfSwedishHolidays())).size());

        LocalDate startDateSeptember1 = LocalDate.of(LocalDate.now().getYear(), Month.SEPTEMBER, 1);
        LocalDate endDateSeptember30 = LocalDate.of(LocalDate.now().getYear(), Month.SEPTEMBER, 30);
        assertEquals(22, swedishHolidaysImpl.countBusinessDaysBetween(
                startDateSeptember1,
                endDateSeptember30,
                Optional.of(getListOfSwedishHolidays())).size());

        LocalDate startDateOctober1 = LocalDate.of(LocalDate.now().getYear(), Month.OCTOBER, 1);
        LocalDate endDateOctober31 = LocalDate.of(LocalDate.now().getYear(), Month.OCTOBER, 31);
        assertEquals(23, swedishHolidaysImpl.countBusinessDaysBetween(
                startDateOctober1,
                endDateOctober31,
                Optional.of(getListOfSwedishHolidays())).size());

        LocalDate startDateNovember1 = LocalDate.of(LocalDate.now().getYear(), Month.NOVEMBER, 1);
        LocalDate endDateNovember30 = LocalDate.of(LocalDate.now().getYear(), Month.NOVEMBER, 30);
        assertEquals(19, swedishHolidaysImpl.countBusinessDaysBetween(
                startDateNovember1,
                endDateNovember30,
                Optional.of(getListOfSwedishHolidays())).size());

        LocalDate startDateDecember1 = LocalDate.of(LocalDate.now().getYear(), Month.DECEMBER, 1);
        LocalDate endDateDecember31 = LocalDate.of(LocalDate.now().getYear(), Month.DECEMBER, 31);
        assertEquals(21, swedishHolidaysImpl.countBusinessDaysBetween(
                startDateDecember1,
                endDateDecember31,
                Optional.of(getListOfSwedishHolidays())).size());
    }
}