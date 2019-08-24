package Java8.JavaGoodPractice;

import Java8.JavaGoodPractice.Entity.Person;

import java.util.HashMap;
import java.util.Map;

public class MapExmple {
    public static void main(String[] args) {

        Person person = new Person("Sudip");

        //Map<Object, Object> don't set generic as Object if not Necessary
        //bad
        /*Map<Object, Object> responseData = new HashMap<>();
        responseData.put("data", person);

        System.out.println(responseData);*/

        Map<String, Object> responseData = new HashMap<>();

        responseData.put("data", person);

        System.out.println(responseData);


    }
}
