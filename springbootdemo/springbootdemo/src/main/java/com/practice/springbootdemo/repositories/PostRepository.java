package com.practice.springbootdemo.repositories;

import com.practice.springbootdemo.models.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository of Posts. Abstraction to the MongoDB Database.
 */
@Repository
public interface PostRepository extends MongoRepository<Post, String> {
    public List<Post> findByUserEmailId(String userEmailId);
    public List<Post> findAllByOrderByTimestampDesc();
}
