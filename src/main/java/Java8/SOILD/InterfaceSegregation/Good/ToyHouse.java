package Java8.SOILD.InterfaceSegregation.Good;

public class ToyHouse  implements Toy {
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
    public String toString() {
        return "ToyHouse{" +
                "price=" + price +
                ", color='" + color + '\'' +
                '}';
    }
}
