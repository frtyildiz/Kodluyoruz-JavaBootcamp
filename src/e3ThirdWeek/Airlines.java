package e3ThirdWeek;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Airlines extends Flight {
    static List<String> passengers = new ArrayList<>(); // Eklenen tüm yolcuları kaydetmek için ArrayList kullandım
    private String name;
    private String lastname;
    private int ticketCount;
    int currentPassengerCount;
    int businessSeatCapacity = 10;

    Airlines(String _from, String _to, int _capacity, double _fare, LocalDate _date, LocalTime _time)
    {
        super.setFrom(_from);
        super.setTo(_to);
        super.setCapacity(_capacity);
        super.setFare(_fare);
        super.setDate(_date);
        super.setTime(_time);
    }

    @Override
    public void reservationTicket(String _name, String _lastname, int _ticketCount, String _isBusiness)
    {
        this.name = _name;
        this.lastname = _lastname;
        this.ticketCount = _ticketCount;

        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String ticketDate = date.format(formatter); // LocalDateTime sınıfından yararlanılarak biletin alınma tarihi ve saati oluşturulacak


        boolean isBusiness = false;
        if (_isBusiness.equalsIgnoreCase("B"))
        {
            isBusiness = true;
        }

        if (_ticketCount > super.getCapacity() || super.getCapacity() < this.getCurrentPassengerCount())
        {
            System.out.println("Biletler Tükenmiş veya İstenilen Mevcutta Bilet Bulunmamaktadır. Alabileceğiniz Bilet Sayısı: " + this.getCurrentPassengerCount() + "\n");;
        }
        else
        {
            this.setCurrentPassengerCount(_ticketCount); // Alınan bilet sayısı mevcut yolcu sayısına eklendi
            String ticketNo = this.ticketNo("C"); // Biletin sayısal değerlerle başlayan ve /C ile sonlanan unique bir seri numarası oluşacak

            if (isBusiness && this.getBusinessSeatCapacity() > _ticketCount)
            {
                System.out.println(_name + " " + _lastname + " Adına " + _ticketCount + " Adet Business Class Bilet Satın Alınmıştır.");
                System.out.println("Toplam Bilet Ücretiniz: " + totalTicketPrice());
                System.out.println("Uçuş Tarihi: " + super.getDate() + " ve Uçuş Saati: " + super.getTime());
                System.out.println("Biletin Oluşturulma Tarihi:  " + ticketDate);
                System.out.println("Yemek Servisi Ücretsizdir.\n");

                this.setBusinessSeatCapacity(_ticketCount); // Business class koltuk kapasitesi alınan bilet kadar düşürüldü
                //passengers.add(_name + " " + _lastname + " için Oluşturulan " + super.getDate() + " Tarihli Uçuşun Bilet Numarası: " + ticketNo + " Uçak " + super.getTime() + " Saatinde Havalancaktır.");
            }
            else if (this.getBusinessSeatCapacity() < _ticketCount)
            {
                System.out.println("Business Class Koltuklar Tükenmiş veya İstediğiniz Miktarda Business Class Koltuk Bulunmamaktadır. Alabileceğiniz Business Class Koltuk Sayısı: " + this.getBusinessSeatCapacity() + "\n");
            }
            else
            {
                System.out.println(_name + " " + _lastname + " Adına " + _ticketCount + " Adet Bilet Satın Alınmıştır.");
                System.out.println("Toplam Bilet Ücretiniz: " + totalTicketPrice() + " ve Bilet Numaranız: " + ticketNo);
                System.out.println("Uçuş Tarihi: " + super.getDate() + " ve Uçuş Saati: " + super.getTime());
                System.out.println("Bilet Oluşturulma Tarihi:  " + ticketDate);
                System.out.println("Yemek Servisi Ücretsizdir.\n");

            }
        }
    }

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

    @Override
    double totalTicketPrice()
    {
        return this.ticketCount * super.getFare();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getTicketCount() {
        return ticketCount;
    }

    public void setTicketCount(int ticketCount) {
        this.ticketCount = ticketCount;
    }

    public int getCurrentPassengerCount() {
        return currentPassengerCount;
    }

    public void setCurrentPassengerCount(int currentPassengerCount) {
        this.currentPassengerCount += currentPassengerCount;
    }

    public int getBusinessSeatCapacity() {
        return businessSeatCapacity;
    }

    public void setBusinessSeatCapacity(int businessSeatCapacity) {
        this.businessSeatCapacity -= businessSeatCapacity;
    }

}
