package se.azza.cheapsltrips.calendar;

import lombok.Getter;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

@Getter
public enum SwedishHolidays {

    NYARSDAGEN(LocalDate.of(LocalDate.now().getYear(), 1, 1), "Nyårsdagen"),
    TRETTONDEDAG(LocalDate.of(LocalDate.now().getYear(), 1, 6), "Trettondedag"),
    LANGFREDAG(LocalDate.of(LocalDate.now().getYear(), 4, 7), "Långfredagen"),
    PASKDAGEN(LocalDate.of(LocalDate.now().getYear(), 4, 9), "Påskdagen"),
    ANNANDAGPASK(LocalDate.of(LocalDate.now().getYear(), 4, 10), "Annandag påsk"),
    FORSTAMAJ(LocalDate.of(LocalDate.now().getYear(), 5, 1), "Första maj"),
    KRISTIHIMMELFARDSDAG(LocalDate.of(LocalDate.now().getYear(), 5, 18), "Kristi himmelsfärdsdag"),
    PINGSTDAGEN(LocalDate.of(LocalDate.now().getYear(), 5, 28), "Pingstdagen"),
    NATIONALDAGEN(LocalDate.of(LocalDate.now().getYear(), 6, 6), "Nationaldagen"),
    MIDSOMMARAFTON(LocalDate.of(LocalDate.now().getYear(), 6, 24), "Midsommardagen"),
    ALLAHELGONSDAG(LocalDate.of(LocalDate.now().getYear(), 11, 4), "Alla helgons dag"),
    JULDAGEN(LocalDate.of(LocalDate.now().getYear(), 12, 25), "Jul dagen"),
    ANNANDAGJUL(LocalDate.of(LocalDate.now().getYear(), 12, 26), "Annan dag jul");

    private final LocalDate holiday;
    private final String nameOfHoliday;

    SwedishHolidays(LocalDate holiday, String nameOfHoliday) {
        this.holiday = holiday;
        this.nameOfHoliday = nameOfHoliday;
    }

    public static List<LocalDate> getListOfSwedishHolidays(){
        return Stream.of(SwedishHolidays.values())
                .map(SwedishHolidays::getHoliday)
                .collect(toList());
    }
}