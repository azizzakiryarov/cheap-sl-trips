package se.azza.cheapsltrips.service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import static java.util.stream.Collectors.toList;

public class SwedishHolidaysServiceImpl implements SwedishHolidaysService {

    @Override
    public List<LocalDate> countBusinessDaysBetween(final LocalDate startDate,
                                                    final LocalDate endDate,
                                                    final Optional<List<LocalDate>> holidays) {

        if (startDate == null || endDate == null) {
            throw new IllegalArgumentException("Invalid method argument(s) to countBusinessDaysBetween (" + startDate + "," + endDate + "," + holidays + ")");
        }

        Predicate<LocalDate> isHoliday = date -> holidays.isPresent() && holidays.get().contains(date);
        Predicate<LocalDate> isWeekend = date -> date.getDayOfWeek() == DayOfWeek.SATURDAY || date.getDayOfWeek() == DayOfWeek.SUNDAY;
        return startDate.datesUntil(endDate.plusDays(1))
                .filter(isWeekend.or(isHoliday).negate())
                .collect(toList());
    }
}