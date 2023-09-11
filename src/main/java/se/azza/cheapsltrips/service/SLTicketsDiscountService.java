package se.azza.cheapsltrips.service;

import org.springframework.http.ResponseEntity;
import se.azza.cheapsltrips.traveler.Traveler;

public interface SLTicketsDiscountService {
    ResponseEntity<?> getRightSuggestionForDiscounted(Traveler traveler);
}
