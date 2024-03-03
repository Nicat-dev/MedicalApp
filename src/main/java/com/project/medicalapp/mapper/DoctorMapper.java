package com.project.medicalapp.mapper;

import com.project.medicalapp.dto.DoctorDto;
import com.project.medicalapp.model.Doctor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring", uses = {PrescriptionMapper.class, ProcedureMapper.class})
public interface DoctorMapper {

    @Mapping(source = "role.roleName", target = "roleName")
    DoctorDto doctorToDoctorDto(Doctor doctor);

}