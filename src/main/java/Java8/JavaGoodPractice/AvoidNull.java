package Java8.JavaGoodPractice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AvoidNull {

    private static List<String> getMails() {
        List<String> emails = null; //new ArrayList<>();
        /*emails.add("a@gmail.com");
        emails.add("b@gmail.com");
        return emails;*/
        return (null == emails) ? Collections.emptyList() : emails;
    }

    public static void main (String[] args) {
        List<String> emails = getMails();
        System.out.println(emails);
    }
}
