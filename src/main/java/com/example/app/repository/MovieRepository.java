package com.example.app.repository;

import com.example.app.model.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    long count();
    @Query(value = "SELECT m FROM Movie m WHERE month(m.sceneDate) =:month")
    List<Movie> findMoviesByMonth(int month);

    @Query(value = "SELECT y FROM Movie y WHERE year(y.sceneDate) =:year")
    List<Movie> findMoviesByYear(int year);

    @Query("SELECT m FROM Movie m WHERE YEAR(m.sceneDate) = :year AND MONTH(m.sceneDate) = :month")
    List<Movie> findMoviesByMonthAndYear(int month, int year);

    @Query("SELECT y FROM Movie y WHERE YEAR(y.sceneDate) BETWEEN :begin AND :end")
    List<Movie> findMoviesByYearBetween(int begin, int end);

    @Query("SELECT d FROM Movie d WHERE DATE(d.sceneDate) BETWEEN :begin AND :end")
    List<Movie> findMoviesByDateBetween(LocalDate begin, LocalDate end);
    boolean existsByMovieName(String name);
}
