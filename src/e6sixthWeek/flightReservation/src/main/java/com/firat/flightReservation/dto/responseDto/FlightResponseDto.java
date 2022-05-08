package com.firat.flightReservation.dto.responseDto;

import lombok.Data;

@Data
public class FlightResponseDto {

    private String to;

    private String from;

    private double price;

    private int capacity;

}
