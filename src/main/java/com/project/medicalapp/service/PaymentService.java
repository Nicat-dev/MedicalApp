package com.project.medicalapp.service;

import com.project.medicalapp.dto.PaymentDto;
import com.project.medicalapp.dto.request.PaymentRequest;

import java.util.List;

public interface PaymentService {

    PaymentDto findById(Long id);
    List<PaymentDto> findAll();
    PaymentDto update(PaymentRequest request,Long id);
    PaymentDto save(PaymentRequest request);
    void delete(Long id);

}
