package com.example.app.dto.requests;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateDirectorRequest {
    private String directorFirstName;

    private String directorMiddleName;

    private String familyName;

    private LocalDate birthDate;
}
