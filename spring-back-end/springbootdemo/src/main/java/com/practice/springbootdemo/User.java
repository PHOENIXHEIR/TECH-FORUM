package com.practice.springbootdemo.models;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.persistence.*;
import java.util.*;

@Entity
public class User {
	
	@Id
	private String emailId;
	private String password;

	@ManyToMany(targetEntity = Role.class, fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	Set<Role> roleSet = new HashSet<>();

	public User(){
	}

	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) { 
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Role> getRoleSet() {
		return roleSet;
	}
	public void setRoleSet(Set<Role> roleSet) {
		this.roleSet = roleSet;
	}

	public void addRole(Role role){
		this.roleSet.add(role);
	}

	public Collection<GrantedAuthority> getAuthorities(){
		Set<GrantedAuthority> authorities = new HashSet<>();

		for (Role role: this.getRoleSet()){
			authorities.add(new SimpleGrantedAuthority(role.getName().toString()));
		}

		return authorities;
	}

	public boolean hasRole(Role role){
		return getAuthorities().contains(new SimpleGrantedAuthority(role.getName().toString()));
	}

	@Override
	public String toString() {
		return "User{" +
				"emailId='" + emailId + '\'' +
				", password='" + password + '\'' +
				", roleSet=" + roleSet +
				'}';
	}
}
