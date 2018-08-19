package com.practice.springbootdemo.repositories;

import com.practice.springbootdemo.models.Role;
import com.practice.springbootdemo.models.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repo of Roles.
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    public Optional<Role> getRoleByName(RoleEnum name);
}
