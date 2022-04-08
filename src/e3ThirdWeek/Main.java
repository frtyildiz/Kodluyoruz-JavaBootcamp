package e3ThirdWeek;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Flight> flights = new ArrayList<>(); // Oluşturulacak olan tüm uçuşları içeren ArrayList

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
            int choose = sc.nextInt();

            if (choose == 1)
            {
                System.out.print("Adınız: ");
                String name = sc.next();

                System.out.print("Soyadınız: ");
                String lastname = sc.next();

                System.out.print("Almak İstediğiniz Bilet Sayısı: ");
                int ticketCount = sc.nextInt();

                System.out.print("Business Class Bilet için B, Standart Bilet için S Yazınız: ");
                String isBusiness = sc.next();

                thy.reservationTicket(name, lastname, ticketCount, isBusiness);
            }
            else if (choose == 2)
            {
                System.out.print("Adınız: ");
                String name = sc.next();

                System.out.print("Soyadınız: ");
                String lastname = sc.next();

                System.out.print("Almak İstediğiniz Bilet Sayısı: ");
                int ticketCount = sc.nextInt();

                System.out.print("Business Class Bilet için B, Standart Bilet için S Yazınız: ");
                String isBusiness = sc.next();

                pgs.reservationTicket(name, lastname, ticketCount, isBusiness);
            }
            else if (choose == 3)
            {
                THY.showTHYPassengers();
            }
            else if (choose == 4)
            {
                Pegasus.showPegasusPassengers();
            }
            else if (choose == 5)
            {
                for (Flight flight : flights)
                    System.out.println(flight);
            }
            else if (choose == 6)
            {
                return;
            }
        }


    }
}
