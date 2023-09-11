package se.azza.cheapsltrips.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.azza.cheapsltrips.service.SLTicketsAdultServiceImpl;
import se.azza.cheapsltrips.service.SLTicketsDiscountServiceImpl;
import se.azza.cheapsltrips.service.SwedishHolidaysServiceImpl;
import se.azza.cheapsltrips.traveler.Traveler;

import java.time.LocalDate;
import java.util.Optional;

import static se.azza.cheapsltrips.calendar.SwedishHolidays.getListOfSwedishHolidays;

@RestController
@RequestMapping("api/v1/holidays")
public class SwedishHolidaysController {

    private final SwedishHolidaysServiceImpl swedishHolidaysServiceImpl;

    public SwedishHolidaysController(SwedishHolidaysServiceImpl swedishHolidaysServiceImpl) {
        this.swedishHolidaysServiceImpl = swedishHolidaysServiceImpl;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getRightSuggestionForAdult(@RequestParam(value = "startDate") LocalDate startDate, @RequestParam(value = "endDate") LocalDate endDate) {
        return swedishHolidaysServiceImpl.countBusinessDaysBetweenStartDateAndEndDate(startDate, endDate);
    }
}