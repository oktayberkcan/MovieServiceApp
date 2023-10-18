package com.example.app.dto.responses;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdMovieResponse {
    private Long movieId;
    private String movieName;
    private LocalDate sceneDate;
    private Double rating;
    private BigDecimal cost;
    private Double imdb;
}
