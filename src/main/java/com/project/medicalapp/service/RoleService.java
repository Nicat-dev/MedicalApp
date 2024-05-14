package com.project.medicalapp.service;

import com.project.medicalapp.dto.RoleDto;
import com.project.medicalapp.dto.request.RoleRequest;
import com.project.medicalapp.model.entity.Role;

import java.util.List;

public interface RoleService {
    Role findRole(Long id);
    RoleDto find(Long id);
    RoleDto save(RoleRequest request);
    RoleDto update(RoleRequest request,Long id);
    List<RoleDto> findAll();
    void delete(Long id);

}
