package secondWeek.hw1;

public class Cherry extends Fruit{

    public Cherry(String name, int weight, double price) {
        super(name, weight, price);
    }

    @Override
    public void stockControl()
    {
        System.out.println("Depo'daki Kiraz Miktarı " + super.getWeight() + " KG");
    }
}
