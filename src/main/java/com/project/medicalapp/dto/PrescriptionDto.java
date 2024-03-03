package com.project.medicalapp.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PrescriptionDto {
    private Long id;
    private String head;
    private String illness;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String doctorName;
    private String doctorSurname;
    private String customerName;
    private String customerSurname;
}
