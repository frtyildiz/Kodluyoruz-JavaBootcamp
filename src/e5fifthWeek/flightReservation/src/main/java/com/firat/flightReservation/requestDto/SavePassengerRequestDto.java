package com.firat.flightReservation.requestDto;

import lombok.Data;


@Data
public class SavePassengerRequestDto {

    private String name;

    private String lastname;

    private int age;

    private boolean isBusiness;

    private int suitcaseWeight;

    public boolean getIsBusiness() {
        return isBusiness;
    }
}
