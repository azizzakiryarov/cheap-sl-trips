package se.azza.cheapsltrips.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Suggestion {
    private Solution solution;
    private Consequence consequence;
}