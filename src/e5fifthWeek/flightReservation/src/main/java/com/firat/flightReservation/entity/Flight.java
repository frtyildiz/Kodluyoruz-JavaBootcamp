package com.firat.flightReservation.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table
@Data
public abstract class Flight {
    // http://localhost:8097/h2-console/

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "ToCity")
    private String to;

    @Column(name = "FromCity")
    private String from;

    @Column(name = "Price")
    private double price;

    @Column(name = "Capacity")
    private int capacity;

    @Column(name = "FlightDate")
    private LocalDate date;

    @Column(name = "FlightTime")
    private LocalTime time;

    @Column(name = "BusinessSeat")
    private int businessSeat;

    @ManyToMany
    @JoinColumn
    private List<Passenger> passengers;

    public abstract double businessTicketPrice();

    public abstract void newCapacity(int capacity);
}
