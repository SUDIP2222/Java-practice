package OkHttpClient.exceptions;

public class SystemException extends ApiException {

    int SC_STATUS = 500;

    public SystemException(String message) {
        super(message);
    }

    public SystemException(String message, Object extraMessage) {
        super(message, extraMessage);
    }

    /**
     * @param cause
     */
    public SystemException(Throwable cause) {
        super(cause);
    }

    public SystemException(Object error) {
        super(error);
    }

    /**
     * @param message
     * @param cause
     */
    public SystemException(String message, Throwable cause) {
        super(message, cause);
    }

    public int getServiceStatus() {
        return SC_STATUS;
    }

    public String getServiceMessage() {
        return "Internal Server Error";
    }

}
