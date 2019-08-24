package Java8.JavaGoodPractice;

import Java8.JavaGoodPractice.CustomExecption.ApiNotFoundException;
import Java8.Lambda.Person;

import java.util.Objects;

public class CustomException {
    public static void main(String args[]) {
        try {
            getData();
        } catch (ApiNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void getData() throws ApiNotFoundException {
        Person person = null; // create null object
        if(Objects.isNull(person)) {
            throw new ApiNotFoundException("Person Not Found");
        }
    }
}
