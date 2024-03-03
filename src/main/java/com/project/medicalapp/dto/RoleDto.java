package com.project.medicalapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoleDto {
    private Long id;
    private String roleName;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
