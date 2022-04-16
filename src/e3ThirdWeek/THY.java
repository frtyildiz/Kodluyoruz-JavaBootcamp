package e3ThirdWeek;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class THY extends Airlines {
    THY(String _from, String _to, int _capacity, double _fare, LocalDate _date, LocalTime _time) {
        super(_from, _to, _capacity, _fare, _date, _time);
        super.flightNo("TK"); // Oluşturulan her THY uçuşu için TK ile başlayan random bir numara üretilecektir.
    }

    static List<String> thyPassengers = new ArrayList<>();
    String ticketNo = super.ticketNo("C"); // THY uçuşu için bilet alan her yolcu için sonu '/C' ile biten random bir bilet numarası oluşturulacaktır.

    @Override
    public void reservationTicket(String _name, String _lastname, int _ticketCount, String _isBusiness) {
        super.reservationTicket(_name, _lastname, _ticketCount, _isBusiness);
        System.out.println("Bilet Numaranız: " + ticketNo);
        thyPassengers.add(_name + " " + _lastname + " için Oluşturulan " + super.getDate() + " Tarihli Uçuşun Bilet Numarası: " + this.ticketNo + " Uçak " + super.getTime() + " Saatinde Havalancaktır.");
    }

    public static void showTHYPassengers()
    {
        if (thyPassengers.isEmpty())
            System.out.println("THY Uçuşu için Herhangi Bir Yolcu Kayıdı Bulunamadı.\n");
        else
        {
            for (String passenger : thyPassengers)
                System.out.println(passenger);
        }
    }

}
