package com.bertachini.dsmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bertachini.dsmovie.entities.Score;
import com.bertachini.dsmovie.entities.ScorePK;

public interface ScoreRepository extends JpaRepository<Score, ScorePK> {
	
}
