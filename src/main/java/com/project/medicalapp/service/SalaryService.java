package com.project.medicalapp.service;

import com.project.medicalapp.dto.SalaryDto;
import com.project.medicalapp.dto.request.SalaryRequest;
import com.project.medicalapp.model.entity.Salary;

import java.util.List;

public interface SalaryService {

    Salary findSalary(Long id);

    SalaryDto findById(Long id);
    List<SalaryDto> findAll();
    SalaryDto save(SalaryRequest request);
    SalaryDto update(SalaryRequest request,Long id);
    void delete(Long id);
}
