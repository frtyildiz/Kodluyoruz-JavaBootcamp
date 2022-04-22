package com.firat.flightReservation.requestDto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class SaveFlightRequestDto {

    private String to;

    private String from;

    private double price;

    private int capacity;

    private LocalDate date;

    private LocalTime time;

    private int businessSeat;
}
