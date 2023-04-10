/*
Note that in this implementation, we're using a HashSet to store the User objects, and a List to return all users. The findByEmail method iterates over the users set to find the user with the given email address.
The User class is a simple POJO that contains the user's email address and password. The User class also contains a method to validate the password. This method is used by the UserService to validate the password when a user logs in.
The UserService class is a simple service that provides methods to create a new user, find a user by email address, and get all users. The UserService class also provides a method to validate a user's password.
*/

package com.practice.springbootdemo.repositories;

import com.practice.springbootdemo.models.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class UserRepository {

    private Set<User> users = new HashSet<>();

    public User save(User user) {
        users.add(user);
        return user;
    }

    public List<User> findAll() {
        return new ArrayList<>(users);
    }

    public User findByEmail(String email) {
        for (User user : users) {
            if (user.getEmailId().equals(email)) {
                return user;
            }
        }
        return null;
    }

    public void delete(User user) {
        users.remove(user);
    }
}
