package com.firat.flightReservation.service;

import com.firat.flightReservation.converter.FlightConverter;
import com.firat.flightReservation.entity.Flight;
import com.firat.flightReservation.entity.Pegasus;
import com.firat.flightReservation.entity.THY;
import com.firat.flightReservation.repository.FlightRepository;
import com.firat.flightReservation.requestDto.SaveFlightRequestDto;
import com.firat.flightReservation.requestDto.UpdateFlightRequestDto;
import com.firat.flightReservation.responseDto.FlightResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FlightService {

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    FlightConverter flightConverter;

    public Integer saveThyFlight(SaveFlightRequestDto saveFlightRequestDto) {
        THY thy = flightConverter.convertToThyFromsaveFlightRequestDto(saveFlightRequestDto);

        thy = flightRepository.save(thy);

        return thy.getId();
    }

    public Integer savePegasusFlight(SaveFlightRequestDto saveFlightRequestDto) {
        Pegasus pegasus = flightConverter.convertToPegasusFromSaveFlightRequestDto(saveFlightRequestDto);

        pegasus = flightRepository.save(pegasus);

        return pegasus.getId();
    }

    public List<FlightResponseDto> findAllFlight() {

        Iterable<Flight> flights = flightRepository.findAll();

        List<FlightResponseDto> flightResponseDtos = new ArrayList<>();

        for (Flight flight : flights)
        {

            String flightTo = flight.getTo();
            String flightFrom = flight.getFrom();
            double flightPrice = flight.getPrice();
            int flightCapacity = flight.getCapacity();

            FlightResponseDto flightResponseDto = new FlightResponseDto();

            flightResponseDto.setTo(flightTo);
            flightResponseDto.setFrom(flightFrom);
            flightResponseDto.setPrice(flightPrice);
            flightResponseDto.setCapacity(flightCapacity);

            flightResponseDtos.add(flightResponseDto);

        }
        return flightResponseDtos;
    }

    public boolean deleteFlightById(Integer flightId) {
        Flight flight = flightRepository.findById(flightId).get();
        flightRepository.delete(flight);
        return true;
    }

    public void updateDateFlightTHY(UpdateFlightRequestDto updateFlightRequestDto) {
        int flightIdRequest = updateFlightRequestDto.getId();
        LocalDate flightDateRequest = updateFlightRequestDto.getDate();

        Optional<Flight> flightOptional = flightRepository.findById(flightIdRequest);
        THY thy = new THY();

        thy.setDate(flightDateRequest);
        flightRepository.save(thy);
    }

    public void updateDateFlightPegasus(UpdateFlightRequestDto updateFlightRequestDto) {
        int flightRequestId = updateFlightRequestDto.getId();
        LocalDate flightDateRequest = updateFlightRequestDto.getDate();

        Optional<Flight> flightOptional = flightRepository.findById(flightRequestId);
        Pegasus pegasus = new Pegasus();

        pegasus.setDate(flightDateRequest);
        flightRepository.save(pegasus);
    }
}
