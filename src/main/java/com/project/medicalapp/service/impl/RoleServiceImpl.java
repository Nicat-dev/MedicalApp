package com.project.medicalapp.service.impl;

import com.project.medicalapp.dto.RoleDto;
import com.project.medicalapp.dto.request.RoleRequest;
import com.project.medicalapp.exception.ApplicationException;
import com.project.medicalapp.mapper.RoleMapper;
import com.project.medicalapp.model.entity.Role;
import com.project.medicalapp.model.enums.Exceptions;
import com.project.medicalapp.repository.RoleRepository;
import com.project.medicalapp.service.RoleService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepository repository;
    private final RoleMapper mapper;

    @Override
    public Role findRole(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ApplicationException(Exceptions.ROLE_NOT_FOUND));
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
    @Transactional
    public RoleDto update(RoleRequest request, Long id) {
        return repository.findById(id)
                .map(role -> {
                    Role updateRole = mapper.requestToEntity(request);
                    updateRole.setId(id);
                    return mapper.entityToDto(repository.save(updateRole));
                }).orElseThrow(() -> new ApplicationException(Exceptions.ROLE_NOT_FOUND));
    }

    @Override
    public List<RoleDto> findAll() {
        return mapper.entityListToDtoList(repository.findAll());
    }

    @Override
    public void delete(Long id) {
        repository.delete(findRole(id));
    }


    private RoleDto saveBy(RoleRequest roleRequest) {
        return mapper.entityToDto(repository.save(mapper.requestToEntity(roleRequest)));
    }

}
