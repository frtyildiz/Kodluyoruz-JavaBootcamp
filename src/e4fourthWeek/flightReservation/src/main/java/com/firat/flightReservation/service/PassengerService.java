package com.firat.flightReservation.service;

import com.firat.flightReservation.converter.PassengerConverter;
import com.firat.flightReservation.entity.Passenger;
import com.firat.flightReservation.repository.PassengerRepository;
import com.firat.flightReservation.requestDto.SavePassengerRequestDto;
import com.firat.flightReservation.requestDto.UpdatePassengerRequestDto;
import com.firat.flightReservation.responseDto.PassengerResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PassengerService {

    @Autowired
    PassengerRepository passengerRepository;

    @Autowired
    PassengerConverter passengerConverter;


    public Integer saveThyPassenger(SavePassengerRequestDto savePassengerRequestDto) {
        Passenger passenger = passengerConverter.convertToThyPassengerFromSavePassengerRequestDto(savePassengerRequestDto);

        passenger = passengerRepository.save(passenger);

        return passenger.getId();
    }

    public Integer savePegasusPassenger(SavePassengerRequestDto savePassengerRequestDto) {
        Passenger passenger = passengerConverter.convertToPegasusPassengerFromSavePassengerRequestDto(savePassengerRequestDto);

        passenger = passengerRepository.save(passenger);

        return passenger.getId();
    }

    public List<PassengerResponseDto> findAllPassenger() {

        Iterable<Passenger> passengers = passengerRepository.findAll();

        List<PassengerResponseDto> passengerResponseDtos = new ArrayList<>();

        for (Passenger passenger : passengers)
        {

            String passengerName = passenger.getName();
            String passengerLastname = passenger.getLastname();
            int passengerAge = passenger.getAge();

            PassengerResponseDto passengerResponseDto = new PassengerResponseDto();

            passengerResponseDto.setName(passengerName);
            passengerResponseDto.setLastname(passengerLastname);
            passengerResponseDto.setAge(passengerAge);

            passengerResponseDtos.add(passengerResponseDto);
        }
        return passengerResponseDtos;
    }

    public boolean deletePassengerById(Integer passengerId) {

        Passenger passenger = passengerRepository.findById(passengerId).get();
        passengerRepository.delete(passenger);
        return true;
    }

    public void updatePassengerNameById(UpdatePassengerRequestDto updatePassengerRequestDto) {
        int passengerIdRequest = updatePassengerRequestDto.getId();
        String passengerNameRequest = updatePassengerRequestDto.getName();

        Optional<Passenger> optionalPassenger = passengerRepository.findById(passengerIdRequest);
        Passenger passenger = optionalPassenger.get();

        passenger.setName(passengerNameRequest);
        passengerRepository.save(passenger);
    }

    public void updatePassengerLastnameById(UpdatePassengerRequestDto updatePassengerRequestDto) {
        int passengerIdRequest = updatePassengerRequestDto.getId();
        String passengerLastnameRequest = updatePassengerRequestDto.getLastname();

        Optional<Passenger> optionalPassenger = passengerRepository.findById(passengerIdRequest);
        Passenger passenger = optionalPassenger.get();

        passenger.setLastname(passengerLastnameRequest);
        passengerRepository.save(passenger);
    }
}
