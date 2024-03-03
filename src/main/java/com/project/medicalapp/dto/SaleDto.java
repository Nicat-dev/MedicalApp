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
public class SaleDto {
    private Long id;
    private Integer percentage;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
