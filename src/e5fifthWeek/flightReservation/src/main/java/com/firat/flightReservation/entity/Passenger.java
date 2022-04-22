package com.firat.flightReservation.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table
public class Passenger {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Lastname")
    private String lastname;

    @Column(name = "Age")
    private int age;

    @Column(name = "SuitcaseWeight")
    private int suitcaseWeight;

    @Column(name = "isBusiness")
    private boolean isBusiness;

    @Column(name = "TicketPrice")
    private double ticketPrice;

    public void setSuitcaseWeight(int suitcaseWeight) {
        if (suitcaseWeight > 20)
        {
            this.ticketPrice += suitcaseWeight * 5;
            this.suitcaseWeight = suitcaseWeight;
        }
        else
        {
            this.suitcaseWeight = suitcaseWeight;
        }
    }
}
