/*
Note that this implementation is just an example and not tested, and might not be suitable for production use. It's recommended to use a proper database like MySQL, PostgreSQL or MongoDB instead of using List and HashSet as the main data store.
*/

package com.practice.springbootdemo.repositories;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.practice.springbootdemo.models.Role;
import com.practice.springbootdemo.models.RoleEnum;

@Repository
public class RoleRepository {
	
	private final Set<Role> roles = new HashSet<>();
	private int nextId = 1;

	public List<Role> findAll() {
		return new ArrayList<>(roles);
	}

	public Optional<Role> findById(int id) {
		return roles.stream()
				.filter(role -> role.getId() == id)
				.findFirst();
	}

	public Optional<Role> findByName(RoleEnum name) {
		return roles.stream()
				.filter(role -> role.getName() == name)
				.findFirst();
	}

	public Role save(Role role) {
		if (role.getId() == 0) {
			role.setId(nextId++);
			roles.add(role);
		} else {
			roles.removeIf(existingRole -> existingRole.getId() == role.getId());
			roles.add(role);
		}
		return role;
	}

	public void deleteById(int id) {
		roles.removeIf(role -> role.getId() == id);
	}

	public void deleteAll() {
		roles.clear();
	}

}
