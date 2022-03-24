package secondWeek.hw1;

public class Pear extends Fruit{

    public Pear(String name, int weight, double price) {
        super(name, weight, price);
    }

    @Override
    public void stockControl()
    {
        System.out.println("Depo'daki Armut Miktarı " + super.getWeight() + " KG");
    }
}
