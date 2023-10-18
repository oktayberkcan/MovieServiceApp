package com.example.app.service;

import com.example.app.dto.requests.CreateMovieRequest;
import com.example.app.dto.responses.GetAllMoviesResponse;
import com.example.app.mapper.ModelMapperService;
import com.example.app.model.entities.Movie;
import com.example.app.repository.MovieRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;


public class MovieServiceImplTest {

    private MovieServiceImpl movieServiceImpl;
    private MovieRepository movieRepository;
    private ModelMapperService modelMapperService;

    @Before
    public void setUp() throws Exception {

        movieRepository = Mockito.mock(MovieRepository.class);
        modelMapperService = Mockito.mock(ModelMapperService.class);

        movieServiceImpl = new MovieServiceImpl(movieRepository, modelMapperService);
    }

    @Test
    public void whenCreateMovieCalledWithValidRequest_itShouldReturnValidCreateMovieRequest(){
        CreateMovieRequest createMovieRequest = new CreateMovieRequest();

        createMovieRequest.setMovieName("The Dark Knight");

        Movie movie = Movie.builder()
                .movieId(12345L)
                .movieName("The Dark Knight")
                .build();


        Mockito.when(movieServiceImpl.getAll()).thenReturn((List<GetAllMoviesResponse>) movie);

    }
}