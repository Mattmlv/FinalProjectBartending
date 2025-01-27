package bartending.exception;

public class IngredientNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

	public IngredientNotFoundException(String message) {
        super(message);
    }

    public IngredientNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
