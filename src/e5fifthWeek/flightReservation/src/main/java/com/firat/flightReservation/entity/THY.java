package com.firat.flightReservation.entity;


import javax.persistence.Entity;

@Entity
public class THY extends Flight implements IAbroadFoodChoise{

    @Override
    public double businessTicketPrice() {
        return super.getPrice() * 2;
    }

    @Override
    public void newCapacity(int capacity) {
        super.setCapacity(getCapacity() - capacity);
    }

    @Override
    public void foodChoise() {
        System.out.println("Uçuşlarımızda Yemekler Ücretsizdir.");
    }
}
