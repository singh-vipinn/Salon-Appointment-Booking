package com.vstech.repository;

import com.vstech.modal.User;

import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
	
	public User findByEmail(String email);
}
