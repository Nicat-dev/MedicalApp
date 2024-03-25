package com.project.medicalapp.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RegisterRequest(
        @NotBlank(message = "name cannot be blank") String name,
        @NotBlank(message = "surname cannot be blank") String surname,
        @NotBlank(message = "email cannot be blank") String email,
        @NotBlank(message = "phone number cannot be blank") String phoneNumber,
        @NotBlank(message = "passport number cannot be blank") String passportNumber,
        @NotNull(message = "age cannot be blank") Integer age,
        @NotBlank(message = "address cannot be blank") String address,
        @NotBlank(message = "citizenship cannot be blank") String citizenship,
        @NotNull(message = "role id cannot be blank") Long roleId
) {
}
