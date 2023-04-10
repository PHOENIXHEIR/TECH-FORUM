package com.practice.springbootdemo.models;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Document
public class Post {
    @Id
    private String id;
    private String userEmailId;

    private String heading, body;
    private Date timestamp;
    private Set<String> tags;
    private List<Comment> comments;

    public Post(String userEmailId, String heading, String body, Set<String> tags){
        this.userEmailId = userEmailId;
        this.heading = heading;
        this.body = body;
        this.tags = tags;
        this.comments = new ArrayList<>();
    }

    public Post() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getUserEmailId() {
        return userEmailId;
    }

    public void setUserEmailId(String userEmailId) {
        this.userEmailId = userEmailId;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public Set<String> getTags() {
        return tags;
    }

    public void setTags(Set<String> tags) {
        this.tags = tags;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public void addComment(Comment comment) {
        this.comments.add(comment);
    }

    @Override
    public String toString() {
        return "Post{" +
                "id='" + id + '\'' +
                ", userEmailId='" + userEmailId + '\'' +
                ", heading='" + heading + '\'' +
                ", body='" + body + '\'' +
                ", timestamp=" + timestamp +
                ", tags=" + tags +
                ", comments=" + comments +
                '}';
    }
}
