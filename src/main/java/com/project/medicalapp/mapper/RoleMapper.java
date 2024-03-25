package com.project.medicalapp.mapper;

import com.project.medicalapp.dto.RoleDto;
import com.project.medicalapp.dto.request.RoleRequest;
import com.project.medicalapp.model.Role;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    RoleDto entityToDto(Role role);
    List<RoleDto> entityListToDtoList(List<Role> roleList);
    Role requestToEntity(RoleRequest request);
    default void updateRoleFromRequest(Role role, RoleRequest request) {
        // Implement the logic to update the Role entity with data from the RoleRequest
        // For example:
        if (request.roleName() != null) {
            role.setRoleName(request.roleName());
        }
        // Repeat this for other fields
    }

}
