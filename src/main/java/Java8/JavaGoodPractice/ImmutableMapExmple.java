package Java8.JavaGoodPractice;

import Java8.JavaGoodPractice.Entity.Person;
import com.google.common.collect.ImmutableMap;

public class ImmutableMapExmple {
    public static void main(String[] args) {
        // Use Immutable map if no need to change or modify map
        Person person = new Person("Sudip");
        ImmutableMap<String, Object> immutableMap = ImmutableMap.of("status", 200,
                "message", "success", "data", person);

        System.out.println(immutableMap);
    }
}
