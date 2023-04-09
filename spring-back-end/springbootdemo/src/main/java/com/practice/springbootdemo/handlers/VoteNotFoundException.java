package com.example.forum.exceptions;

public class VoteNotFoundException extends RuntimeException {

    public VoteNotFoundException(Long id) {
        super("Vote with id " + id + " not found.");
    }

}
