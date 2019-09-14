package OkHttpClient.exceptions;

import java.util.Set;

public class NotFoundException extends ApiException {

    int SC_STATUS = 404;

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(String message, Object extraMessage) {
        super(message, extraMessage);
    }

    /**
     * @param cause
     */
    public NotFoundException(Throwable cause) {
        super(cause);
    }

    public NotFoundException(Set errors) {
        super(errors);
    }

    public NotFoundException(Object error) {
        super(error);
    }

    /**
     * @param message
     * @param cause
     */
    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public int getServiceStatus() {
        return SC_STATUS;
    }

    public String getServiceMessage() {
        return "Not Found";
    }
}
