package Java8.SOILD.LiskovSubstitution.Violate;

public class Bicycle extends Trasportation {
    //violate Liskov Substitution Principle
    public void startEngine() {
        //problem
        throw new AssertionError("Bicycle don't have Engine");
    }
}
