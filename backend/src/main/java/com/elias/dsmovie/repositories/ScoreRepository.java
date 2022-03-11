package com.elias.dsmovie.repositories;

import com.elias.dsmovie.entities.Score;
import com.elias.dsmovie.entities.ScorePK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScoreRepository extends JpaRepository<Score, ScorePK> {
}
