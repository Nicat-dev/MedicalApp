package com.project.medicalapp.service.impl;

import com.project.medicalapp.dto.ProcedureDto;
import com.project.medicalapp.dto.request.ProcedureRequest;
import com.project.medicalapp.exception.ResourceNotFoundException;
import com.project.medicalapp.mapper.ProcedureMapper;
import com.project.medicalapp.model.Procedure;
import com.project.medicalapp.repository.ProcedureRepository;
import com.project.medicalapp.service.CustomerService;
import com.project.medicalapp.service.DoctorService;
import com.project.medicalapp.service.ProcedureService;
import com.project.medicalapp.service.SaleService;
import com.project.medicalapp.util.ServiceValidator;
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
    public ProcedureDto update(ProcedureRequest request,Long id) {
        findProcedure(id);
        return saveBy(request);
    }

    @Override
    public void delete(Long id) {
        ServiceValidator.idNullCheck(id);
        repository.deleteById(id);
    }

    private ProcedureDto saveBy(ProcedureRequest request){
        Procedure procedure = mapper.requestToEntity(request);
        procedure.setCustomer(customerService.findCustomer(request.customerId()));
        procedure.setDoctor(doctorService.findDoctor(request.doctorId()));
        procedure.setSale(saleService.findSale(request.saleId()));

        return mapper.procedureToProcedureDto(repository.save(procedure));
    }

    private Procedure findProcedure(Long id){
        return repository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Procedure","id",id));
    }


}
