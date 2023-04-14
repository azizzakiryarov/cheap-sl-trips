package se.azza.cheapsltrips.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface SwedishHolidaysService {

    List<LocalDate> countBusinessDaysBetween(final LocalDate startDate,
                                 final LocalDate endDate,
                                 final Optional<List<LocalDate>> holidays);
}