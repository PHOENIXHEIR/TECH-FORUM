/*
Note that this implementation assumes that the Post class has been updated to include a hashCode and equals method that compare the id field. The userEmailSet is used to check if a given user email is in the repository before adding a new post for that user. The deleteUserPosts method removes all posts with the given user email from the repository.
*/

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PostRepository {
    private List<Post> postList;
    private Set<String> userEmailSet;

    public PostRepository() {
        postList = new ArrayList<>();
        userEmailSet = new HashSet<>();
    }

    public void save(Post post) {
        if (userEmailSet.contains(post.getUserEmailId())) {
            postList.add(post);
        } else {
            System.out.println("User email not found in repository");
        }
    }

    public Post getPostById(int id) {
        for (Post post : postList) {
            if (post.getId() == id) {
                return post;
            }
        }
        throw new PostNotFoundException("Post not found with ID: " + id);
    }
    

    public List<Post> findByUserEmail(String userEmail) {
        List<Post> userPostList = new ArrayList<>();
        for (Post post : postList) {
            if (post.getUserEmailId().equals(userEmail)) {
                userPostList.add(post);
            }
        }
        return userPostList;
    }

    public List<Post> findByTimestamp(Date timestamp) {
        List<Post> timestampPostList = new ArrayList<>();
        for (Post post : postList) {
            if (post.getTimestamp().equals(timestamp)) {
                timestampPostList.add(post);
            }
        }
        return timestampPostList;
    }

    public List<Post> findAll() {
        return postList;
    }

    public void deleteUserPosts(String userEmail) {
        List<Post> toRemove = new ArrayList<>();
        for (Post post : postList) {
            if (post.getUserEmailId().equals(userEmail)) {
                toRemove.add(post);
            }
        }
        postList.removeAll(toRemove);
    }
}
