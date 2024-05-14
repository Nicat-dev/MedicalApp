package com.project.medicalapp.mapper;

import com.project.medicalapp.dto.MedicineDto;
import com.project.medicalapp.dto.request.MedicineRequest;
import com.project.medicalapp.model.entity.Medicine;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface MedicineMapper {

    MedicineDto medicineToDto(Medicine medicine);
    Medicine registerToEntity(MedicineRequest register);
    List<MedicineDto> medicineListToDtoList(List<Medicine> medicines);

}
