package com.project.medicalapp.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.NonNull;

public record EmployeRegister(
         @NotBlank(message = "name cannot be blank")
         String name,
         @NotBlank(message = "surname cannot be blank")
         String surname,
         @NotBlank(message = "address cannot be blank")
         String address,
         @NonNull
         Long age,
         @NotBlank(message = "passport cannot be blank")
         String passportNumber,
         @NotBlank(message = "phone number cannot be blank")
         String phoneNumber,
         @NotBlank(message = "email cannot be blank")
         String email,
         String citizenship,
         Long salaryId,
         Long roleId
) {
}
