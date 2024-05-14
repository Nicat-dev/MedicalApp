package com.project.medicalapp.service.impl;

import com.project.medicalapp.dto.AdminstrationDto;
import com.project.medicalapp.dto.request.EmployeRegister;
import com.project.medicalapp.exception.ApplicationException;
import com.project.medicalapp.mapper.AdminstrationMapper;
import com.project.medicalapp.model.entity.Adminstration;
import com.project.medicalapp.model.enums.Exceptions;
import com.project.medicalapp.repository.AdminstrationRepository;
import com.project.medicalapp.service.AdministrationService;
import com.project.medicalapp.service.SalaryService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class AdministrationServiceImpl implements AdministrationService {

    private final AdminstrationMapper mapper;
    private final AdminstrationRepository repository;
    private final SalaryService salaryService;

    @Override
    public AdminstrationDto save(EmployeRegister register) {
        return saveInfo(register);
    }

    @Override
    public List<AdminstrationDto> getList() {
        return mapper.entityListToDtoList(repository.findAll());
    }

    @Override
    public AdminstrationDto getById(Long id) {
        return mapper.entityToDto(findAdministration(id));
    }

    @Override
    @Transactional
    public AdminstrationDto updateById(EmployeRegister register, Long id) {
        return repository.findById(id)
                .map(administration -> {
                    Adminstration updateAdministration = mapper.requestToEntity(register);
                    updateAdministration.setId(id);
                    updateAdministration.setSalary(salaryService.findSalary(register.salaryId()));
                    return mapper.entityToDto(repository.save(administration));
                }).orElseThrow(() -> new ApplicationException(Exceptions.USER_NOT_FOUND_EXCEPTION));
    }

    @Override
    public void deleteById(Long id) {
        repository.delete(findAdministration(id));
    }


    private AdminstrationDto saveInfo(EmployeRegister register) {
        Adminstration adminstration = mapper.requestToEntity(register);
        adminstration.setSalary(salaryService.findSalary(register.salaryId()));
        return mapper.entityToDto(repository.save(adminstration));
    }

    private Adminstration findAdministration(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ApplicationException(Exceptions.USER_NOT_FOUND_EXCEPTION));
    }

}
