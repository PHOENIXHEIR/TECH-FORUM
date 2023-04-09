public class PostNotFoundException extends RuntimeException {

    public PostNotFoundException(String postId) {
        super("Post not found with id: " + postId);
    }

    public PostNotFoundException(String postId, Throwable cause) {
        super("Post not found with id: " + postId, cause);
    }
}
