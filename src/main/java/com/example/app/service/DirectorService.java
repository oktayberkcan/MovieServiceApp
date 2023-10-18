package com.example.app.service;

import com.example.app.dto.requests.CreateDirectorRequest;
import com.example.app.dto.requests.UpdateDirectorRequest;
import com.example.app.dto.requests.UpdateMovieRequest;
import com.example.app.dto.responses.GetAllDirectorsResponse;
import com.example.app.dto.responses.GetByIdDirectorResponse;


import java.util.List;


public interface DirectorService {
    List<GetAllDirectorsResponse> getAllDirectors();
    void createDirector(CreateDirectorRequest createDirectorRequest);
    void update(UpdateDirectorRequest updateDirectorRequest);
    void delete(Long id);
    long count();
    GetByIdDirectorResponse getById (Long id);

}
