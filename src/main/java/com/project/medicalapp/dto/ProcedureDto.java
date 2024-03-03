package com.project.medicalapp.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProcedureDto {
    private Long id;
    private String procedureName;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private DoctorDto doctorDto;
    private CustomerDto customerDto;
}
