package com.project.medicalapp.dto.request;

import jakarta.validation.constraints.NotBlank;

public record MedicineRequest(
        @NotBlank(message = "name cannot be blank") String name,
        @NotBlank(message = "country cannot be blank") String country,
        @NotBlank(message = "prescription need cannot be blank") Boolean needPrescription
) {
}
