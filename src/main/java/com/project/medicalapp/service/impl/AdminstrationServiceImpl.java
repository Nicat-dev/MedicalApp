package com.project.medicalapp.service.impl;

import com.project.medicalapp.dto.AdminstrationDto;
import com.project.medicalapp.dto.request.EmployeRegister;
import com.project.medicalapp.exception.ResourceNotFoundException;
import com.project.medicalapp.mapper.AdminstrationMapper;
import com.project.medicalapp.model.Adminstration;
import com.project.medicalapp.repository.AdminstrationRepository;
import com.project.medicalapp.service.AdminstrationService;
import com.project.medicalapp.service.RoleService;
import com.project.medicalapp.service.SalaryService;
import com.project.medicalapp.util.ServiceValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.project.medicalapp.util.ServiceValidator.idNullCheck;

@Service
@RequiredArgsConstructor
public class AdminstrationServiceImpl implements AdminstrationService {

    private final AdminstrationMapper mapper;
    private final AdminstrationRepository repository;
    private final RoleService roleService;
    private final SalaryService salaryService;

    @Override
    public AdminstrationDto save(EmployeRegister register) {
        ServiceValidator.idEqualsNull(register.id());
        ServiceValidator.ifExist(repository,register.id());
       return saveInfo(register);
    }

    @Override
    public List<AdminstrationDto> getList() {
        return mapper.entityListToDtoList(repository.findAll());
    }

    @Override
    public AdminstrationDto getById(Long id) {
        idNullCheck(id);
        return mapper.entityToDto( repository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Adminstration",id.toString(),id)));
    }

    @Override
    public AdminstrationDto updateById(EmployeRegister register) {
        idNullCheck(register.id());
        return saveInfo(register);
    }

    @Override
    public void deleteById(Long id) {
        idNullCheck(id);
        repository.deleteById(id);
    }


    private AdminstrationDto saveInfo(EmployeRegister register){
        Adminstration adminstration = mapper.requestToEntity(register);
        adminstration.setRole(roleService.findRole(register.roleId()));
        adminstration.setSalary(salaryService.findSalary(register.salaryId()));
        return mapper.entityToDto(repository.save(adminstration));
    }

}
