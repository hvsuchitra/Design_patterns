package textdecorators.exceptions;

public class AppException extends RuntimeException {

    private static final long serialVersionUID = -4318519315232674317L;

    public AppException() {
        super();
    }

    public AppException(String msg) {
        super(msg);
    }

    public AppException(String msg, Exception e) {
        super(msg, e);
    }
}
