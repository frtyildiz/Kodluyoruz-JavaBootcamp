package com.firat.flightReservation.service;

import com.firat.flightReservation.converter.FlightConverter;
import com.firat.flightReservation.dto.requestDto.SaveFlightRequestDto;
import com.firat.flightReservation.dto.requestDto.UpdateFlightRequestDto;
import com.firat.flightReservation.entity.Flight;
import com.firat.flightReservation.entity.Pegasus;
import com.firat.flightReservation.entity.THY;
import com.firat.flightReservation.repository.FlightRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FlightServiceTest {

    @InjectMocks
    FlightService flightService;

    @Mock
    FlightRepository flightRepository;

    @Mock
    FlightConverter flightConverter;

    @Test
    void saveThyFlight()
    {
        SaveFlightRequestDto saveFlightRequestDtoMock = mock(SaveFlightRequestDto.class);
        saveFlightRequestDtoMock.setCapacity(123);
        saveFlightRequestDtoMock.setFrom("İstanbul");
        saveFlightRequestDtoMock.setTo("Dublin");

        THY thyMock = mock(THY.class);
        thyMock.setId(1);

        when(flightConverter.convertToThyFromsaveFlightRequestDto(saveFlightRequestDtoMock)).thenReturn(thyMock);
        when(flightRepository.save(thyMock)).thenReturn(thyMock);

        Integer id = flightService.saveThyFlight(saveFlightRequestDtoMock);
        assertEquals(thyMock.getId(), id);
    }

    @Test
    void savePegasusFlight()
    {
        SaveFlightRequestDto saveFlightRequestDtoMock = mock(SaveFlightRequestDto.class);
        saveFlightRequestDtoMock.setCapacity(123);
        saveFlightRequestDtoMock.setFrom("İstanbul");
        saveFlightRequestDtoMock.setTo("İzmir");

        Pegasus pegasusMock = mock(Pegasus.class);
        pegasusMock.setId(1);

        when(flightConverter.convertToPegasusFromSaveFlightRequestDto(saveFlightRequestDtoMock)).thenReturn(pegasusMock);
        when(flightRepository.save(pegasusMock)).thenReturn(pegasusMock);

        Integer id = flightService.savePegasusFlight(saveFlightRequestDtoMock);
        assertEquals(pegasusMock.getId(), id);
    }

    @Test
    void deleteFlightById()
    {
        Flight flightMock = mock(Flight.class);
        flightMock.setId(1);

        when(flightRepository.findById(flightMock.getId())).thenReturn(Optional.of(flightMock));
        Boolean deleteFlight = flightService.deleteFlightById(flightMock.getId());

        assertEquals(true, deleteFlight);
    }
}