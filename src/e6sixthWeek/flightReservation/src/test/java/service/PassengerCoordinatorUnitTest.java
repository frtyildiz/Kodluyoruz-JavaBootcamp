package service;

import com.firat.flightReservation.Validation.PassengerValidation;
import com.firat.flightReservation.controller.PassengerController;
import com.firat.flightReservation.converter.PassengerConverter;
import com.firat.flightReservation.entity.Passenger;
import com.firat.flightReservation.repository.PassengerRepository;
import com.firat.flightReservation.service.PassengerService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PassengerCoordinatorUnitTest {

    @InjectMocks
    PassengerValidation passengerValidation;

    @Mock
    PassengerService passengerService;

    @Mock
    PassengerRepository passengerRepository;

    @Mock
    PassengerConverter passengerConverter;

    @Mock
    PassengerController passengerController;

    @Mock
    Passenger passenger;

    @Test
    void testPassengerNameValidate()
    {
        String name = passenger.getName();
        boolean result = passengerValidation.checkNameFormat(name);
        Assertions.assertTrue(result);
    }


    @Test
    void testPassengerAgeValidate()
    {
        Integer age = passenger.getAge();
        boolean result = passengerValidation.checkAgeFormat(age);
        Assertions.assertTrue(result);
    }

}
