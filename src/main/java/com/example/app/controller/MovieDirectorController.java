package com.example.app.controller;

import com.example.app.dto.responses.FindMovieAndDirectorsByYearBetween;
import com.example.app.dto.responses.FindMoviesAndDirectorsByDateBetween;
import com.example.app.dto.responses.GetAllMoviesWithDirectors;
import com.example.app.service.MovieDirectorService;
import com.example.app.service.MovieDirectorServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("api/md")
@RequiredArgsConstructor
public class MovieDirectorController {
    private final MovieDirectorServiceImpl movieDirectorServiceImpl;
    @GetMapping("getAll")
    @ResponseStatus(HttpStatus.OK)
    public List<GetAllMoviesWithDirectors> getAllMoviesWithDirectors() {
        return movieDirectorServiceImpl.getAllMoviesWithDirectors();
    }
    @GetMapping("find/date/scene/between")
    @ResponseStatus(HttpStatus.OK)
    public List<FindMoviesAndDirectorsByDateBetween> findMoviesAndDirectorsByDateBetween(LocalDate begin, LocalDate end) {

        return movieDirectorServiceImpl.findMoviesAndDirectorsByDateBetween(begin, end);
    }
    @GetMapping("find/date/year/between")
    @ResponseStatus(HttpStatus.OK)
    public List<FindMovieAndDirectorsByYearBetween> findMoviesAndDirectorsByYearBetween(int begin, int end) {
        return movieDirectorServiceImpl.findMoviesAndDirectorsByYearBetween(begin, end);
    }


}
