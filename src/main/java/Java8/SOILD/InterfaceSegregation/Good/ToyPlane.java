package Java8.SOILD.InterfaceSegregation.Good;

public class ToyPlane implements Toy, Movable, Flyable {

    private double price;
    private String color;

    @Override
    public void setPrice(double price) {
        this.price = price;
    }


    @Override
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void move() {
        System.out.println("Move");
    }

    @Override
    public void fly() {
        System.out.println("Fly");
    }

    @Override
    public String toString() {
        return "ToyPlane{" +
                "price=" + price +
                ", color='" + color + '\'' +
                '}';
    }
}
