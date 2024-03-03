package com.project.medicalapp.dto.request;

import jakarta.validation.constraints.NotBlank;

public record PrescriptionRequest(
        Long id,
        @NotBlank(message = "head cannot be null") String head,
        @NotBlank(message = "illness cannot be null") String illness,
        @NotBlank(message = "description cannot be null") String description,
        @NotBlank(message = "doctor id cannot be null") Long doctorId,
        @NotBlank(message = "customer id cannot be null") Long customerId
) {
}
