package com.example.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieWithDirectorDTO {
   private Long id;
   private String movieName;
   private LocalDate sceneDate;
   private String directorFirstName;
   private String directorMiddleName;
   private String familyName;
   private LocalDate birthDate;
   private Double rating;
   private BigDecimal cost;
   private Double imdb;
   private Long directorId;


}
