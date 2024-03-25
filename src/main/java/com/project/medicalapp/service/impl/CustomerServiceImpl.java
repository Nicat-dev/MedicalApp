package com.project.medicalapp.service.impl;

import com.project.medicalapp.dto.CustomerDto;
import com.project.medicalapp.dto.request.RegisterRequest;
import com.project.medicalapp.exception.ResourceExistsException;
import com.project.medicalapp.exception.ResourceNotFoundException;
import com.project.medicalapp.mapper.CustomerMapper;
import com.project.medicalapp.model.Customer;
import com.project.medicalapp.repository.CustomerRepository;
import com.project.medicalapp.service.CustomerService;
import com.project.medicalapp.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.project.medicalapp.util.ServiceValidator.idNullCheck;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository repository;
    private final CustomerMapper mapper;
    private final RoleService roleService;

    @Override
    public CustomerDto save(RegisterRequest registerRequest) {
        if (repository.existsByEmail(registerRequest.email())){
            throw new ResourceExistsException("Customer","email",registerRequest.email());
        }
        return saveInfo(registerRequest);
    }

    @Override
    public CustomerDto update(RegisterRequest registerRequest,Long id) {
        findCustomer(id);
        return saveInfo(registerRequest);
    }

    @Override
    public CustomerDto findById(Long id) {
        idNullCheck(id);
        return mapper.entityToDto(findCustomer(id));
    }

    @Override
    public List<CustomerDto> findAll() {
        return mapper.entityListToDtoList(repository.findAll());
    }

    @Override
    public void deleteById(Long id) {
        idNullCheck(id);
        repository.deleteById(id);
    }

    @Override
    public Customer findCustomer(Long id) {
        return repository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Customer",id.toString(),id));
    }

    private CustomerDto saveInfo(RegisterRequest request) {
        Customer customer = mapper.registerToEntity(request);
        customer.setRole(roleService.findRole(request.roleId()));
        return mapper.entityToDto(repository.save(customer));
    }
}
