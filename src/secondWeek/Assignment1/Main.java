package secondWeek.Assignment1;

public class Main {
    public static void main(String[] args) {
        /*
         * Manav dükkanı açmak isteyen bir adam hal'den bir miktar elma, bir miktar armut, bir miktar kiraz
         * alacaktır. Mallar dükkana gelmiştir. Kullanıcı bu malları ayrı odalarda saklayacaktır.
         */
        Apple a1 = new Apple("Elma", 12, 10.2);
        Pear p1 = new Pear("Armut", 21, 12.1);
        Cherry c1 = new Cherry("Kiraz", 13, 24.0);

        /*
         * Her bir odadaki elma, armut ve kirazın kg cinsinden değerini bulalım.
         */

        a1.stockControl();
        p1.stockControl();
        c1.stockControl();

        /*
         * Manav'dan online alışveriş yapılıyor. Müşteri Ve 1 kg elma, 2 kg armut almak istedi.
         * Malları alsın. depo guncellensin.
         */

        a1.selling(1);
        p1.selling(2);

        /*
         * Online satışta müşteri depoda kalan maldan fazla bir miktarda mal almak istedi.
         * Bunu kullanıcıya bildir.
         */
        a1.selling(28);


    }
}
