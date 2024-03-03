package com.project.medicalapp.dto.request;

import jakarta.validation.constraints.NotBlank;

public record RoleRequest(
        Long id,
        @NotBlank(message = "role name cannot be blank") String roleName

) {
}
