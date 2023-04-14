package se.azza.cheapsltrips.utilities;

public class CheckLeapYear {

    public static boolean isLeapYear(int year) {
        assert year >= 1583; // not valid before this date.
        return ((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0);
    }
}