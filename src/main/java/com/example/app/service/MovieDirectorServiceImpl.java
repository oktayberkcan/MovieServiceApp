package com.example.app.service;

import com.example.app.dto.responses.FindMovieAndDirectorsByYearBetween;
import com.example.app.dto.responses.FindMoviesAndDirectorsByDateBetween;
import com.example.app.dto.MovieWithDirectorDTO;
import com.example.app.dto.responses.GetAllMoviesResponse;
import com.example.app.dto.responses.GetAllMoviesWithDirectors;
import com.example.app.mapper.ModelMapperService;
import com.example.app.model.entities.Director;
import com.example.app.model.entities.Movie;
import com.example.app.repository.DirectorRepository;
import com.example.app.repository.MovieDirectorRepository;
import com.example.app.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class MovieDirectorServiceImpl implements MovieDirectorService {
    private final MovieDirectorRepository movieDirectorRepository;
    private final ModelMapperService modelMapperService;
    private final MovieRepository movieRepository;
    private final DirectorRepository directorRepository;


    @Override
    public List<FindMoviesAndDirectorsByDateBetween> findMoviesAndDirectorsByDateBetween(LocalDate begin, LocalDate end) {

        List<MovieWithDirectorDTO> movieWithDirectorDTOS = movieDirectorRepository.findMoviesAndDirectorsByDateBetween(begin, end);

        return movieWithDirectorDTOS.stream()
                .map(movieWithDirectorDTO -> this.modelMapperService.forResponse()
                        .map(movieWithDirectorDTO, FindMoviesAndDirectorsByDateBetween.class)).collect(Collectors.toList());

    }

    @Override
    public List<GetAllMoviesWithDirectors> getAllMoviesWithDirectors() {

        List<MovieWithDirectorDTO> movieWithDirectorDTOS = movieDirectorRepository.getAllMoviesWithDirectors();

        return movieWithDirectorDTOS.stream()
                .map(movieWithDirectorDTO -> this.modelMapperService.forResponse()
                        .map(movieWithDirectorDTO, GetAllMoviesWithDirectors.class)).collect(Collectors.toList());
    }

    @Override
    public List<FindMovieAndDirectorsByYearBetween> findMoviesAndDirectorsByYearBetween(int begin, int end) {
        List<MovieWithDirectorDTO> movieWithDirectorDTOS = movieDirectorRepository.findMoviesAndDirectorsByYearBetween(begin, end);

        return movieWithDirectorDTOS.stream()
                .map(movieWithDirectorDTO -> this.modelMapperService.forResponse()
                        .map(movieWithDirectorDTO, FindMovieAndDirectorsByYearBetween.class)).collect(Collectors.toList());
    }
}