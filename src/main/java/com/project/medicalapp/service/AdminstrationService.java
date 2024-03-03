package com.project.medicalapp.service;

import com.project.medicalapp.dto.AdminstrationDto;
import com.project.medicalapp.dto.request.EmployeRegister;

import java.util.List;

public interface AdminstrationService {

    List<AdminstrationDto> getList();
    AdminstrationDto getById(Long id);
    AdminstrationDto updateById(EmployeRegister register);
    void deleteById(Long id);

}
