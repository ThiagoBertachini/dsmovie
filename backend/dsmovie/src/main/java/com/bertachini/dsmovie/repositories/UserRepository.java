package com.bertachini.dsmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bertachini.dsmovie.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	public User findByEmail(String email);
	
	

}
