/*
Note that this is just an example implementation and may need to be adapted to your specific requirements.
*/
package com.practice.springbootdemo.repositories;

import com.practice.springbootdemo.models.Post;
import com.practice.springbootdemo.models.User;
import com.practice.springbootdemo.models.Vote;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class VoteRepository {
    private List<Vote> voteList = new ArrayList<>();

    // Find all votes
    public List<Vote> findAll() {
        return voteList;
    }

    // Find all votes for a post
    public List<Vote> findByPost(Post post) {
        List<Vote> result = new ArrayList<>();
        for (Vote vote : voteList) {
            if (vote.getPost().equals(post)) {
                result.add(vote);
            }
        }
        return result;
    }

    // Find all votes by a user
    public List<Vote> findByUser(User user) {
        List<Vote> result = new ArrayList<>();
        for (Vote vote : voteList) {
            if (vote.getUser().equals(user)) {
                result.add(vote);
            }
        }
        return result;
    }

    // Save a vote
    public void save(Vote vote) {
        voteList.add(vote);
    }

    // Remove a vote
    public void delete(Vote vote) {
        voteList.remove(vote);
    }

    // Remove all votes for a post
    public void deleteByPost(Post post) {
        Set<Vote> votesToRemove = new HashSet<>();
        for (Vote vote : voteList) {
            if (vote.getPost().equals(post)) {
                votesToRemove.add(vote);
            }
        }
        voteList.removeAll(votesToRemove);
    }

    // Remove all votes by a user
    public void deleteByUser(User user) {
        Set<Vote> votesToRemove = new HashSet<>();
        for (Vote vote : voteList) {
            if (vote.getUser().equals(user)) {
                votesToRemove.add(vote);
            }
        }
        voteList.removeAll(votesToRemove);
    }
}
