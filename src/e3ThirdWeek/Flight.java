package e3ThirdWeek;

import java.time.LocalDate;
import java.time.LocalTime;

public abstract class Flight {
    private int capacity;
    private double fare;
    private String flightID;
    private String from;
    private String to;
    private LocalDate date;
    private LocalTime time;

    public abstract void reservationTicket(String _name, String _lastname, int _ticketCount, String _isBusiness);

    abstract double totalTicketPrice();

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public double getFare() {
        return fare;
    }

    public void setFare(double fare) {
        this.fare = fare;
    }

    public String getFlightID() {
        return flightID;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public void setFlightID(String flightID) {
        this.flightID = flightID;
    }

    @Override
    public String toString() {
        return to + " - " + from + " || Uçak Kapasitesi: " + capacity + ", Bilet Ücreti: " + fare + ", Uçuş Numarası: " + flightID + ", Uçuş Tarihi: " + date + ", Kalkış Saati: " + time + "\n";
    }


}
