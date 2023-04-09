public class CategoryNotFoundException extends RuntimeException {

    public CategoryNotFoundException(String message) {
        super("Category not found with name: ", + message);
    }

    public CategoryNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
