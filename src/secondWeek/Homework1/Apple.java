package secondWeek.Homework1;

public class Apple extends Fruit{

    public Apple(String name, int weight, double price) {
        super(name, weight, price);
    }

    @Override
    public void stockControl()
    {
        System.out.println("Depo'daki Elma Miktarı " + super.getWeight() + " KG");
    }
}
