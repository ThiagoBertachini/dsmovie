package com.bertachini.dsmovie.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bertachini.dsmovie.entities.MovieDTO;
import com.bertachini.dsmovie.service.MovieService;

@RestController
@RequestMapping(value = "/movies")
public class MovieController {
	
	@Autowired
	MovieService movieService;
	
	@GetMapping
	public Page<MovieDTO> findAll(Pageable pageable) {
		return movieService.findAll(pageable);
	}
	
	@GetMapping(value = "/{id}")
	public MovieDTO findByID(@PathVariable("id") Long id) {
		return movieService.findById(id);
	}
	
}
