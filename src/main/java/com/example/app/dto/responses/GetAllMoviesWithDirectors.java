package com.example.app.dto.responses;

import com.example.app.model.entities.Director;
import com.example.app.model.entities.Movie;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetAllMoviesWithDirectors {
   private Movie movie;
   private Director director;

}