package com.firat.flightReservation.dto.requestDto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UpdateFlightRequestDto {

    private int id;

    private LocalDate date;
}
