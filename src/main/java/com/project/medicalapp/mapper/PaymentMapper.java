package com.project.medicalapp.mapper;

import com.project.medicalapp.dto.PaymentDto;
import com.project.medicalapp.dto.request.PaymentRequest;
import com.project.medicalapp.model.Payment;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface PaymentMapper {

    Payment requestToEntity(PaymentRequest request);

    PaymentDto entityToDto(Payment payment);

    List<PaymentDto> entityListToDtoList(List<Payment> list);

}
