package com.project.medicalapp.mapper;

import com.project.medicalapp.dto.CustomerDto;
import com.project.medicalapp.dto.PrescriptionDto;
import com.project.medicalapp.dto.ProcedureDto;
import com.project.medicalapp.dto.request.RegisterRequest;
import com.project.medicalapp.model.Customer;
import com.project.medicalapp.model.Prescription;
import com.project.medicalapp.model.Procedure;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring" ,uses = {PrescriptionMapper.class, ProcedureMapper.class})
public interface CustomerMapper {

    @Mapping(source = "role.roleName", target = "roleName")
    CustomerDto entityToDto(Customer customer);

    Customer registerToEntity(RegisterRequest registerRequest);

    // Mapping for List of Prescription entities to List of PrescriptionDto
    List<PrescriptionDto> mapPrescriptions(List<Prescription> prescriptions);

    // Mapping for List of Procedure entities to List of ProcedureDto
    List<ProcedureDto> mapProcedures(List<Procedure> procedures);

    // Mapping List of Prescription entities to List of PrescriptionDtos in CustomerDto
    default void mapPrescriptions(List<Prescription> prescriptions, @MappingTarget CustomerDto customerDto) {
        customerDto.setPrescriptionDtos(mapPrescriptions(prescriptions));
    }

    // Mapping List of Procedure entities to List of ProcedureDtos in CustomerDto
    default void mapProcedures(List<Procedure> procedures, @MappingTarget CustomerDto customerDto) {
        customerDto.setProcedureDtos(mapProcedures(procedures));
    }

    // Explicit mapping for prescriptionDtos
    default void mapPrescriptionDtos(List<PrescriptionDto> prescriptionDtos, @MappingTarget CustomerDto customerDto) {
        customerDto.setPrescriptionDtos(prescriptionDtos);
    }

    // Explicit mapping for procedureDtos
    default void mapProcedureDtos(List<ProcedureDto> procedureDtos, @MappingTarget CustomerDto customerDto) {
        customerDto.setProcedureDtos(procedureDtos);
    }

}
