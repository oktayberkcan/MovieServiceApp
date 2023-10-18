package com.example.app.service;

import com.example.app.dto.requests.CreateDirectorRequest;
import com.example.app.dto.requests.UpdateDirectorRequest;
import com.example.app.dto.responses.GetAllDirectorsResponse;
import com.example.app.dto.responses.GetByIdDirectorResponse;
import com.example.app.mapper.ModelMapperManager;
import com.example.app.mapper.ModelMapperService;
import com.example.app.model.entities.Director;
import com.example.app.repository.DirectorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DirectorServiceImpl implements DirectorService{
    private final DirectorRepository directorRepository;
    private final ModelMapperService modelMapperService;

    @Override
    public List<GetAllDirectorsResponse> getAllDirectors() {

        List<Director> directors = directorRepository.findAll();

        return directors.stream()
                .map(director -> this.modelMapperService.forResponse()
                        .map(director, GetAllDirectorsResponse.class)).collect(Collectors.toList());

    }

    @Override
    public void createDirector(CreateDirectorRequest createDirectorRequest) {

        Director director = this.modelMapperService.forRequest().map(createDirectorRequest, Director.class);

        this.directorRepository.save(director);
    }

    @Override
    public void update(UpdateDirectorRequest updateDirectorRequest) {

        Director director = this.modelMapperService.forRequest().map(updateDirectorRequest, Director.class);

        this.directorRepository.save(director);

    }

    @Override
    public void delete(Long id) {
        this.directorRepository.deleteById(id);
    }

    @Override
    public long count() {
        return this.directorRepository.count();
    }

    @Override
    public GetByIdDirectorResponse getById(Long id) {

        Director director = this.directorRepository.findById(id).orElseThrow();

        return this.modelMapperService.forResponse()
                .map(director, GetByIdDirectorResponse.class);

    }
}
