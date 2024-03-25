package com.project.medicalapp.service;

import com.project.medicalapp.dto.DoctorDto;
import com.project.medicalapp.dto.request.EmployeRegister;
import com.project.medicalapp.model.Doctor;

import java.util.List;

public interface DoctorService {

    DoctorDto save(EmployeRegister register);
    DoctorDto update(EmployeRegister register,Long id);
    void delete(Long id);
    DoctorDto getById(Long id);
    List<DoctorDto> getList();
    Doctor findDoctor(Long id);
}
