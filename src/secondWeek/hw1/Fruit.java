package secondWeek.hw1;

public abstract class Fruit {

    private String name;
    private int weight;
    private double price;

    public Fruit(String name, int weight, double price) {
        this.name = name;
        this.weight = weight;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        if (weight > this.weight)
            System.out.println("Satın Alma İşlemi Gerçekleşemedi. Satın Alabileceğiniz Maksimum " + this.name + " Miktarı " + this.weight + " KG");
        else
        {
            this.weight -= weight;
            System.out.println(weight + " KG " + this.name + " Aldınız. Stokta Kalan " + this.name + " Miktarı " + this.weight + " KG");
        }
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public abstract void stockControl();

    public void selling(int _weight)
    {
        setWeight(_weight);
        if (_weight < this.weight)
            System.out.println("Alışveriş Tutarınız: " + (_weight * this.getPrice()));
    }

}
