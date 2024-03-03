package com.project.medicalapp.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDto {
    private Long id;
    private String paymentType;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private CustomerDto customerDto;
}
