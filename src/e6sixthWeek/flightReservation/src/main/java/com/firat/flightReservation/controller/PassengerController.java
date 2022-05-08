package com.firat.flightReservation.controller;

import com.firat.flightReservation.Validation.PassengerValidation;
import com.firat.flightReservation.dto.requestDto.SavePassengerRequestDto;
import com.firat.flightReservation.dto.requestDto.UpdatePassengerRequestDto;
import com.firat.flightReservation.dto.responseDto.PassengerResponseDto;
import com.firat.flightReservation.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/passenger")
public class PassengerController {

    @Autowired
    PassengerService passengerService;

    @Autowired
    PassengerValidation passengerValidation;

    @PostMapping("/saveThyPassenger")
    public void saveThyFlight(@RequestBody SavePassengerRequestDto savePassengerRequestDto)
    {
        String name = savePassengerRequestDto.getName();
        if (!passengerValidation.checkNameFormat(name))
        {
            System.out.println("Lütfen Adınızı Doğru Yazdığınızdan Emin Olun.");
            return;
        }
        try {
            passengerService.saveThyPassenger(savePassengerRequestDto);
        } catch (Exception e) {
            e.getMessage();
        }
    }
    /*
    "name":"Fırat",
    "lastname":"Yıldız",
    "age":1,
    "isBusiness":true,
    "suitcaseWeight":15
     */

    @PostMapping("/savePegasusPassenger")
    public void savePegasusFlight(@RequestBody SavePassengerRequestDto savePassengerRequestDto)
    {
        try {
            passengerService.savePegasusPassenger(savePassengerRequestDto);
        } catch (Exception e)
        {
            e.getMessage();
        }
    }
    /*
    "name":"Fırat",
    "lastname":"Yıldız",
    "age":1,
    "isBusiness":true,
    "suitcaseWeight":22
     */

    @GetMapping("/findAllPassenger")
    public ResponseEntity<List<PassengerResponseDto>> findAllPassenger()
    {
        List<PassengerResponseDto> passengerResponseDtos = passengerService.findAllPassenger();
        return new ResponseEntity<>(passengerResponseDtos, HttpStatus.OK);
    }

    @DeleteMapping("/deletePassengerById")
    public ResponseEntity<Boolean> deletePassengerById(@RequestParam Integer passengerId)
    {
        boolean deletePassenger = passengerService.deletePassengerById(passengerId);
        return new ResponseEntity<>(deletePassenger, HttpStatus.OK);
    }

    @PostMapping("/updatePassengerNameById")
    public ResponseEntity<String> updatePassengerNameById(@RequestBody UpdatePassengerRequestDto updatePassengerRequestDto)
    {
        passengerService.updatePassengerNameById(updatePassengerRequestDto);
        return new ResponseEntity<>("Yolcunun Adı Başarıyla Değiştirildi.", HttpStatus.OK);
    }

    @PostMapping("/updatePassengerLastnameById")
    public ResponseEntity<String> updatePassengerLastnameById(@RequestBody UpdatePassengerRequestDto updatePassengerRequestDto)
    {
        passengerService.updatePassengerLastnameById(updatePassengerRequestDto);
        return new ResponseEntity<>("Yolcunun Soyadı Başarıyla Değiştirildi.", HttpStatus.OK);
    }


}
