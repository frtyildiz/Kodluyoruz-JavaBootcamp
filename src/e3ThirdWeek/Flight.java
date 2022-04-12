package e3ThirdWeek;

import java.time.LocalDate;
import java.time.LocalTime;

public abstract class Flight implements IAirlines{
    private int capacity;
    private double fare;
    private String flightID;
    private String from;
    private String to;
    private LocalDate date;
    private LocalTime time;

    abstract double totalTicketPrice();
    public abstract void reservationTicket(String _name, String _lastname, int _ticketCount, String isBusiness);

    public void flightNo(String flightCode) // flightNo metodu ile havayolu şirketlerinin uçuşları için parametre olarak verilecek karakter kodu ile başlayan uçuk kodu (parametre TK ise TK123123 gibi) üretilecektir.
    {
        int randomNo = (int) (Math.random() * 100000);
        String flightNo = flightCode + randomNo;
        setFlightID(flightNo);
    }

    public String ticketNo (String ticketCode)
    {
        String ticketNo = (int) (Math.random() * 1000000) + "/" + ticketCode; // Müşteriler için gelen bilet koduna göre (111111111/C gibi) bilet numarası oluşturacaktir
        return ticketNo;
    }

    public void setFrom(String from) {
        this.from = from;
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
