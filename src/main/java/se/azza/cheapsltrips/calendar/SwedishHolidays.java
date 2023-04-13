package se.azza.cheapsltrips.calendar;

import lombok.Data;
import lombok.Getter;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Getter
public enum SwedishHolidays {

    NYARSDAGEN(LocalDate.of(2023, 1, 1), "Nyårsdagen"),
    TRETTONDEDAG(LocalDate.of(2023, 1, 6), "Trettondedag"),
    LANGFREDAG(LocalDate.of(2023, 4, 7), "Långfredagen"),
    PASKDAGEN(LocalDate.of(2023, 4, 9), "Påskdagen"),
    ANNANDAGPASK(LocalDate.of(2023, 4, 10), "Annandag påsk"),
    FORSTAMAJ(LocalDate.of(2023, 5, 1), "Första maj"),
    KRISTIHIMMELFARDSDAG(LocalDate.of(2023, 5, 18), "Kristi himmelsfärdsdag"),
    PINGSTDAGEN(LocalDate.of(2023, 5, 28), "Pingstdagen"),
    NATIONALDAGEN(LocalDate.of(2023, 1, 6), "Nationaldagen"),
    MIDSOMMARAFTON(LocalDate.of(2023, 1, 24), "Midsommardagen"),
    ALLAHELGONSDAG(LocalDate.of(2023, 11, 4), "Alla helgons dag"),
    JULDAGEN(LocalDate.of(2023, 12, 25), "Jul dagen"),
    ANNANDAGJUL(LocalDate.of(2023, 12, 26), "Annan dag jul"),
    NYARSAFTON(LocalDate.of(2023, 12, 31), "Nyårsafton");

    private final LocalDate holiday;
    private final String nameOfHoliday;

    SwedishHolidays(LocalDate holiday, String nameOfHoliday) {
        this.holiday = holiday;
        this.nameOfHoliday = nameOfHoliday;
    }
}