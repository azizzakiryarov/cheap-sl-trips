package se.azza.cheapsltrips.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.azza.cheapsltrips.service.SLTicketsAdultServiceImpl;
import se.azza.cheapsltrips.service.SLTicketsDiscountServiceImpl;
import se.azza.cheapsltrips.service.SLTicketsTuristServiceImpl;
import se.azza.cheapsltrips.traveler.Traveler;

@RestController
@RequestMapping("api/v1/tickets")
public class TicketsController {

    private final SLTicketsAdultServiceImpl slTicketsAdultService;
    private final SLTicketsDiscountServiceImpl slTicketsDiscountService;
    private final SLTicketsTuristServiceImpl slTicketsTuristServiceImpl;

    public TicketsController(SLTicketsAdultServiceImpl slTicketsAdultService,
                             SLTicketsDiscountServiceImpl slTicketsDiscountService,
                             SLTicketsTuristServiceImpl slTicketsTuristServiceImpl) {
        this.slTicketsAdultService = slTicketsAdultService;
        this.slTicketsDiscountService = slTicketsDiscountService;
        this.slTicketsTuristServiceImpl = slTicketsTuristServiceImpl;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping(path = "/suggestion/adult", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getRightSuggestionForAdult(@RequestBody Traveler traveler) {
        return slTicketsAdultService.getRightSuggestionForAdult(traveler);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping(path = "/suggestion/discounted", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getRightSuggestionForDiscounted(@RequestBody Traveler traveler) {
        return slTicketsDiscountService.getRightSuggestionForDiscounted(traveler);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping(path = "/suggestion/turist", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getRightSuggestionForTurist(@RequestBody Traveler traveler) {
        return slTicketsTuristServiceImpl.getRightSuggestionForTurist(traveler);
    }
}