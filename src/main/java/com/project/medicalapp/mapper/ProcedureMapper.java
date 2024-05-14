package com.project.medicalapp.mapper;

import com.project.medicalapp.dto.ProcedureDto;
import com.project.medicalapp.dto.request.ProcedureRequest;
import com.project.medicalapp.model.entity.Procedure;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {DoctorMapper.class})
public interface ProcedureMapper {

    @Mapping(source = "doctor.name", target = "doctorName")
    @Mapping(source = "doctor.surname", target = "doctorSurname")
    @Mapping(source = "customer.name", target = "customerName")
    @Mapping(source = "customer.surname", target = "customerSurname")
    ProcedureDto procedureToProcedureDto(Procedure procedure);

    List<ProcedureDto> entityListToDtoList(List<Procedure> procedureList);
    Procedure requestToEntity(ProcedureRequest request);

}
