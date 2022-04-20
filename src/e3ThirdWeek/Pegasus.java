package e3ThirdWeek;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Pegasus extends Airlines{
    Pegasus(String _from, String _to, int _capacity, double _fare, LocalDate _date, LocalTime _time) {
        super(_from, _to, _capacity, _fare, _date, _time);
        super.flightNo("PNR"); // Oluşturulan her Pegasus uçuşu için PNR ile başlayan random bir numara üretilecektir.
    }

    static List<String> PegasusPassengers = new ArrayList<>();
    String ticketNo = super.ticketNo("N"); // THY uçuşu için bilet alan her yolcu için sonu '/N' ile biten random bir bilet numarası oluşturulacaktır.

    @Override
    public void reservationTicket(String _name, String _lastname, int _ticketCount, String _isBusiness) {
        super.reservationTicket(_name, _lastname, _ticketCount, _isBusiness); // flightNo metodu, Airlines uçuşları için TK ile başlayan ve random sayısal değerler içeren (TK11111 gibi) bir uçuş kodu oluşturacaktır.
        System.out.println("Bilet Numaranız: " + ticketNo);
        PegasusPassengers.add(_name + " " + _lastname + " için Oluşturulan " + super.getDate() + " Tarihli Uçuşun Bilet Numarası: " + this.ticketNo + " Uçak " + super.getTime() + " Saatinde Havalancaktır.");
    }

    public static void showPegasusPassengers()
    {
        if (PegasusPassengers.isEmpty())
            System.out.println("Pegasus Uçuşu için Herhangi Bir Yolcu Kayıdı Bulunamadı.\n");
        else
        {
            for (String passenger : PegasusPassengers)
                System.out.println(passenger);
        }
    }

}
