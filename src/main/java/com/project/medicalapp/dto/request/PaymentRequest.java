package com.project.medicalapp.dto.request;

import jakarta.validation.constraints.NotBlank;

public record PaymentRequest(
        @NotBlank(message = "payment name cannot be blank") String paymentType,
        @NotBlank(message = "customer id cannot be blank") Long customerId
) {
}
