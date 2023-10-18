package com.example.app.rules;

import com.example.app.exceptions.BusinessException;
import com.example.app.repository.MovieRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MovieBusinessRules {
    private MovieRepository movieRepository;

    public void checkIfMovieNameExists(String name) {
        if (this.movieRepository.existsByMovieName(name)) {
            throw new BusinessException("Movie name already exists");
        }
    }
}
