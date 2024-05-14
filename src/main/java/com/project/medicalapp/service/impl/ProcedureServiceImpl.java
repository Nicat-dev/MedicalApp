package com.project.medicalapp.service.impl;

import com.project.medicalapp.dto.ProcedureDto;
import com.project.medicalapp.dto.request.ProcedureRequest;
import com.project.medicalapp.exception.ApplicationException;
import com.project.medicalapp.mapper.ProcedureMapper;
import com.project.medicalapp.model.entity.Procedure;
import com.project.medicalapp.model.enums.Exceptions;
import com.project.medicalapp.repository.ProcedureRepository;
import com.project.medicalapp.service.CustomerService;
import com.project.medicalapp.service.DoctorService;
import com.project.medicalapp.service.ProcedureService;
import com.project.medicalapp.service.SaleService;
import com.project.medicalapp.util.ServiceValidator;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProcedureServiceImpl implements ProcedureService {

    private final ProcedureRepository repository;
    private final ProcedureMapper mapper;
    private final CustomerService customerService;
    private final DoctorService doctorService;
    private final SaleService saleService;


    @Override
    public ProcedureDto find(Long id) {
        return mapper.procedureToProcedureDto(findProcedure(id));
    }

    @Override
    public List<ProcedureDto> findAll() {
        return mapper.entityListToDtoList(repository.findAll());
    }

    @Override
    public ProcedureDto save(ProcedureRequest request) {
        return saveBy(request);
    }

    @Override
    @Transactional
    public ProcedureDto update(ProcedureRequest request, Long id) {
        return repository.findById(id).map(procedure -> {
            Procedure updateProcedure = mapper.requestToEntity(request);
            updateProcedure.setCustomer(customerService.findCustomer(request.customerId()));
            updateProcedure.setDoctor(doctorService.findDoctor(request.doctorId()));
            updateProcedure.setSale(saleService.findSale(request.saleId()));
            return mapper.procedureToProcedureDto(repository.save(updateProcedure));
        }).orElseThrow(() -> new ApplicationException(Exceptions.PROCEDURE_NOT_FOUND));
    }

    @Override
    public void delete(Long id) {
        repository.delete(findProcedure(id));
    }

    private ProcedureDto saveBy(ProcedureRequest request) {
        Procedure procedure = mapper.requestToEntity(request);
        procedure.setCustomer(customerService.findCustomer(request.customerId()));
        procedure.setDoctor(doctorService.findDoctor(request.doctorId()));
        procedure.setSale(saleService.findSale(request.saleId()));

        return mapper.procedureToProcedureDto(repository.save(procedure));
    }

    private Procedure findProcedure(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ApplicationException(Exceptions.PROCEDURE_NOT_FOUND));
    }


}
