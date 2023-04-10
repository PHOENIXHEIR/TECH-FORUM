/*
Note that this implementation is a simplified example and does not include error handling or any database interaction.
*/
package com.practice.springbootdemo.repositories;

import com.practice.springbootdemo.models.Comment;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class CommentRepository {

    private Set<Comment> comments = new HashSet<>();

    public List<Comment> findAll() {
        return new ArrayList<>(comments);
    }

    public Comment findById(String id) {
        for (Comment comment : comments) {
            if (comment.getId().equals(id)) {
                return comment;
            }
        }
        return null;
    }

    public void save(Comment comment) {
        comments.add(comment);
    }

    public void deleteById(String id) {
        Comment commentToRemove = null;
        for (Comment comment : comments) {
            if (comment.getId().equals(id)) {
                commentToRemove = comment;
                break;
            }
        }
        if (commentToRemove != null) {
            comments.remove(commentToRemove);
        }
    }

}
