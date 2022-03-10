package com.elias.dsmovie.entities.dtos;

import com.elias.dsmovie.entities.Movie;
import lombok.Data;

@Data
public class MovieDto {

    private Long id;
    private String title;
    private Double score;
    private Integer count;
    private String image;

    public MovieDto(Movie movie){
        id = movie.getId();
        title = movie.getTitle();
        score = movie.getScore();
        count = movie.getCount();
        image = movie.getImage();
    }

}
