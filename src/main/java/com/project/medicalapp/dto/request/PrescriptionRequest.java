package com.project.medicalapp.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PrescriptionRequest(
        @NotBlank(message = "head cannot be null") String head,
        @NotBlank(message = "illness cannot be null") String illness,
        @NotBlank(message = "description cannot be null") String description,
        @NotNull(message = "doctor id cannot be null") Long doctorId,
        @NotNull(message = "customer id cannot be null") Long customerId
) {
}
