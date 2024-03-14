package com.project.medicalapp.service.impl;

import com.project.medicalapp.dto.PaymentDto;
import com.project.medicalapp.dto.request.PaymentRequest;
import com.project.medicalapp.exception.ResourceNotFoundException;
import com.project.medicalapp.mapper.PaymentMapper;
import com.project.medicalapp.model.Payment;
import com.project.medicalapp.repository.PaymentRepository;
import com.project.medicalapp.service.CustomerService;
import com.project.medicalapp.service.PaymentService;
import com.project.medicalapp.util.ServiceValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.project.medicalapp.util.ServiceValidator.idNullCheck;
import static com.project.medicalapp.util.ServiceValidator.ifExist;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository repository;
    private final CustomerService customerService;
    private final PaymentMapper mapper;


    @Override
    public PaymentDto findById(Long id) {
        return mapper.entityToDto(repository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Payment","id",id)));
    }

    @Override
    public List<PaymentDto> findAll() {
        return mapper.entityListToDtoList(repository.findAll());
    }

    @Override
    public PaymentDto update(PaymentRequest request) {
        idNullCheck(request.id());
        ifExist(repository, request.id());
        return saveProcess(request);
    }

    @Override
    public PaymentDto save(PaymentRequest request) {
        ServiceValidator.idEqualsNull(request.id());
        return saveProcess(request);
    }


    private PaymentDto saveProcess(PaymentRequest request){
        Payment payment = mapper.requestToEntity(request);
        payment.setCustomer(customerService.findCustomer(request.customerId()));
        return mapper.entityToDto(payment);
    }

}
