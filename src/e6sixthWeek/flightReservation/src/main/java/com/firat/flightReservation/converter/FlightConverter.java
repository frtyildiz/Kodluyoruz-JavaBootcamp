package com.firat.flightReservation.converter;

import com.firat.flightReservation.entity.Pegasus;
import com.firat.flightReservation.entity.THY;
import com.firat.flightReservation.dto.requestDto.SaveFlightRequestDto;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;

@Component
public class FlightConverter {

    public THY convertToThyFromsaveFlightRequestDto (SaveFlightRequestDto saveFlightRequestDto)
    {
        int capacityRequestDto = saveFlightRequestDto.getCapacity();
        String fromRequestDto = saveFlightRequestDto.getFrom();
        String toRequestDto = saveFlightRequestDto.getTo();
        double priceRequestDto = saveFlightRequestDto.getPrice();
        LocalDate dateRequestDto = saveFlightRequestDto.getDate();
        LocalTime timeRequestDto = saveFlightRequestDto.getTime();
        int businessSeatRequestDto = saveFlightRequestDto.getBusinessSeat();

        THY thy = new THY();

        thy.setCapacity(capacityRequestDto);
        thy.setFrom(fromRequestDto);
        thy.setTo(toRequestDto);
        thy.setPrice(priceRequestDto);
        thy.setDate(dateRequestDto);
        thy.setTime(timeRequestDto);
        thy.setBusinessSeat(businessSeatRequestDto);

        return thy;
    }

    public Pegasus convertToPegasusFromSaveFlightRequestDto (SaveFlightRequestDto saveFlightRequestDto)
    {
        int capacityRequestDto = saveFlightRequestDto.getCapacity();
        String fromRequestDto = saveFlightRequestDto.getFrom();
        String toRequestDto = saveFlightRequestDto.getTo();
        double priceRequestDto = saveFlightRequestDto.getPrice();
        LocalDate dateRequestDto = saveFlightRequestDto.getDate();
        LocalTime timeRequestDto = saveFlightRequestDto.getTime();
        int businessSeatRequestDto = saveFlightRequestDto.getBusinessSeat();

        Pegasus pegasus = new Pegasus();

        pegasus.setCapacity(capacityRequestDto);
        pegasus.setFrom(fromRequestDto);
        pegasus.setTo(toRequestDto);
        pegasus.setPrice(priceRequestDto);
        pegasus.setDate(dateRequestDto);
        pegasus.setTime(timeRequestDto);
        pegasus.setBusinessSeat(businessSeatRequestDto);

        return pegasus;
    }


}
