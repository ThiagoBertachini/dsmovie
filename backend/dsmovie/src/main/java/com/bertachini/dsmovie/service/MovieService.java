package com.bertachini.dsmovie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import com.bertachini.dsmovie.dto.MovieDTO;
import com.bertachini.dsmovie.entities.Movie;
import com.bertachini.dsmovie.repositories.MovieRepository;

@Service
public class MovieService {
	
	@Autowired
	MovieRepository movieRepository;
	
	@Transactional(readOnly = true)
	public Page<MovieDTO> findAll(Pageable pageable){
		Page<Movie> result = movieRepository.findAll(pageable);
		Page<MovieDTO> page = result.map(x -> new MovieDTO(x));
		return page;
	}
	
	@Transactional(readOnly = true)
	public MovieDTO findById(Long id){
		Movie result = movieRepository.findById(id).get();
		MovieDTO page = new MovieDTO(result);
		return page;
	}
	
	public MovieDTO save(Movie movie) {
		Movie movieData = movieRepository.save(movie);
		return new MovieDTO(movieData);
	}

}
