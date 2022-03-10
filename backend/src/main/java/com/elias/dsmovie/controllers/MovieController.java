package com.elias.dsmovie.controllers;


import com.elias.dsmovie.entities.dtos.MovieDto;
import com.elias.dsmovie.services.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movies")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService service;

    @GetMapping()
    public Page<MovieDto> findAll(Pageable pageable){
        return service.findAll(pageable);
    }

    @GetMapping("/{id}")
    public MovieDto findAll(@PathVariable Long id){
        return service.findById(id);
    }

//    @PostMapping
//    public (){}
//
//    @PutMapping
//    public (){}
//
//    @DeleteMapping
//    public (){}
}
