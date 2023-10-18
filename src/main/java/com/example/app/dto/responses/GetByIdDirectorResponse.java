package com.example.app.dto.responses;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdDirectorResponse {
    private Long directorId;
    private String directorFirstName;
    private String directorMiddleName;
    private String familyName;
    private LocalDate birthDate;
}
