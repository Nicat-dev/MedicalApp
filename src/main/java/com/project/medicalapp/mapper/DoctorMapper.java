package com.project.medicalapp.mapper;

import com.project.medicalapp.dto.DoctorDto;
import com.project.medicalapp.dto.request.EmployeRegister;
import com.project.medicalapp.model.Doctor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;


@Mapper(componentModel = "spring", uses = {PrescriptionMapper.class, ProcedureMapper.class})
public interface DoctorMapper {

    @Mapping(source = "role.roleName", target = "roleName")
    @Mapping(source = "salary.salary",target = "salary")
    DoctorDto doctorToDoctorDto(Doctor doctor);

    Doctor registerToDoctor(EmployeRegister register);

    List<DoctorDto> entityListToDtoList(List<Doctor> doctors);

}