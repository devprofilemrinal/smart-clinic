package com.mringupta.smartclinic.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record PatientDTO(
        Long id,
        @NotBlank(message = "Name is required.")
        String name,
        @Email(message = "invalid email")
        @NotBlank(message = "email is required")
        String email,
        @Min(0)
        int age,
        @NotBlank(message = "gender is required")
        String gender
) {
}
