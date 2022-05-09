package com.firat.flightReservation.service;

import com.firat.flightReservation.converter.PassengerConverter;
import com.firat.flightReservation.dto.requestDto.SavePassengerRequestDto;
import com.firat.flightReservation.entity.Flight;
import com.firat.flightReservation.entity.Passenger;
import com.firat.flightReservation.repository.PassengerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PassengerServiceTest {

    @InjectMocks
    PassengerService passengerService;

    @Mock
    PassengerRepository passengerRepository;

    @Mock
    PassengerConverter passengerConverter;

    @Test
    void saveThyPassenger()
    {
        SavePassengerRequestDto savePassengerRequestDtoMock = mock(SavePassengerRequestDto.class);
        savePassengerRequestDtoMock.setName("testName");
        savePassengerRequestDtoMock.setLastname("testLastName");
        savePassengerRequestDtoMock.setAge(25);
        savePassengerRequestDtoMock.setBusiness(true);
        savePassengerRequestDtoMock.setSuitcaseWeight(1);

        Passenger passengerMock = mock(Passenger.class);
        passengerMock.setId(1);

        when(passengerConverter.convertToThyPassengerFromSavePassengerRequestDto(savePassengerRequestDtoMock))
                .thenReturn(passengerMock);
        when(passengerRepository.save(passengerMock)).thenReturn(passengerMock);

        Integer passengerId = passengerService.saveThyPassenger(savePassengerRequestDtoMock);
        assertEquals(passengerMock.getId(), passengerId);
    }

    @Test
    void savePegasusPassenger()
    {
        SavePassengerRequestDto savePassengerRequestDtoMock = mock(SavePassengerRequestDto.class);
        savePassengerRequestDtoMock.setName("testName");
        savePassengerRequestDtoMock.setLastname("testLastName");
        savePassengerRequestDtoMock.setAge(25);
        savePassengerRequestDtoMock.setBusiness(true);
        savePassengerRequestDtoMock.setSuitcaseWeight(1);

        Passenger passengerMock = mock(Passenger.class);
        passengerMock.setId(1);

        when(passengerConverter.convertToPegasusPassengerFromSavePassengerRequestDto(savePassengerRequestDtoMock))
                .thenReturn(passengerMock);
        when(passengerRepository.save(passengerMock)).thenReturn(passengerMock);

        Integer passengerId = passengerService.savePegasusPassenger(savePassengerRequestDtoMock);
        assertEquals(passengerMock.getId(), passengerId);
    }

    @Test
    void deletePassengerById()
    {
        Passenger passengerMock = mock(Passenger.class);
        passengerMock.setId(1);

        when(passengerRepository.findById(passengerMock.getId())).thenReturn(Optional.of(passengerMock));
        Boolean deletePassenger = passengerService.deletePassengerById(passengerMock.getId());

        assertEquals(true, deletePassenger);
    }
}