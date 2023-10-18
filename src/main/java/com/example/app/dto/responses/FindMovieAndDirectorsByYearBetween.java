package com.example.app.dto.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FindMovieAndDirectorsByYearBetween {
    private Long movieId;

    private String movieName;

    private LocalDate sceneDate;

    private Double rating;

    private BigDecimal cost;

    private Double imdb;
    private Long directorId;

    private String directorFirstName;

    private String directorMiddleName;

    private String familyName;

    private LocalDate birthDate;
}
