package com.project.medicalapp.mapper;

import com.project.medicalapp.dto.SalaryDto;
import com.project.medicalapp.dto.request.SalaryRequest;
import com.project.medicalapp.model.entity.Salary;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SalaryMapper {

    Salary requestToEntity(SalaryRequest request);
    SalaryDto entityToDto(Salary salary);
    List<SalaryDto> entityToDtoList(List<Salary> salaryList);
}
