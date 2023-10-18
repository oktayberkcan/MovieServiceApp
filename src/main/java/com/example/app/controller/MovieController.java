package com.example.app.controller;

import com.example.app.dto.requests.CreateMovieRequest;
import com.example.app.dto.requests.UpdateMovieRequest;
import com.example.app.dto.responses.*;
import com.example.app.service.MovieService;
import com.example.app.service.MovieServiceImpl;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/movies")
@RequiredArgsConstructor
public class MovieController {

    private final MovieServiceImpl movieServiceImpl;

    @GetMapping("all")
    @ResponseStatus(HttpStatus.OK)
    public List<GetAllMoviesResponse> getAllMovies() {

        return movieServiceImpl.getAll();
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createMovie(@RequestBody CreateMovieRequest createMovieRequest) {
        this.movieServiceImpl.createMovie(createMovieRequest);
    }
    @PutMapping()
    public void update(@RequestBody UpdateMovieRequest updateMovieRequest) {
        this.movieServiceImpl.update(updateMovieRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.movieServiceImpl.delete(id);
    }
    @GetMapping("count")
    public long count() {
       return movieServiceImpl.count();
    }
    @GetMapping("find/date/month")
    @ResponseStatus(HttpStatus.OK)
    public List<FindMoviesByMonth> findMoviesByMonth(@RequestParam(name = "m") int month) {

        return movieServiceImpl.findMoviesByMonth(month);
    }
    @GetMapping("find/date/year")
    @ResponseStatus(HttpStatus.OK)
    public List<FindMoviesByYear> findMoviesByYear(@RequestParam(name = "y") int year) {

        return movieServiceImpl.findMoviesByYear(year);
    }
    @GetMapping("find/date/month&year")
    @ResponseStatus(HttpStatus.OK)
    public List<FindMoviesByMonthAndYear> findMoviesByMonthAndYear(@RequestParam(name = "y") int year,@RequestParam(name = "m") int month)  {

        return movieServiceImpl.findMoviesByMonthAndYear(month, year);

    }
    @GetMapping("find/date/year/between")
    @ResponseStatus(HttpStatus.OK)
    public List<FindMoviesByYearBetween> findMoviesByYearBetween(@RequestParam(name = "b") int begin, @RequestParam(name = "e") int end)  {

        return movieServiceImpl.findMoviesByYearBetween(begin, end);

    }
    @GetMapping("find/date/scene/between")
    @ResponseStatus(HttpStatus.OK)
    public List<FindMoviesByDateBetween> findMoviesByDateBetween(LocalDate begin, LocalDate end) {

        return movieServiceImpl.findMoviesByDateBetween(begin, end);
    }
    @GetMapping("/{id}")
    public GetByIdMovieResponse getById(@PathVariable Long id) {
        return movieServiceImpl.getById(id);
    }
}
