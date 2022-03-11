package com.elias.dsmovie.controllers;

import com.elias.dsmovie.entities.dtos.MovieDto;
import com.elias.dsmovie.entities.dtos.ScoreDto;
import com.elias.dsmovie.services.ScoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/scores")
@RequiredArgsConstructor
public class ScoreController {

    private final ScoreService service;

//    @GetMapping()
//    public (){}
//
//    @PostMapping
//    public (){}
//
    @PutMapping()
    public MovieDto update(@RequestBody ScoreDto dto){

        var movieDto = service.saveScore(dto);
        return movieDto;
    }
//
//    @DeleteMapping
//    public (){}
}
