package com.project.medicalapp.service.impl;

import com.project.medicalapp.dto.SalaryDto;
import com.project.medicalapp.dto.request.SalaryRequest;
import com.project.medicalapp.exception.ApplicationException;
import com.project.medicalapp.mapper.SalaryMapper;
import com.project.medicalapp.model.entity.Salary;
import com.project.medicalapp.model.enums.Exceptions;
import com.project.medicalapp.repository.SalaryRepository;
import com.project.medicalapp.service.SalaryService;
import com.project.medicalapp.util.ServiceValidator;
import jakarta.transaction.Transactional;
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
                .orElseThrow(() -> new ApplicationException(Exceptions.SALARY_NOT_FOUND));
    }

    @Override
    public SalaryDto findById(Long id) {
        return mapper.entityToDto(repository.findById(id)
                .orElseThrow(() -> new ApplicationException(Exceptions.SALARY_NOT_FOUND)));
    }

    @Override
    public List<SalaryDto> findAll() {
        return mapper.entityToDtoList(repository.findAll());
    }

    @Override
    public SalaryDto save(SalaryRequest request) {
        return saveBy(request);
    }

    @Override
    @Transactional
    public SalaryDto update(SalaryRequest request, Long id) {
        return repository.findById(id)
                .map(salary -> {
                    Salary updateSalary = mapper.requestToEntity(request);
                    return mapper.entityToDto(updateSalary);
                }).orElseThrow(() -> new ApplicationException(Exceptions.SALARY_NOT_FOUND));
    }

    @Override
    public void delete(Long id) {
        repository.delete(findSalary(id));
    }

    private SalaryDto saveBy(SalaryRequest request) {
        return mapper.entityToDto(repository.save(mapper.requestToEntity(request)));
    }
}
