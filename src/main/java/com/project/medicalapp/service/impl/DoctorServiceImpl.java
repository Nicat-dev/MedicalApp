package com.project.medicalapp.service.impl;

import com.project.medicalapp.dto.DoctorDto;
import com.project.medicalapp.dto.request.EmployeRegister;
import com.project.medicalapp.exception.ApplicationException;
import com.project.medicalapp.mapper.DoctorMapper;
import com.project.medicalapp.model.entity.Doctor;
import com.project.medicalapp.model.enums.Exceptions;
import com.project.medicalapp.repository.DoctorRepository;
import com.project.medicalapp.service.DoctorService;
import com.project.medicalapp.service.RoleService;
import com.project.medicalapp.service.SalaryService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository repository;
    private final SalaryService salaryService;
    private final RoleService roleService;
    private final DoctorMapper mapper;

    @Override
    public DoctorDto save(EmployeRegister register) {
        return saveDoctor(register);
    }

    @Override
    @Transactional
    public DoctorDto update(EmployeRegister register, Long id) {
        return repository.findById(id)
                .map(doctor -> {
                    Doctor updateDoctor = mapper.registerToDoctor(register);
                    updateDoctor.setId(id);
                    updateDoctor.setRole(roleService.findRole(register.roleId()));
                    updateDoctor.setSalary(salaryService.findSalary(register.salaryId()));
                    return mapper.doctorToDoctorDto(repository.save(updateDoctor));
                }).orElseThrow(() -> new ApplicationException(Exceptions.USER_NOT_FOUND_EXCEPTION));
    }

    @Override
    public void delete(Long id) {
        repository.delete(findDoctor(id));
    }

    @Override
    public DoctorDto getById(Long id) {
        return mapper.doctorToDoctorDto(findDoctor(id));
    }

    @Override
    public List<DoctorDto> getList() {
        return mapper.entityListToDtoList(repository.findAll());
    }

    @Override
    public Doctor findDoctor(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ApplicationException(Exceptions.USER_NOT_FOUND_EXCEPTION));
    }

    private DoctorDto saveDoctor(EmployeRegister register) {
        Doctor doctor = mapper.registerToDoctor(register);
        doctor.setRole(roleService.findRole(register.roleId()));
        doctor.setSalary(salaryService.findSalary(register.salaryId()));
        return mapper.doctorToDoctorDto(repository.save(doctor));
    }
}
