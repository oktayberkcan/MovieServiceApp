package com.example.app.service;

import com.example.app.dto.requests.UpdateMovieRequest;
import com.example.app.dto.responses.*;
import com.example.app.model.entities.Movie;

import java.time.LocalDate;
import java.util.List;

public interface MovieService {

    List<GetAllMoviesResponse> getAll();
    void update(UpdateMovieRequest updateMovieRequest);
    void delete(Long id);
    long count();
    List<FindMoviesByMonth> findMoviesByMonth(int month);
    List<FindMoviesByYear> findMoviesByYear(int year);
    List<FindMoviesByMonthAndYear> findMoviesByMonthAndYear(int month, int year);
    List<FindMoviesByYearBetween> findMoviesByYearBetween(int begin, int end);
    List<FindMoviesByDateBetween> findMoviesByDateBetween(LocalDate begin, LocalDate end);
    GetByIdMovieResponse getById(Long id);

}
