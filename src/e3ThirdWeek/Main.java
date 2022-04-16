package e3ThirdWeek;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Flight> flights = new ArrayList<>(); // Oluşturulacak olan tüm uçuşları içeren ArrayList

        // Uçuş oluşturma parametreleri sırasıyla kalkış yeri, varış yeri, yolcu kapasitesi, bilet ücreti, uçuş tarihi ve uçuş saati olarak düzenlenmiştir.
        THY thy = new THY("İstanbul", "Dublin", 250, 2523.5, LocalDate.parse("2022-08-24"), LocalTime.parse("11:11"));
        flights.add(thy);

        Pegasus pgs = new Pegasus("İstanbul", "İzmir", 150, 534.6, LocalDate.parse("2022-12-08"), LocalTime.parse("11:11"));
        flights.add(pgs);

        Scanner sc = new Scanner(System.in);

        while (true)
        {
            System.out.println("-------------- Uçak Bileti Rezervasyon Sistemi --------------");
            System.out.println("1- THY Bilet Rezervasyonu");
            System.out.println("2- Pegasus Bilet Rezervasyonu");
            System.out.println("3- THY Yolcularını Listele");
            System.out.println("4- Pegasus Yolcularını Listele");
            System.out.println("5- Tüm Uçuşları Listele");
            System.out.println("6- Çıkış");
            System.out.print("Lütfen Yapmak İstediğiniz İşlemi Seçiniz: ");
            int choice = sc.nextInt();

            if (choice == 1)
            {
                setInfo(thy); // setInfo metodu müşteri bilgilerini isim, soyisim, almak istenen bilet sayısı ve koltuk class'ı şeklinde alarak Airlines uçuşu için müşteri kaydı oluşturacaktır. Metot aşağıdan incelenebilir.
            }
            else if (choice == 2)
            {
                setInfo(pgs); // setInfo metodu müşteri bilgilerini isim, soyisim, almak istenen bilet sayısı ve koltuk class'ı şeklinde alarak a uçuşu için müşteri kaydı oluşturacaktır. Metot aşağıdan incelenebilir.
            }
            else if (choice == 3)
            {
                THY.showTHYPassengers();
            }
            else if (choice == 4)
            {
                Pegasus.showPegasusPassengers();
            }
            else if (choice == 5)
            {
                for (Flight flight : flights)
                    System.out.println(flight);
            }
            else if (choice == 6)
            {
                return;
            }
        }
    }

    public static void setInfo(Airlines object)
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Adınız: ");
        String name = sc.next();

        System.out.print("Soyadınız: ");
        String lastname = sc.next();

        System.out.print("Almak İstediğiniz Bilet Sayısı: ");
        int ticketCount = sc.nextInt();

        System.out.print("Business Class Bilet için B, Standart Bilet için S Yazınız: ");
        String isBusiness = sc.next();

        object.reservationTicket(name, lastname, ticketCount, isBusiness);
    }
}
