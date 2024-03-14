package com.project.medicalapp.service.impl;

import com.project.medicalapp.dto.SalaryDto;
import com.project.medicalapp.dto.request.SalaryRequest;
import com.project.medicalapp.exception.ResourceNotFoundException;
import com.project.medicalapp.mapper.SalaryMapper;
import com.project.medicalapp.model.Salary;
import com.project.medicalapp.repository.SalaryRepository;
import com.project.medicalapp.service.SalaryService;
import com.project.medicalapp.util.ServiceValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SalaryServiceImpl implements SalaryService {
    private final SalaryRepository repository;
    private final SalaryMapper mapper;

    @Override
    public Salary findSalary(Long id) {
        return repository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Salary","salary",id));
    }

    @Override
    public SalaryDto findById(Long id) {
        return mapper.entityToDto(repository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Salary","id",id)));
    }

    @Override
    public List<SalaryDto> findAll() {
        return mapper.entityToDtoList(repository.findAll());
    }

    @Override
    public SalaryDto save(SalaryRequest request) {
        ServiceValidator.ifExist(repository,request.id());
        return saveBy(request);
    }

    @Override
    public SalaryDto update(SalaryRequest request) {
        ServiceValidator.idNullCheck(request.id());
        return saveBy(request);
    }

    @Override
    public void delete(Long id) {
        ServiceValidator.idNullCheck(id);
        repository.deleteById(id);
    }

    private SalaryDto saveBy(SalaryRequest request){
        return mapper.entityToDto(repository.save(mapper.requestToEntity(request)));
    }
}
