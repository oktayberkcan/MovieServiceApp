package com.example.app.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Table(name = "directors")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Director {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "director_id")
    private Long directorId;
    @Column(name = "first_name")
    private String directorFirstName;
    @Column(name = "middle_name")
    private String directorMiddleName;
    @Column(name = "family_name")
    private String familyName;
    @Column(name = "birth_date")
    private LocalDate birthDate;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "movies_to_director", joinColumns = @JoinColumn(name = "director_id",
            referencedColumnName = "director_id", nullable = false), inverseJoinColumns = @JoinColumn(name = "movie_id",
            referencedColumnName = "movie_id", nullable = false))
    private Set<Movie> movies;

}
