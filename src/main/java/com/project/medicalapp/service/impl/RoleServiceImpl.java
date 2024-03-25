package com.project.medicalapp.service.impl;

import com.project.medicalapp.dto.RoleDto;
import com.project.medicalapp.dto.request.RoleRequest;
import com.project.medicalapp.exception.ResourceNotFoundException;
import com.project.medicalapp.mapper.RoleMapper;
import com.project.medicalapp.model.Role;
import com.project.medicalapp.repository.RoleRepository;
import com.project.medicalapp.service.RoleService;
import com.project.medicalapp.util.ServiceValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService{
    private final RoleRepository repository;
    private final RoleMapper mapper;

    @Override
    public Role findRole(Long id) {
        return repository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Salary","salary",id));
    }

    @Override
    public RoleDto find(Long id) {
        return mapper.entityToDto(findRole(id));
    }

    @Override
    public RoleDto save(RoleRequest request) {
        return saveBy(request);
    }

    @Override
    public RoleDto update(RoleRequest request,Long id) {
        Role role = findRole(id);
        // Update the existing role entity with data from the request
        mapper.updateRoleFromRequest(role, request);
        // Save the updated role entity
        role = repository.save(role);
        return mapper.entityToDto(role);
    }

    @Override
    public List<RoleDto> findAll() {
        return mapper.entityListToDtoList(repository.findAll());
    }

    @Override
    public void delete(Long id) {
        ServiceValidator.idNullCheck(id);
        repository.deleteById(id);
    }


    private RoleDto saveBy(RoleRequest roleRequest){
        return mapper.entityToDto(repository.save(mapper.requestToEntity(roleRequest)));
    }

}
