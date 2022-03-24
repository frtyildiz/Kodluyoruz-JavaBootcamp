package secondWeek.Homework2;

public class Main {
    public static void main(String[] args) {
        /**
         * 1'den 10 a kadar olan sayılar içerisinde 2 ile tam bölünenleri ekrana yazdır.
         */
        for (int i = 1; i <= 11; i++)
        {
            if (i % 2 == 0)
                System.out.println(i);
        }

        /**
         * Ödev:
         * Bu listedeki isimleri ekrana şu şekilde yazdır.
         * 1. Murat
         * 2. Ahmet
         * 3. Mehmet
         */
        String[] names = {"Murat", "Ahmet", "Mehmet"};

        int counter = 1;
        for (String name : names)
        {
            System.out.println(counter + ". " + name);
            counter++;
        }

        /**
         * 10 kişilik bir sınıf var.
         * Sınıftaki kişilerin numaraları ve cinsiyetlerini biliyorum.
         * bu sınıftaki kızların ve erkeklerin numaralarını ayrı ayrı ekrana yazdıran program.
         */
        Classroom stu1 = new Classroom('E'); // Numaralar Classroom sınıfı içerisinde random olarak oluşturulacaktır.
        Classroom stu2 = new Classroom('K');
        Classroom stu3 = new Classroom('E');
        Classroom stu4 = new Classroom('K');
        Classroom stu5 = new Classroom('K');
        Classroom stu6 = new Classroom('K');
        Classroom stu7 = new Classroom('E');
        Classroom stu8 = new Classroom('E');
        Classroom stu9 = new Classroom('K');
        Classroom stu10 = new Classroom('E');

        Classroom.showBoysID(); // Otomatik olarak oluşturulan numaralar, cinsiyet esasına göre yazdırılır
        Classroom.showGirlsID();

        /**
         * Sinema bileti satışı:
         * ücret hesaplama: 18 yaş altı için %10 indirimli.
         * 18 ve 25 yaş arası % 5 indirim.
         * Korku filmi seçilmişse ekstra % 10 indirim.
         */

        discount(21, 42.5, "Korku"); // Parametre sıralaması yaş, bilet ücreti ve film türü olmak üzere discount metodu oluşturulmuştur.
        discount(15, 42.5, "Korku");
        discount(65, 42.5, "Korku");
        discount(17, 42.5, "Korku");
        discount(24, 42.5, "Komedi");
        discount(16, 42.5, "Macera");

    }
    public static void discount(int age, double price, String movieGenre)
    {
        if (age < 18 && age >= 16)
            System.out.println("Bilet Fiyatı: " + (price * 0.90));
        else if (age < 16 && movieGenre.equals("Korku"))
            System.out.println("16 Yaşından Küçük Kişilere Korku Filmi Bileti Satılamaz.");
        else if (age >= 18 && age <= 25)
        {
            if (movieGenre.equals("Korku"))
                System.out.println("Bilet Fıyatı: " + (price * 0.95) * 0.90);
            else
                System.out.println("Bilet Fıyatı: " + (price * 0.95));
        }
        else if (age > 25)
            System.out.println("Bilet Fiyatı: " + price);
    }

}
