package com.project.medicalapp.service.impl;

import com.project.medicalapp.dto.WorkerDto;
import com.project.medicalapp.dto.request.EmployeRegister;
import com.project.medicalapp.exception.ApplicationException;
import com.project.medicalapp.mapper.WorkerMapper;
import com.project.medicalapp.model.entity.Worker;
import com.project.medicalapp.model.enums.Exceptions;
import com.project.medicalapp.repository.WorkerRepository;
import com.project.medicalapp.service.RoleService;
import com.project.medicalapp.service.SalaryService;
import com.project.medicalapp.service.WorkerService;
import jakarta.transaction.Transactional;
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
                .orElseThrow(() -> new ApplicationException(Exceptions.WORKER_NOT_FOUND)));
    }

    @Override
    public WorkerDto save(EmployeRegister register) {
        return saveBy(register);
    }

    @Override
    @Transactional
    public WorkerDto update(EmployeRegister register, Long id) {
        return repository.findById(id)
                .map(worker -> {
                    Worker updateWorker = mapper.requestToEntity(register);
                    updateWorker.setId(id);
                    updateWorker.setRole(roleService.findRole(register.roleId()));
                    updateWorker.setSalary(salaryService.findSalary(register.salaryId()));
                    return mapper.entityToDto(repository.save(updateWorker));
                }).orElseThrow(() -> new ApplicationException(Exceptions.WORKER_NOT_FOUND));
    }

    @Override
    public List<WorkerDto> findList() {
        return mapper.entityListToDtoList(repository.findAll());
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private WorkerDto saveBy(EmployeRegister register) {
        Worker worker = mapper.requestToEntity(register);
        worker.setRole(roleService.findRole(register.roleId()));
        worker.setSalary(salaryService.findSalary(register.salaryId()));
        return mapper.entityToDto(repository.save(worker));
    }
}
