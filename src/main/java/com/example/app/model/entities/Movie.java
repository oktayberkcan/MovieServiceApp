package com.example.app.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Table(name = "movies")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id")
    private Long movieId;
    @Column(name = "movie_name")
    private String movieName;
    @Column(name = "scene_date")
    private LocalDate sceneDate;
    @Column(name = "rating")
    private Double rating;
    @Column(name = "cost")
    private BigDecimal cost;
    @Column(name = "imdb")
    private Double imdb;
    @JsonIgnore
    @ManyToMany(mappedBy = "movies", fetch = FetchType.LAZY)
    private Set<Director> directors;

}
