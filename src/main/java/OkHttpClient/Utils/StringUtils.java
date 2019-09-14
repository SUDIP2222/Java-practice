package OkHttpClient.Utils;

public class StringUtils {

    public static String nullToBlank(String string) {
        if (string == null) return "";
        return string;
    }

    public static String nullToBlank(Object object) {
        if (object == null) return "";
        return object.toString();
    }

}
