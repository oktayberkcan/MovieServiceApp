package com.example.app.dto.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateMovieRequest {
    private String movieName;
    private LocalDate sceneDate;
    private Double rating;
    private BigDecimal cost;
    private Double imdb;

}
