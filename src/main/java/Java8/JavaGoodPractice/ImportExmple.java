package Java8.JavaGoodPractice;

//import java.util.*;  bad

import static Java8.JavaGoodPractice.Constants.AppContants.PERSON_NAME; //Use Static import Constant type varible
import Java8.JavaGoodPractice.Entity.Person;


// Remove Unused import
public class ImportExmple {
    public static void main(String[] args) {

        Person person = new Person("Sudip");

        if (PERSON_NAME.equalsIgnoreCase(person.getName())) {
            System.out.println(person.getName());
        }

    }
}
