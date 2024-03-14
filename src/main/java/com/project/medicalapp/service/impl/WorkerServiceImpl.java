package com.project.medicalapp.service.impl;

import com.project.medicalapp.dto.WorkerDto;
import com.project.medicalapp.dto.request.EmployeRegister;
import com.project.medicalapp.exception.ResourceNotFoundException;
import com.project.medicalapp.mapper.WorkerMapper;
import com.project.medicalapp.model.Worker;
import com.project.medicalapp.repository.WorkerRepository;
import com.project.medicalapp.service.RoleService;
import com.project.medicalapp.service.SalaryService;
import com.project.medicalapp.service.WorkerService;
import com.project.medicalapp.util.ServiceValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WorkerServiceImpl implements WorkerService {

    private final WorkerRepository repository;
    private final WorkerMapper mapper;
    private final RoleService roleService;
    private final SalaryService salaryService;

    @Override
    public WorkerDto findById(Long id) {
        return mapper.entityToDto(repository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Worker","id",id)));
    }

    @Override
    public WorkerDto save(EmployeRegister register) {
        ServiceValidator.idEqualsNull(register.id());
        return saveBy(register);
    }

    @Override
    public WorkerDto update(EmployeRegister register) {
        ServiceValidator.idNullCheck(register.id());
        return saveBy(register);
    }

    @Override
    public List<WorkerDto> findList() {
        return mapper.entityListToDtoList(repository.findAll());
    }

    @Override
    public void delete(Long id) {
        ServiceValidator.idNullCheck(id);
        repository.deleteById(id);
    }

    private WorkerDto saveBy(EmployeRegister register){
        Worker worker = mapper.requestToEntity(register);
        worker.setRole(roleService.findRole(register.roleId()));
        worker.setSalary(salaryService.findSalary(register.salaryId()));
        return mapper.entityToDto(repository.save(worker));
    }
}
