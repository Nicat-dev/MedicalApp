package com.project.medicalapp.service;

import com.project.medicalapp.dto.PrescriptionDto;
import com.project.medicalapp.dto.request.PrescriptionRequest;

import java.util.List;

public interface PrescriptionService {

    PrescriptionDto findById(Long id);
    PrescriptionDto save(PrescriptionRequest request);
    PrescriptionDto update(PrescriptionRequest request,Long id);
    List<PrescriptionDto> findAll();
    void delete(Long id);


}
