package com.example.app.service;

import com.example.app.dto.MovieWithDirectorDTO;
import com.example.app.dto.responses.FindMovieAndDirectorsByYearBetween;
import com.example.app.dto.responses.FindMoviesAndDirectorsByDateBetween;
import com.example.app.dto.responses.GetAllMoviesWithDirectors;

import java.time.LocalDate;
import java.util.List;

public interface MovieDirectorService {
    List<FindMoviesAndDirectorsByDateBetween> findMoviesAndDirectorsByDateBetween(LocalDate begin, LocalDate end);
    List<GetAllMoviesWithDirectors> getAllMoviesWithDirectors();
    List<FindMovieAndDirectorsByYearBetween> findMoviesAndDirectorsByYearBetween(int begin, int end);
}
