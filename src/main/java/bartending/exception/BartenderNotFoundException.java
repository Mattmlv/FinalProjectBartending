package bartending.exception;

public class BartenderNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

	public BartenderNotFoundException(String message) {
        super(message);
    }

    public BartenderNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
