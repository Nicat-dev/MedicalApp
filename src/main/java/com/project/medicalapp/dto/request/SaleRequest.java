package com.project.medicalapp.dto.request;

import jakarta.validation.constraints.NotNull;

public record SaleRequest(

        Long id,
        @NotNull(message = "position cannot be null")
        Integer percentage

) {
}
