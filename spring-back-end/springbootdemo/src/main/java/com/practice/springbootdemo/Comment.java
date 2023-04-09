import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Document
public class Comment {
    @Id
    private String id;

    private Post post;
    private String userEmailId;
    private String content;
    private Date timestamp;

    private List<String> postIds;
    private Set<String> likedBy;

    public Comment(Post post, String userEmailId, String content){
        this.post = post;
        this.userEmailId = userEmailId;
        this.content = content;
        this.postIds = List.of(post.getId());
        this.likedBy = new HashSet<>();
    }

    public Comment() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
        this.postIds = List.of(post.getId());
    }

    public String getUserEmailId() {
        return userEmailId;
    }

    public void setUserEmailId(String userEmailId) {
        this.userEmailId = userEmailId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public List<String> getPostIds() {
        return postIds;
    }

    public void setPostIds(List<String> postIds) {
        this.postIds = postIds;
    }

    public Set<String> getLikedBy() {
        return likedBy;
    }

    public void setLikedBy(Set<String> likedBy) {
        this.likedBy = likedBy;
    }

    public void addLike(String userEmailId) {
        this.likedBy.add(userEmailId);
    }

    public void removeLike(String userEmailId) {
        this.likedBy.remove(userEmailId);
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id='" + id + '\'' +
                ", post=" + post +
                ", userEmailId='" + userEmailId + '\'' +
                ", content='" + content + '\'' +
                ", timestamp=" + timestamp +
                ", postIds=" + postIds +
                ", likedBy=" + likedBy +
                '}';
    }
}
