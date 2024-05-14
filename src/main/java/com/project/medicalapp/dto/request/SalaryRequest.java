package com.project.medicalapp.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record SalaryRequest(

        @NotBlank(message = "position cannot be blank") String position,
        @NotNull Double salary

) {
}
