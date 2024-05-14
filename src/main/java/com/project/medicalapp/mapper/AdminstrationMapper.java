package com.project.medicalapp.mapper;

import com.project.medicalapp.dto.AdminstrationDto;
import com.project.medicalapp.dto.request.EmployeRegister;
import com.project.medicalapp.model.entity.Adminstration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AdminstrationMapper {

    @Mapping(source = "role.roleName", target = "roleName")
    List<AdminstrationDto> entityListToDtoList(List<Adminstration> adminstrations);

    AdminstrationDto entityToDto(Adminstration adminstration);

    Adminstration requestToEntity(EmployeRegister employeRegister);

}
