package Java8.SOILD.DependencyInversion.Good;

public class SeniorWorker implements IWorker {
    @Override
    public void work() {
        System.out.println("Senior Wroker");
    }
}
