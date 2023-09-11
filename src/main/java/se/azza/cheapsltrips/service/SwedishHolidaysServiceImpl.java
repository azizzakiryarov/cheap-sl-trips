package se.azza.cheapsltrips.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import static java.util.stream.Collectors.toList;
import static se.azza.cheapsltrips.calendar.SwedishHolidays.getListOfSwedishHolidays;

@Service
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

    public ResponseEntity<?> countBusinessDaysBetweenStartDateAndEndDate(LocalDate startDate, LocalDate endDate) {
        return ResponseEntity.ok(countBusinessDaysBetween(startDate, endDate, Optional.of(getListOfSwedishHolidays())).size());
    }
}