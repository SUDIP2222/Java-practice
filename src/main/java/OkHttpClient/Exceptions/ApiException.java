package OkHttpClient.Exceptions;

public class ApiException extends Exception {

    private String extraMessage;
    private Object error;

    /**
     * @param message
     */
    public ApiException(String message) {
        super(message);
    }

    public ApiException(String message, Object extraMessage) {
        super(message);
        this.extraMessage = extraMessage.toString();
    }


    public ApiException(Object error) {
        this.error = error;
    }

    /**
     * @param cause
     */
    public ApiException(Throwable cause) {
        super(cause);
    }

    /**
     * @param message
     * @param cause
     */
    public ApiException(String message, Throwable cause) {
        super(message, cause);
    }

    public String getExtraMessage() {
        return this.extraMessage;
    }

    public int getServiceStatus() {
        return 0;
    }

    public String getServiceMessage() {
        return "";
    }


    public Object getError() {
        return error;
    }
}
