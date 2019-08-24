package Java8.JavaGoodPractice.CustomExecption;

public class ApiNotFoundException extends Exception {

    private static final long serialVersionUID = 7718828512143293558L;

    private String code = "404";

    /*public ApiNotFoundException(String code) {
        super();
        this.code = code;
    }*/

    public ApiNotFoundException(String message, Throwable cause, String code) {
        super(message, cause);
        this.code = code;
    }

    public ApiNotFoundException(String message) {
        super(message);
    }

    public ApiNotFoundException(Throwable cause, String code) {
        super(cause);
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }
}
