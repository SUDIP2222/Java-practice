package Java8.SOILD.DependencyInversion.violate;

public class Manager {

    private Worker worker;

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    public void manager() {
        worker.work();
    }
}


class SupportWorker {
    public void work() {
        //.... working much more
    }
}
