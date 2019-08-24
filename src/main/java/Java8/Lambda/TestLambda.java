package Java8.Lambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TestLambda {

    private static List<Person> getPersons() {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("AAAAA", "A@gmail.com", 30, 6565656));
        personList.add(new Person("BBBBB", "B@gmail.com", 23, 7678900));
        personList.add(new Person("CCCCC", "C@gmail.com", 26, 4000000));
        personList.add(new Person("DDDDD", "D@gmail.com", 22, 3000000));
        personList.add(new Person("EEEEE", "E@gmail.com", 28, 2500000));

        return personList;
    }

    public static void main(String[] args) {
        List<Person> personList = getPersons();

        System.out.println("Before Sorting By Salary :");

        personList.forEach(person -> System.out.println(person));

        personList.sort((Person person1, Person person2) -> person1.getSalary() - person2.getSalary());

        System.out.println("After Sorting By Salary :");

        personList.forEach(person -> System.out.println(person));


        System.out.println("\n\nBefore Sorting By Name :");

        personList.forEach(person -> System.out.println(person));

        personList.sort((Person person1, Person person2) -> person1.getName().compareTo(person2.getName()));

        //or  personList.sort((person1, person2) -> person1.getName().compareTo(person2.getName()));

        System.out.println("After Sorting By Name :");

        personList.forEach(person -> System.out.println(person));

        System.out.println("\n\nBefore Reverse Sorting By Name :");

        personList.forEach(person -> System.out.println(person));

        Comparator<Person> nameCompare = (person1, person2) -> person1.getName().compareTo(person2.getName());

        personList.sort(nameCompare.reversed());

        System.out.println("After Reverse Sorting By Name :");

        personList.forEach(person -> System.out.println(person));

    }
}
