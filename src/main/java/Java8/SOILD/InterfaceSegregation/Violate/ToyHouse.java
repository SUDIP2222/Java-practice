package Java8.SOILD.InterfaceSegregation.Violate;

public class ToyHouse implements Toy {
    private String color;
    private double price;

    @Override
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void setPrice(double price) {
        this.price = price;
    }

    //violate Interface Segregation Principle
    @Override
    public void move() {

    }

    //violate Interface Segregation Principle
    @Override
    public void fly() {

    }
}
