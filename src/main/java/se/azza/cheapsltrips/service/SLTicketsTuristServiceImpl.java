package se.azza.cheapsltrips.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import se.azza.cheapsltrips.traveler.Traveler;
import se.azza.cheapsltrips.traveler.Type;

@Service
public class SLTicketsTuristServiceImpl implements SLTicketsTuristService{
    @Override
    public ResponseEntity<?> getRightSuggestionForTurist(Traveler traveler) {
        return null;
    }


}