package OkHttpClient.exceptions;

import java.util.Set;

public class BadRequestException extends ApiException {

    int SC_STATUS = 400;

    public BadRequestException(String message) {
        super(message);
    }

    public BadRequestException(String message, Object extraMessage) {
        super(message, extraMessage);
    }

    public BadRequestException(Set errors) {
        super(errors);
    }

    public BadRequestException(Object error) {
        super(error);
    }

    /**
     * @param cause
     */
    public BadRequestException(Throwable cause) {
        super(cause);
    }

    /**
     * @param message
     * @param cause
     */
    public BadRequestException(String message, Throwable cause) {
        super(message, cause);
    }

    public int getServiceStatus() {
        return SC_STATUS;
    }

    public String getServiceMessage() {
        return "Bad Request";
    }

}
