package com.firat.flightReservation.Validation;

import org.springframework.stereotype.Service;

@Service
public class PassengerValidation {

    public boolean checkNameFormat(String name)
    {
        if (!org.apache.commons.lang3.StringUtils.isNumeric(name))
        {
            return false;
        }
        if (!org.apache.commons.lang3.StringUtils.isEmpty(name))
        {
            return false;
        }
        if (name.trim().length() == 0)
        {
            return false;
        }
        return true;
    }


    public boolean checkAgeFormat(Integer age)
    {
        if (age < 0)
        {
            return false;
        }
        return true;
    }

}
