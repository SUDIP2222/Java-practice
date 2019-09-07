package Java8.SOILD.LiskovSubstitution.Good;
import Java8.SOILD.LiskovSubstitution.Violate.Engine;

public class TransportationWithEngine {

    private Engine engine;

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public void startEngine() {
        engine.start();
    }
}
