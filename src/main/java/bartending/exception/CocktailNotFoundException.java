package bartending.exception;

public class CocktailNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

	public CocktailNotFoundException(String message) {
        super(message);
    }

    public CocktailNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
