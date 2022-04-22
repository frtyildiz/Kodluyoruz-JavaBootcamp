package com.firat.flightReservation.requestDto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UpdateFlightRequestDto {

    private int id;

    private LocalDate date;
}
