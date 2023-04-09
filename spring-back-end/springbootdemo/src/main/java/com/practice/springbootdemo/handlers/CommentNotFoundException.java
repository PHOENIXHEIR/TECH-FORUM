public class CommentNotFoundException extends RuntimeException {

    public CommentNotFoundException(Long commentId) {
        super("Comment not found with id: " + commentId);
    }

    public CommentNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
