package com.project.medicalapp.service.impl;

import com.project.medicalapp.dto.DoctorDto;
import com.project.medicalapp.dto.request.EmployeRegister;
import com.project.medicalapp.exception.ResourceNotFoundException;
import com.project.medicalapp.mapper.DoctorMapper;
import com.project.medicalapp.model.Doctor;
import com.project.medicalapp.repository.DoctorRepository;
import com.project.medicalapp.service.DoctorService;
import com.project.medicalapp.service.RoleService;
import com.project.medicalapp.service.SalaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.project.medicalapp.util.ServiceValidator.idNullCheck;

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
    public DoctorDto update(EmployeRegister register,Long id) {
        findDoctor(id);
        return saveDoctor(register);
    }

    @Override
    public void delete(Long id) {
        idNullCheck(id);
        repository.deleteById(id);
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
                .orElseThrow(()-> new ResourceNotFoundException("Doctor","id",id));
    }

    private DoctorDto saveDoctor(EmployeRegister register){
        Doctor doctor = mapper.registerToDoctor(register);
        doctor.setRole(roleService.findRole(register.roleId()));
        doctor.setSalary(salaryService.findSalary(register.salaryId()));
        return mapper.doctorToDoctorDto(repository.save(mapper.registerToDoctor(register)));
    }
}
