package com.project.medicalapp.service.impl;

import com.project.medicalapp.exception.ResourceNotFoundException;
import com.project.medicalapp.model.Role;
import com.project.medicalapp.repository.RoleRepository;
import com.project.medicalapp.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService{
    private final RoleRepository repository;

    @Override
    public Role findRole(Long id) {
        return repository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Salary","salary",id));
    }
}
