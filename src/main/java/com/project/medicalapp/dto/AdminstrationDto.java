package com.project.medicalapp.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdminstrationDto {
    private Long id;
    private String name;
    private String surname;
    private Integer age;
    private String passportNumber;
    private String phoneNumber;
    private String email;
    private String roleName;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
