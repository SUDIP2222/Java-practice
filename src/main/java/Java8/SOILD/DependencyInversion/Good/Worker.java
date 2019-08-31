package Java8.SOILD.DependencyInversion.Good;

public class Worker implements IWorker {
    @Override
    public void work() {
        System.out.println("Work");
    }
}
