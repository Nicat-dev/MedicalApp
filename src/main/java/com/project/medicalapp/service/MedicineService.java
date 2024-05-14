package com.project.medicalapp.service;


import com.project.medicalapp.dto.MedicineDto;
import com.project.medicalapp.dto.request.EmployeRegister;
import com.project.medicalapp.dto.request.MedicineRequest;

import java.util.List;

public interface MedicineService {

    MedicineDto findById(Long id);
    List<MedicineDto> findAll();
    MedicineDto update(MedicineRequest register,Long id);
    MedicineDto save(MedicineRequest register);
    void delete(Long id);
}
