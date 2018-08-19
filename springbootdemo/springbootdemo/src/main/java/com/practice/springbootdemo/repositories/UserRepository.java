package com.practice.springbootdemo.repositories;

import com.practice.springbootdemo.models.Role;
import com.practice.springbootdemo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repo of Users. Abstraction to MySQL DB used.
 */
@Repository
public interface UserRepository extends JpaRepository<User, String> {
    public List<Role> getRoleListByEmailId(String emailId);
}
