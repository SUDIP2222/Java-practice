package Java8.JavaGoodPractice;

public class StirngBuliderExmple {
    public static void main(String[] args) {
        //use StringBuilder

        //Slower Instantiation
        String firstExmple = "Slower Instantiation";

        //Faster Instantiation
        String secondExmple = "Faster Instantiation";

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("String Exmple");

        System.out.println(stringBuilder);
    }
}
