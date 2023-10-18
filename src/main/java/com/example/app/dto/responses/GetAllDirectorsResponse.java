package com.example.app.dto.responses;

import com.example.app.model.entities.Director;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllDirectorsResponse {
    private Director director;
}
