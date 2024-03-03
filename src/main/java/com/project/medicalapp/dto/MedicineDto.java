package com.project.medicalapp.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MedicineDto {
    private Long id;
    private String name;
    private String country;
    private Boolean needPrescription;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private List<PrescriptionDto> prescriptionDtos;
    private List<ProcedureDto> procedureDtos;
}
