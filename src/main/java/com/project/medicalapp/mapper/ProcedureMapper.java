package com.project.medicalapp.mapper;

import com.project.medicalapp.dto.ProcedureDto;
import com.project.medicalapp.model.Procedure;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {DoctorMapper.class})
public interface ProcedureMapper {

    @Mapping(source = "doctor.name", target = "doctorName")
    @Mapping(source = "doctor.surname", target = "doctorSurname")
    @Mapping(source = "customer.name", target = "customerName")
    @Mapping(source = "customer.surname", target = "customerSurname")
    ProcedureDto procedureToProcedureDto(Procedure procedure);

}
