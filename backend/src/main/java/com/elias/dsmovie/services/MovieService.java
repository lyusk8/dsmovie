package com.elias.dsmovie.services;

import com.elias.dsmovie.entities.Movie;
import com.elias.dsmovie.entities.dtos.MovieDto;
import com.elias.dsmovie.repositories.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository repository;

    @Transactional(readOnly = true)
    public Page<MovieDto> findAll(Pageable pageable){
        Page<Movie> movies = repository.findAll(pageable);
        return movies.map(MovieDto::new);
    }

    @Transactional(readOnly = true)
    public MovieDto findById(Long id){
        var movie = repository.findById(id).get();
        return new MovieDto(movie);
    }
}

