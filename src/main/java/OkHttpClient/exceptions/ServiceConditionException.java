package OkHttpClient.exceptions;


public class ServiceConditionException extends ApiException {

    int SC_STATUS = 503;

    public ServiceConditionException(String message) {
        super(message);
    }

    public ServiceConditionException(String message, Object extraMessage) {
        super(message, extraMessage);
    }

    /**
     * @param cause
     */
    public ServiceConditionException(Throwable cause) {
        super(cause);
    }

    public ServiceConditionException(Object error) {
        super(error);
    }

    /**
     * @param message
     * @param cause
     */
    public ServiceConditionException(String message, Throwable cause) {
        super(message, cause);
    }

    public int getServiceStatus() {
        return SC_STATUS;
    }

    public String getServiceMessage() {
        return "Service Unavailable";
    }

}
