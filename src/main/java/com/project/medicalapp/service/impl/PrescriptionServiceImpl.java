package com.project.medicalapp.service.impl;

import com.project.medicalapp.dto.PrescriptionDto;
import com.project.medicalapp.dto.request.PrescriptionRequest;
import com.project.medicalapp.exception.ApplicationException;
import com.project.medicalapp.mapper.PrescriptionMapper;
import com.project.medicalapp.model.entity.Prescription;
import com.project.medicalapp.model.enums.Exceptions;
import com.project.medicalapp.repository.PrescriptionRepository;
import com.project.medicalapp.service.CustomerService;
import com.project.medicalapp.service.DoctorService;
import com.project.medicalapp.service.PrescriptionService;
import com.project.medicalapp.util.ServiceValidator;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PrescriptionServiceImpl implements PrescriptionService {

    private final PrescriptionRepository repository;
    private final PrescriptionMapper mapper;
    private final CustomerService customerService;
    private final DoctorService doctorService;


    @Override
    public PrescriptionDto findById(Long id) {
        return mapper.prescriptionToPrescriptionDto(findPrescription(id));
    }

    @Override
    public PrescriptionDto save(PrescriptionRequest request) {
        return saveBy(request);
    }

    @Override
    @Transactional
    public PrescriptionDto update(PrescriptionRequest request, Long id) {
        return repository.findById(id).map(prescription -> {
            Prescription updatePrescription = mapper.requestToEntity(request);
            updatePrescription.setCustomer(customerService.findCustomer(request.customerId()));
            updatePrescription.setDoctor(doctorService.findDoctor(request.doctorId()));
            return mapper.prescriptionToPrescriptionDto(repository.save(updatePrescription));
        }).orElseThrow(() -> new ApplicationException(Exceptions.PRESCRIPTION_NOT_FOUND));
    }

    @Override
    public List<PrescriptionDto> findAll() {
        return mapper.entityListToDtoList(repository.findAll());
    }

    @Override
    public void delete(Long id) {
        repository.delete(findPrescription(id));
    }


    private PrescriptionDto saveBy(PrescriptionRequest request) {
        Prescription prescription = mapper.requestToEntity(request);
        prescription.setCustomer(customerService.findCustomer(request.customerId()));
        prescription.setDoctor(doctorService.findDoctor(request.doctorId()));
        return mapper.prescriptionToPrescriptionDto(repository.save(prescription));
    }

    private Prescription findPrescription(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ApplicationException(Exceptions.PRESCRIPTION_NOT_FOUND));
    }

}
