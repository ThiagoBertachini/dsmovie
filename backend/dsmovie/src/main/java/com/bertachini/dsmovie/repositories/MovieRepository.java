package com.bertachini.dsmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bertachini.dsmovie.entities.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {
	
	

}
