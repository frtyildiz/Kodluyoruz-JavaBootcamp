package com.firat.flightReservation.controller;

import com.firat.flightReservation.requestDto.SaveFlightRequestDto;
import com.firat.flightReservation.requestDto.UpdateFlightRequestDto;
import com.firat.flightReservation.responseDto.FlightResponseDto;
import com.firat.flightReservation.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flight")
public class FlightController {

    @Autowired
    FlightService flightService;

    @PostMapping("/saveThyFlight")
    public ResponseEntity<Integer> thyFlight(@RequestBody SaveFlightRequestDto saveFlightRequestDto)
    {
        Integer thyFlightId = flightService.saveThyFlight(saveFlightRequestDto);
        return new ResponseEntity<>(thyFlightId, HttpStatus.OK);
        /*
            "to":"İstanbul",
            "from":"Dublin",
            "price":1234,
            "capacity":123,
            "date":"2022-11-11",
            "time":"11:11",
            "businessSeat":15
         */
    }

    @PostMapping("/savePegasusFlight")
    public ResponseEntity<Integer> pegasusFlight(@RequestBody SaveFlightRequestDto saveFlightRequestDto)
    {
        Integer pegasusFlightId = flightService.savePegasusFlight(saveFlightRequestDto);
        return new ResponseEntity<>(pegasusFlightId, HttpStatus.OK);
        /*
            "to":"İstanbul",
            "from":"İzmir",
            "price":1234,
            "capacity":123,
            "date":"2022-11-11",
            "time":"11:11",
            "businessSeat":10
         */
    }

    @GetMapping("/findAllFlight")
    public ResponseEntity<List<FlightResponseDto>> findAllFlights()
    {
        List<FlightResponseDto> flightResponseDtos = flightService.findAllFlight();
        return new ResponseEntity<>(flightResponseDtos, HttpStatus.OK);
    }

    @DeleteMapping("/deleteFlightById")
    public ResponseEntity<Boolean> deleteFlightById(@RequestParam Integer flightId)
    {
        boolean deleteFlight = flightService.deleteFlightById(flightId);
        return new ResponseEntity<>(deleteFlight, HttpStatus.OK);
    }

    @PostMapping("/updateDateFlightTHYById")
    public ResponseEntity<String> updateDateFlightTHYById(@RequestBody UpdateFlightRequestDto updateFlightRequestDto)
    {
        flightService.updateDateFlightTHY(updateFlightRequestDto);
        return new ResponseEntity<>("Seçilen THY Uçuşunun Tarihi Başarıyla Değiştirildi.", HttpStatus.OK);
    }

    @PostMapping("/updateDateFlightPegasusById")
    public ResponseEntity<String> updateDateFlightPegasusById(@RequestBody UpdateFlightRequestDto updateFlightRequestDto)
    {
        flightService.updateDateFlightPegasus(updateFlightRequestDto);
        return new ResponseEntity<>("Seçilen Pegasus Uçuşunun Tarihi Başarıyla Değiştirildi.", HttpStatus.OK);
    }

}
