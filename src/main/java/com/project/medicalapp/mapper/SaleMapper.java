package com.project.medicalapp.mapper;

import com.project.medicalapp.dto.SaleDto;
import com.project.medicalapp.dto.request.SaleRequest;
import com.project.medicalapp.model.Sale;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SaleMapper {

    SaleDto entityToDto(Sale sale);
    List<SaleDto> entityListToDtoList(List<Sale> sales);
    Sale requestToEntity(SaleRequest request);

}
