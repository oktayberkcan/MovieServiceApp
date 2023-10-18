package com.example.app.repository;

import com.example.app.dto.MovieWithDirectorDTO;
import com.example.app.model.entities.Director;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface MovieDirectorRepository extends JpaRepository<Director, Long> {

    @Query("select new com.example.app.dto.MovieWithDirectorDTO"
            + "(m.movieId, m.movieName, m.sceneDate, d.directorFirstName, d.directorMiddleName, d.familyName, d.birthDate, m.rating, m.cost, m.imdb, d.directorId) "
            +"from Director d inner join d.movies m where DATE(m.sceneDate) between :begin and :end")
    List<MovieWithDirectorDTO> findMoviesAndDirectorsByDateBetween(@Param("begin") LocalDate begin, @Param("end") LocalDate end);

    @Query("select new com.example.app.dto.MovieWithDirectorDTO"
            + "(m.movieId, m.movieName, m.sceneDate, d.directorFirstName, d.directorMiddleName, d.familyName, d.birthDate, m.rating, m.cost, m.imdb, d.directorId) "
            +"from Director d inner join d.movies m")
    List<MovieWithDirectorDTO> getAllMoviesWithDirectors();
    @Query("select new com.example.app.dto.MovieWithDirectorDTO"
            + "(m.movieId, m.movieName, m.sceneDate, d.directorFirstName, d.directorMiddleName, d.familyName, d.birthDate, m.rating, m.cost, m.imdb, d.directorId) "
            +"from Director d inner join d.movies m where YEAR(m.sceneDate) between :begin and :end")
    List<MovieWithDirectorDTO> findMoviesAndDirectorsByYearBetween(@Param("begin") int begin, @Param("end") int end);
}
