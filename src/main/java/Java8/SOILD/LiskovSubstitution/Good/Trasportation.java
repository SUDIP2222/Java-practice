package Java8.SOILD.LiskovSubstitution.Good;

public class Trasportation {
    private String name;
    private double speed;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    @Override
    public String toString() {
        return "Trasportation{" +
                "name='" + name + '\'' +
                ", speed=" + speed +
                '}';
    }
}
