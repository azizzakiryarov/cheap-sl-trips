package se.azza.cheapsltrips.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import se.azza.cheapsltrips.dto.Consequence;
import se.azza.cheapsltrips.dto.Solution;
import se.azza.cheapsltrips.dto.Suggestion;
import se.azza.cheapsltrips.ticket.SLTicketsDiscount;
import se.azza.cheapsltrips.traveler.City;
import se.azza.cheapsltrips.traveler.Traveler;

import java.util.Objects;

import static se.azza.cheapsltrips.utilities.CheckTypeOfTraveler.isAdult;
import static se.azza.cheapsltrips.utilities.CheckTypeOfTraveler.isDiscounted;

@Slf4j
@Service
public class SLTicketsDiscountServiceImpl implements SLTicketsDiscountService{
    @Override
    public ResponseEntity<?> getRightSuggestionForDiscounted(Traveler traveler) {

        ResponseEntity<Suggestion> newSuggestion = null;

        if (Objects.isNull(traveler)) {
            throw new IllegalArgumentException("Traveler object is null!");
        }

        if (isAdult(traveler)) {
            return ResponseEntity.badRequest().body("Age should be before 19 or more then 65 to travel with Discounted ticket!");
        }

        if (isDiscounted(traveler) && traveler.getCity().name().equals(City.STOCKHOLM.name())) {
            if ((traveler.getAmountOfTurnAndReturnTimesInOneDay() <= 2 && traveler.getAmountOfTripDays() <= 3) ||
                    (traveler.getAmountOfTurnAndReturnTimesInOneDay() < 5 && traveler.getAmountOfTripDays() == 1)) {
                newSuggestion = ResponseEntity.ok(buildNewSuggestion(
                        traveler,
                        SLTicketsDiscount.ENKELBILLJET.getName(),
                        SLTicketsDiscount.ENKELBILLJET.getPrice(),
                        SLTicketsDiscount.ENKELBILLJET.getPrice()));
            } else if (traveler.getAmountOfTurnAndReturnTimesInOneDay() > 4 && traveler.getAmountOfTripDays() == 1) {
                newSuggestion = ResponseEntity.ok(buildNewSuggestion(
                        traveler,
                        SLTicketsDiscount.TJUGOFYRATIMMARSBILLJET.getName(),
                        SLTicketsDiscount.TJUGOFYRATIMMARSBILLJET.getPrice(),
                        SLTicketsDiscount.ENKELBILLJET.getPrice()));
            } else {
                newSuggestion = ResponseEntity.ok(buildNewSuggestion(
                        traveler,
                        SLTicketsDiscount.TRETTIODAGARSBILLJET.getName(),
                        SLTicketsDiscount.TRETTIODAGARSBILLJET.getPrice(),
                        SLTicketsDiscount.ENKELBILLJET.getPrice()));
            }
        }
        return newSuggestion;
    }

    public Suggestion buildNewSuggestion(Traveler traveler, String ticketName, int ticketPrice, int consequencePrice) {
        Suggestion newSuggestion = Suggestion.builder()
                .solution(Solution.builder().typeOfTicket(ticketName).price(ticketPrice).build())
                .consequence(Consequence.builder().priceInAMonth(countTotalPriceInAMonth(traveler.getAmountOfTurnAndReturnTimesInOneDay(), traveler.getAmountOfTripDays(), consequencePrice)).build())
                .build();

        newSuggestion.getConsequence().setAmountOfMoneyToSaveOrLoseForOneMonth(countAmountOfMoneyToSaveOrLoseForOneMonth(newSuggestion));
        newSuggestion.getConsequence().setAmountOfMoneyToSaveOrLoseForOneYear(newSuggestion.getConsequence().getAmountOfMoneyToSaveOrLoseForOneMonth() * 12);

        return newSuggestion;
    }

    public int countTotalPriceInAMonth(int amountOfTripsForOneDay, int workDaysInAOffice, int price) {
        return ((workDaysInAOffice * amountOfTripsForOneDay) * price) * 4;
    }

    public int countAmountOfMoneyToSaveOrLoseForOneMonth(Suggestion suggestion) {
        return SLTicketsDiscount.TRETTIODAGARSBILLJET.getPrice() - suggestion.getConsequence().getPriceInAMonth();
    }
}
