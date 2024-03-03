package com.project.medicalapp.dto.request;

import jakarta.validation.constraints.NotBlank;

public record ProcedureRequest(
        Long id,
        @NotBlank(message = "procedure name cannot be null") String procedureName,
        @NotBlank(message = "doctor id name cannot be null") Long doctorId,
        @NotBlank(message = "customer id name cannot be null") Long customerId
) {
}
