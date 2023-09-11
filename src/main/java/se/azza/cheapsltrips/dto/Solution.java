package se.azza.cheapsltrips.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Solution {
    private String typeOfTicket;
    private int price;
}