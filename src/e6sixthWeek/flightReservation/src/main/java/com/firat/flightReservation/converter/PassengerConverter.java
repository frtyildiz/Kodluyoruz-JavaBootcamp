package com.firat.flightReservation.converter;

import com.firat.flightReservation.entity.Passenger;
import com.firat.flightReservation.entity.Pegasus;
import com.firat.flightReservation.entity.THY;
import com.firat.flightReservation.dto.requestDto.SavePassengerRequestDto;
import org.springframework.stereotype.Component;

@Component
public class PassengerConverter {

    public Passenger convertToPegasusPassengerFromSavePassengerRequestDto(SavePassengerRequestDto savePassengerRequestDto)
    {

            if (savePassengerRequestDto.getIsBusiness())
            {
                String nameRequestDto = savePassengerRequestDto.getName();
                String lastnameRequestDto = savePassengerRequestDto.getLastname();
                int ageRequestDto = savePassengerRequestDto.getAge();
                boolean isBusinessRequestDto = savePassengerRequestDto.getIsBusiness();
                int suitcaseWeightRequestDto = savePassengerRequestDto.getSuitcaseWeight();

                Passenger passenger = new Passenger();
                Pegasus pegasus = new Pegasus();

                passenger.setName(nameRequestDto);
                passenger.setLastname(lastnameRequestDto);
                passenger.setAge(ageRequestDto);
                passenger.setBusiness(isBusinessRequestDto);
                passenger.setTicketPrice(pegasus.businessTicketPrice());
                passenger.setSuitcaseWeight(suitcaseWeightRequestDto);

                pegasus.setCapacity(-1);
                pegasus.setBusinessSeat(-1);
                pegasus.businessTicketPrice();

                return passenger;
            }
            else
            {
                String nameRequestDto = savePassengerRequestDto.getName();
                String lastnameRequestDto = savePassengerRequestDto.getLastname();
                int ageRequestDto = savePassengerRequestDto.getAge();
                boolean isBusinessRequestDto = savePassengerRequestDto.getIsBusiness();
                int suitcaseWeightRequestDto = savePassengerRequestDto.getSuitcaseWeight();

                Passenger passenger = new Passenger();
                Pegasus pegasus = new Pegasus();

                passenger.setName(nameRequestDto);
                passenger.setLastname(lastnameRequestDto);
                passenger.setAge(ageRequestDto);
                passenger.setBusiness(isBusinessRequestDto);
                passenger.setTicketPrice(pegasus.getPrice());
                passenger.setSuitcaseWeight(suitcaseWeightRequestDto);

                pegasus.setCapacity(1);

                return passenger;
            }
        }


    public Passenger convertToThyPassengerFromSavePassengerRequestDto(SavePassengerRequestDto savePassengerRequestDto) {

            if (savePassengerRequestDto.getIsBusiness())
            {
                String nameRequestDto = savePassengerRequestDto.getName();
                String lastnameRequestDto = savePassengerRequestDto.getLastname();
                int ageRequestDto = savePassengerRequestDto.getAge();
                boolean isBusinessRequestDto = savePassengerRequestDto.getIsBusiness();
                int suitcaseWeightRequestDto = savePassengerRequestDto.getSuitcaseWeight();

                Passenger passenger = new Passenger();
                THY thy = new THY();

                passenger.setName(nameRequestDto);
                passenger.setLastname(lastnameRequestDto);
                passenger.setAge(ageRequestDto);
                passenger.setBusiness(isBusinessRequestDto);
                passenger.setTicketPrice(thy.businessTicketPrice());
                passenger.setSuitcaseWeight(suitcaseWeightRequestDto);

                thy.setCapacity(-1);
                thy.setBusinessSeat(-1);
                thy.businessTicketPrice();


                return passenger;
            }
            else
            {
                String nameRequestDto = savePassengerRequestDto.getName();
                String lastnameRequestDto = savePassengerRequestDto.getLastname();
                int ageRequestDto = savePassengerRequestDto.getAge();
                boolean isBusinessRequestDto = savePassengerRequestDto.getIsBusiness();
                int suitcaseWeightRequestDto = savePassengerRequestDto.getSuitcaseWeight();

                Passenger passenger = new Passenger();
                THY thy = new THY();

                passenger.setName(nameRequestDto);
                passenger.setLastname(lastnameRequestDto);
                passenger.setAge(ageRequestDto);
                passenger.setBusiness(isBusinessRequestDto);
                passenger.setTicketPrice(thy.getPrice());
                passenger.setSuitcaseWeight(suitcaseWeightRequestDto);

                thy.setCapacity(-1);

                return passenger;
            }


    }
}
