package com.project.medicalapp.mapper;

import com.project.medicalapp.dto.RoleDto;
import com.project.medicalapp.model.Role;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    RoleDto entityToDto(Role role);
}
