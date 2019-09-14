package OkHttpClient.exceptions;

public class AuthorizationException extends ApiException {

    int SC_STATUS = 401;

    public AuthorizationException(String message) {
        super(message);
    }

    public AuthorizationException(String message, Object extraMessage) {
        super(message, extraMessage);
    }

    /**
     * @param cause
     */
    public AuthorizationException(Throwable cause) {
        super(cause);
    }

    public AuthorizationException(Object error) {
        super(error);
    }

    /**
     * @param message
     * @param cause
     */
    public AuthorizationException(String message, Throwable cause) {
        super(message, cause);
    }

    public int getServiceStatus() {
        return SC_STATUS;
    }

    public String getServiceMessage() {
        return "Unauthorized";
    }

}
