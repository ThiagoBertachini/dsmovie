package com.bertachini.dsmovie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bertachini.dsmovie.dto.MovieDTO;
import com.bertachini.dsmovie.dto.ScoreDTO;
import com.bertachini.dsmovie.entities.Movie;
import com.bertachini.dsmovie.entities.Score;
import com.bertachini.dsmovie.entities.User;
import com.bertachini.dsmovie.repositories.MovieRepository;
import com.bertachini.dsmovie.repositories.ScoreRepository;
import com.bertachini.dsmovie.repositories.UserRepository;

@Service	
public class ScoreService {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	MovieRepository movieRepository;
	
	@Autowired
	ScoreRepository scoreRepository;
	
	@Transactional
	public MovieDTO save(ScoreDTO scoreDTO) {
		
		User user = userRepository.findByEmail(scoreDTO.getEmail());
		if(user == null) {
			user = new User();
			user.setEmail(scoreDTO.getEmail());			
			user = userRepository.saveAndFlush(user);
		}
		
		Movie movie = movieRepository.findById(scoreDTO.getMovieId()).get();
		
		Score score = new Score();
		score.setMovie(movie);
		score.setUser(user);
		score.setValue(scoreDTO.getScore());
		
		score = scoreRepository.saveAndFlush(score);
		
		Double sum = 0.0;
		for(Score s : movie.getScores()) {
			sum = sum + s.getValue();
		}
		
		double avg = sum / movie.getScores().size();
		
		movie.setScore(avg);
		movie.setCount(movie.getScores().size());
		
		movie = movieRepository.save(movie);
		return new MovieDTO(movie);
	}
}
