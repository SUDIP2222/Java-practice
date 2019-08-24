package Java8.JavaGoodPractice;

import java.io.FileNotFoundException;

public class ExceptionPropagationTest {
    public static void main(String[] args) throws FileNotFoundException {
        method1();
        System.out.println("After calling m()");
    }

    static void method1() throws FileNotFoundException {
        method2();
    }

    static void method2() throws FileNotFoundException {
        method3();
    }

    static void method3() throws FileNotFoundException {
        throw new FileNotFoundException();
    }
}
