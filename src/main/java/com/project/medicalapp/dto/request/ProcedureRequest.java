package com.project.medicalapp.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProcedureRequest(
        Long id,
        @NotNull(message = "procedure price cannot be Null") Float price,
        @NotBlank(message = "procedure name cannot be null") String procedureName,
        @NotBlank(message = "doctor id name cannot be null") Long doctorId,
        @NotBlank(message = "customer id name cannot be null") Long customerId,
        @NotNull(message = "sale Id cannot be null") Long saleId
) {
}
