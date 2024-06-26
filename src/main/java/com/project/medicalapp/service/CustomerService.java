package com.project.medicalapp.service;

import com.project.medicalapp.dto.CustomerDto;
import com.project.medicalapp.dto.request.RegisterRequest;
import com.project.medicalapp.model.entity.Customer;

import java.util.List;

public interface CustomerService {

    CustomerDto save(RegisterRequest registerRequest);
    CustomerDto update(RegisterRequest registerRequest,Long id);
    CustomerDto findById(Long id);
    List<CustomerDto> findAll();
    void deleteById(Long id);
    Customer findCustomer(Long id);

}
