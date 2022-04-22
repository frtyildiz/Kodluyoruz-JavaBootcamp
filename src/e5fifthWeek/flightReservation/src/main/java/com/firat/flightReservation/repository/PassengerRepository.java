package com.firat.flightReservation.repository;

import com.firat.flightReservation.entity.Passenger;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengerRepository extends CrudRepository <Passenger, Integer> {
}
