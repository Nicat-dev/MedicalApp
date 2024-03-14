package com.project.medicalapp.mapper;

import com.project.medicalapp.dto.WorkerDto;
import com.project.medicalapp.dto.request.EmployeRegister;
import com.project.medicalapp.model.Worker;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface WorkerMapper {

    @Mapping(source = "role.roleName", target = "roleName")
    @Mapping(source = "salary.salary",target = "salary")
    WorkerDto entityToDto(Worker worker);

    Worker requestToEntity(EmployeRegister register);
    List<WorkerDto> entityListToDtoList(List<Worker> workerList);

}
