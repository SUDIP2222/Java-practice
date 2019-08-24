package Java8.JavaGoodPractice;

import static Java8.JavaGoodPractice.Constants.AppContants.PERSON_NAME;
import Java8.JavaGoodPractice.Entity.Person;

public class CompareString {
    public static void main (String[] args) {

        Person person = new Person(null);

        //Bad Practice
        /*if(person.getName().equalsIgnoreCase(PERSON_NAME)) {
            System.out.println(person.getName());
        } else {
            System.out.println("Null");
        }*/

        //Good Practice
        if(PERSON_NAME.equalsIgnoreCase(person.getName())) {
            System.out.println(person.getName());
        } else {
            System.out.println();
        }
    }
}
