package com.project.medicalapp.mapper;

import com.project.medicalapp.dto.CustomerDto;
import com.project.medicalapp.dto.request.RegisterRequest;
import com.project.medicalapp.model.entity.Customer;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring" , nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface CustomerMapper {

    CustomerDto entityToDto(Customer customer);

    Customer registerToEntity(RegisterRequest registerRequest);
    List<CustomerDto> entityListToDtoList(List<Customer> customerList);

}
