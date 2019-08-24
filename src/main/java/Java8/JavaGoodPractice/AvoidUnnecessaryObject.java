package Java8.JavaGoodPractice;

import java.util.Objects;

public class AvoidUnnecessaryObject {

    private static AvoidUnnecessaryObject classSingleton;

    private String info = "Class Info";

    private AvoidUnnecessaryObject() {

    }

    // Avoid unnecessary Objects
    public static AvoidUnnecessaryObject getInstance() {
        if (Objects.isNull(classSingleton)) {
            classSingleton = new AvoidUnnecessaryObject();
        }
        return classSingleton;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

}
