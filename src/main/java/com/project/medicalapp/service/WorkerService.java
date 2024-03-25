package com.project.medicalapp.service;

import com.project.medicalapp.dto.WorkerDto;
import com.project.medicalapp.dto.request.EmployeRegister;

import java.util.List;

public interface WorkerService {

    WorkerDto findById(Long id);
    WorkerDto save(EmployeRegister register);
    WorkerDto update(EmployeRegister register,Long id);
    List<WorkerDto> findList();
    void delete(Long id);
}
