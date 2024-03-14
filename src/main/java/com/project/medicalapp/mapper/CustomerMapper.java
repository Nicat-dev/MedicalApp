package com.project.medicalapp.mapper;

import com.project.medicalapp.dto.CustomerDto;
import com.project.medicalapp.dto.request.RegisterRequest;
import com.project.medicalapp.model.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring" ,uses = {PrescriptionMapper.class, ProcedureMapper.class})
public interface CustomerMapper {

    @Mapping(source = "role.roleName", target = "roleName")
    CustomerDto entityToDto(Customer customer);

    Customer registerToEntity(RegisterRequest registerRequest);

}
