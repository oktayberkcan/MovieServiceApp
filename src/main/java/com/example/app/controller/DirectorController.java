package com.example.app.controller;

import com.example.app.dto.requests.CreateDirectorRequest;
import com.example.app.dto.requests.UpdateDirectorRequest;
import com.example.app.dto.responses.GetAllDirectorsResponse;
import com.example.app.dto.responses.GetByIdDirectorResponse;
import com.example.app.service.DirectorService;
import com.example.app.service.DirectorServiceImpl;
import jakarta.validation.Valid;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/directors")
@RequiredArgsConstructor
public class DirectorController {
    private final DirectorService directorService;
    @GetMapping("getAll")
    @ResponseStatus(HttpStatus.OK)
    public List<GetAllDirectorsResponse> getAllDirectorsResponses() {

        return directorService.getAllDirectors();
    }
    @GetMapping("count")
    public long count() {
        return directorService.count();
    }
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void createDirector(@RequestBody @Valid() CreateDirectorRequest createDirectorRequest) {

       this.directorService.createDirector(createDirectorRequest);
    }
    @PutMapping
    public void update(@RequestBody UpdateDirectorRequest updateDirectorRequest) {
        this.directorService.update(updateDirectorRequest);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.directorService.delete(id);
    }
    @GetMapping("/{id}")
    public GetByIdDirectorResponse getById(@PathVariable Long id) {
       return directorService.getById(id);
    }
}
