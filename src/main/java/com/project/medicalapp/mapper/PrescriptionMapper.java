package com.project.medicalapp.mapper;

import com.project.medicalapp.dto.PrescriptionDto;
import com.project.medicalapp.model.Prescription;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {DoctorMapper.class})
public interface PrescriptionMapper {

    @Mapping(source = "doctor.name", target = "doctorName")
    @Mapping(source = "doctor.surname", target = "doctorSurname")
    @Mapping(source = "customer.name", target = "customerName")
    @Mapping(source = "customer.surname", target = "customerSurname")
    PrescriptionDto prescriptionToPrescriptionDto(Prescription prescription);

}
