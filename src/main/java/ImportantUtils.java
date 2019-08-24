import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ImportantUtils {
    public static void main(String[] args) {

        System.out.println(stringToCapitalizeEveryWord("I am a java developer And wnat to be a good java developer"));

        System.out.println(stringToWords("I am a java developer And wnat to be a good java developer"));

    }

    public static String stringToCapitalizeEveryWord(final String string) {
        //return Pattern.compile("\\b(?=\\w)").splitAsStream(string).collect(Collectors.toList());
        return Pattern.compile("\\b(?=\\w)").splitAsStream(string)
                .map(words -> stringToCapitalize(words, false)).collect(Collectors.joining());
    }

    public static String stringToCapitalize(String input, boolean lowerRest) {
        return input.substring(0, 1).toUpperCase() +
                (lowerRest ? input.substring(1).toLowerCase() : input.substring(1));
    }

    public static List<String> stringToWords(final String string) {
        return Arrays.stream(string.split("[^a-zA-Z-]+")).filter(words -> !words.isEmpty())
                .collect(Collectors.toList());
    }
}
