package Java8.SOILD.LiskovSubstitution.Violate;

public class Trasportation {
    private String name;
    private double speed;
    private Engine engine;

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

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public void startEngine() {
        engine.start();
    }

    @Override
    public String toString() {
        return "Trasportation{" +
                "name='" + name + '\'' +
                ", speed=" + speed +
                ", engine=" + engine +
                '}';
    }
}
