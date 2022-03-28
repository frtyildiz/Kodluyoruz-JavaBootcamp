package SecondWeek.ch02Homework;

import java.util.ArrayList;

public class Classroom {
    private int id;
    private char gender;
    static ArrayList<Integer> womenNumbers = new ArrayList<>();
    static ArrayList<Integer> menNumbers = new ArrayList<>();

    public Classroom(char gender) {
        this.id = (int) (Math.random() * 100); // Oluşturulan her Classroom nesnesi için random bir numara üretilir
        this.gender = gender;

        if (gender == 'E') // Cinsiyet erkek (E) ise menNumbers değilse womenNumbers listesine aktarılır
            menNumbers.add(this.id);
        else
            womenNumbers.add(this.id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id == this.getId()) // Random olarak oluşturulan numara daha önce oluşturulduysa tekrar random bir numara üretilir.
            this.id = (int) (Math.random() * 100);
        else
            this.id = id;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public static void showGirlsID()
    {
        System.out.println("Sınıftaki Kızların Numaraları: ");
        for (int id : womenNumbers)
            System.out.println(id);
    }

    public static void showBoysID()
    {
        System.out.println("Sınıftaki Erkeklerin Numaraları: ");
        for (int id : menNumbers)
            System.out.println(id);
    }
}
