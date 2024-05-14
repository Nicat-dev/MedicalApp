package com.project.medicalapp.service.impl;

import com.project.medicalapp.dto.CustomerDto;
import com.project.medicalapp.dto.request.RegisterRequest;
import com.project.medicalapp.exception.ApplicationException;
import com.project.medicalapp.mapper.CustomerMapper;
import com.project.medicalapp.model.entity.Customer;
import com.project.medicalapp.model.enums.Exceptions;
import com.project.medicalapp.repository.CustomerRepository;
import com.project.medicalapp.service.CustomerService;
import com.project.medicalapp.service.RoleService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository repository;
    private final CustomerMapper mapper;
    private final RoleService roleService;

    @Override
    public CustomerDto save(RegisterRequest registerRequest) {
        if (repository.existsByEmail(registerRequest.email())) {
            throw new ApplicationException(Exceptions.EMAIL_EXIST_EXCEPTION);
        }
        return saveInfo(registerRequest);
    }

    @Override
    @Transactional
    public CustomerDto update(RegisterRequest registerRequest, Long id) {
        return repository.findById(id).map(customer -> {
            Customer customerMapper = mapper.registerToEntity(registerRequest);
            customerMapper.setId(id);
            customerMapper.setRole(roleService.findRole(registerRequest.roleId()));
            return mapper.entityToDto(repository.save(customer));
        }).orElseThrow(() -> new ApplicationException(Exceptions.USER_NOT_FOUND_EXCEPTION));
    }

    @Override
    public CustomerDto findById(Long id) {
        return mapper.entityToDto(findCustomer(id));
    }

    @Override
    public List<CustomerDto> findAll() {
        return mapper.entityListToDtoList(repository.findAll());
    }

    @Override
    public void deleteById(Long id) {
        repository.delete(findCustomer(id));
    }

    @Override
    public Customer findCustomer(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ApplicationException(Exceptions.USER_NOT_FOUND_EXCEPTION));
    }

    private CustomerDto saveInfo(RegisterRequest request) {
        Customer customer = mapper.registerToEntity(request);
        customer.setRole(roleService.findRole(request.roleId()));
        return mapper.entityToDto(repository.save(customer));
    }
}
