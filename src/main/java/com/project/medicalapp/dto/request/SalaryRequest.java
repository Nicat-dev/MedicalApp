package com.project.medicalapp.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record SalaryRequest(

        Long id,
        @NotBlank(message = "position cannot be blank") String position,
        @NotNull Float salary

) {
}
