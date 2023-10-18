package com.example.app.service;

import com.example.app.dto.requests.CreateMovieRequest;
import com.example.app.dto.requests.UpdateMovieRequest;
import com.example.app.dto.responses.*;
import com.example.app.mapper.ModelMapperService;
import com.example.app.model.entities.Director;
import com.example.app.model.entities.Movie;
import com.example.app.repository.MovieRepository;
import com.example.app.rules.MovieBusinessRules;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;
    private final ModelMapperService modelMapperService;
    private final MovieBusinessRules movieBusinessRules;

    @Override
    public List<GetAllMoviesResponse> getAll() {
        List<Movie> movies = movieRepository.findAll();

        List<GetAllMoviesResponse> moviesResponses = movies.stream()
                .map(movie -> this.modelMapperService
                        .forResponse().map(movie, GetAllMoviesResponse.class)).collect(Collectors.toList());

        return moviesResponses;
    }
    public void createMovie(CreateMovieRequest createMovieRequest) {

        this.movieBusinessRules.checkIfMovieNameExists(createMovieRequest.getMovieName());

        Movie movie = Movie
                .builder()
                .movieName(createMovieRequest.getMovieName())
                .imdb(createMovieRequest.getImdb())
                .cost(createMovieRequest.getCost())
                .rating(createMovieRequest.getRating())
                .sceneDate(createMovieRequest.getSceneDate())
                .build();

        movieRepository.save(movie);
        log.info("Movie {} is saved", movie.getMovieId());
    }
    @Override
    public void update(UpdateMovieRequest updateMovieRequest) {

        Movie movie = this.modelMapperService.forRequest().map(updateMovieRequest, Movie.class);

        this.movieRepository.save(movie);
        log.info("Movie {} is updated", movie.getMovieId());
    }

    @Override
    public void delete(Long id) {
        this.movieRepository.deleteById(id);

    }

    @Override
    public List<FindMoviesByMonth> findMoviesByMonth(int month) {
        List<Movie> movies = movieRepository.findMoviesByMonth(month);

        return movies.stream()
                .map(movie -> this.modelMapperService.forResponse()
                        .map(movie, FindMoviesByMonth.class)).collect(Collectors.toList());
    }

    @Override
    public List<FindMoviesByYear> findMoviesByYear(int year) {
        List<Movie> movies = movieRepository.findMoviesByYear(year);

        return movies.stream()
                .map(movie -> this.modelMapperService.forResponse()
                        .map(movie, FindMoviesByYear.class)).collect(Collectors.toList());
    }

    @Override
    public List<FindMoviesByMonthAndYear> findMoviesByMonthAndYear(int month, int year) {
        List<Movie> movies = movieRepository.findMoviesByMonthAndYear(month, year);

        return movies.stream()
                .map(movie -> this.modelMapperService.forResponse()
                        .map(movie, FindMoviesByMonthAndYear.class)).collect(Collectors.toList());
    }

    @Override
    public List<FindMoviesByYearBetween> findMoviesByYearBetween(int begin, int end) {
        List<Movie> movies = movieRepository.findMoviesByYearBetween(begin, end);

        return movies.stream()
                .map(movie -> this.modelMapperService.forResponse()
                        .map(movie, FindMoviesByYearBetween.class)).collect(Collectors.toList());
    }

    @Override
    public List<FindMoviesByDateBetween> findMoviesByDateBetween(LocalDate begin, LocalDate end) {
        List<Movie> movies = movieRepository.findMoviesByDateBetween(begin, end);

        return movies.stream()
                .map(movie -> this.modelMapperService.forResponse()
                        .map(movie, FindMoviesByDateBetween.class)).collect(Collectors.toList());
    }

    @Override
    public GetByIdMovieResponse getById(Long id) {
        Movie movie = this.movieRepository.findById(id).orElseThrow();

        return modelMapperService.forResponse()
                .map(movie, GetByIdMovieResponse.class);
    }

    @Override
    public long count() {
        return this.movieRepository.count();
    }


}
