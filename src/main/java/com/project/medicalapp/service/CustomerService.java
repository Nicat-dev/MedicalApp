package com.project.medicalapp.service;

import com.project.medicalapp.dto.CustomerDto;
import com.project.medicalapp.dto.request.RegisterRequest;

import java.util.List;

public interface CustomerService {

    CustomerDto save(RegisterRequest registerRequest);
    CustomerDto update(RegisterRequest registerRequest);
    CustomerDto findById(Long id);
    List<CustomerDto> findAll();
    void deleteById(Long id);


}
