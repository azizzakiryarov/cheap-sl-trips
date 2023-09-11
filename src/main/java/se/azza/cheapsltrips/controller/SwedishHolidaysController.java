package se.azza.cheapsltrips.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.azza.cheapsltrips.service.SwedishHolidaysServiceImpl;
import java.time.LocalDate;

@RestController
@RequestMapping("api/v1/holidays")
public class SwedishHolidaysController {

    private final SwedishHolidaysServiceImpl swedishHolidaysServiceImpl;

    public SwedishHolidaysController(SwedishHolidaysServiceImpl swedishHolidaysServiceImpl) {
        this.swedishHolidaysServiceImpl = swedishHolidaysServiceImpl;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public ResponseEntity<?> getRightSuggestionForAdult(@RequestParam(value = "startDate") LocalDate startDate, @RequestParam(value = "endDate") LocalDate endDate) {
        return swedishHolidaysServiceImpl.countBusinessDaysBetweenStartDateAndEndDate(startDate, endDate);
    }
}