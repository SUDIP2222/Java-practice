package Java8.JavaGoodPractice;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ExceptionHandle {
    public static void main(String[] args) throws IOException {
        // throws or catch Specific Exception
        //throws Exception or catch (Exception e) is bad if you identify Specific Exception
        String fileName = "c://user/sudip/lines.txt";

        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            List<String> list = stream.filter(line -> !line.startsWith("line3"))
                    .map(String::toUpperCase)
                    .collect(Collectors.toList());

            list.forEach(System.out::println);
        } catch (IOException ioException) { // can use multiple exception in catch block by '|'
            ioException.printStackTrace();  // log here
            //Don't log and throws Exception
        }

    }
}
