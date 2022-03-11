package com.elias.dsmovie.services;

import com.elias.dsmovie.entities.Score;
import com.elias.dsmovie.entities.ScorePK;
import com.elias.dsmovie.entities.User;
import com.elias.dsmovie.entities.dtos.MovieDto;
import com.elias.dsmovie.entities.dtos.ScoreDto;
import com.elias.dsmovie.repositories.MovieRepository;
import com.elias.dsmovie.repositories.ScoreRepository;
import com.elias.dsmovie.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ScoreService {

    private final MovieRepository movieRepository;
    private final UserRepository userRepository;
    private final ScoreRepository repository;

    @Transactional
    public MovieDto saveScore(ScoreDto dto){
        var user = userRepository.findByEmail(dto.getEmail());
        var movie = movieRepository.findById(dto.getMovieId()).get();

        if(user == null){
            user = new User();
            user.setEmail(dto.getEmail());
            user = userRepository.saveAndFlush(user);
        }

        Score score = new Score();
        score.setMovie(movie);
        score.setUser(user);
        score.setValue(dto.getScore());

        score = repository.saveAndFlush(score);

        var sum = 0.0;
        for(Score s : movie.getScores()){
            sum += s.getValue();
        }

        var avg = sum/ movie.getScores().size();
        movie.setScore(avg);
        movie.setCount(movie.getScores().size());

        movie = movieRepository.save(movie);

        return new MovieDto(movie);
    }
}
