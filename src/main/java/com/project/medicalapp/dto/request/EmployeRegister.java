package com.project.medicalapp.dto.request;

import jakarta.validation.constraints.NotBlank;

public record EmployeRegister(
         Long id,
         @NotBlank(message = "name cannot be blank") String name,
         @NotBlank(message = "surname cannot be blank") String surname,
         @NotBlank(message = "address cannot be blank") String address,
         @NotBlank(message = "age cannot be blank") Integer age,
         @NotBlank(message = "passport cannot be blank") String passportNumber,
         @NotBlank(message = "phone number cannot be blank") String phoneNumber,
         @NotBlank(message = "email cannot be blank") String email,
         String citizenship,
         Long roleId
) {
}
