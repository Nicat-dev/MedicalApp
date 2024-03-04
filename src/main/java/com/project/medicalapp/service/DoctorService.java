package com.project.medicalapp.service;

import com.project.medicalapp.dto.DoctorDto;
import com.project.medicalapp.dto.request.EmployeRegister;

import java.util.List;

public interface DoctorService {

    DoctorDto save(EmployeRegister register);
    DoctorDto update(EmployeRegister register);
    void deleteById(Long id);
    List<DoctorDto> getAll();
    DoctorDto findById(Long id);

}
