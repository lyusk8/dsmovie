package com.elias.dsmovie.entities.dtos;

import lombok.Data;

@Data
public class ScoreDto {

    private Long movieId;
    private String email;
    private Double score;
}
