package Java8.JavaGoodPractice;

public class FinallyBlockExmple {
    public static void main(String[] args) {
        try{

        } catch(Exception e){

        }
        finally{
            // Close Stream , Database Connection, file etc ......
        }
    }
}
