package com.project.medicalapp.service.impl;

import com.project.medicalapp.dto.PaymentDto;
import com.project.medicalapp.dto.request.PaymentRequest;
import com.project.medicalapp.exception.ResourceNotFoundException;
import com.project.medicalapp.mapper.PaymentMapper;
import com.project.medicalapp.model.Payment;
import com.project.medicalapp.repository.PaymentRepository;
import com.project.medicalapp.service.CustomerService;
import com.project.medicalapp.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.project.medicalapp.util.ServiceValidator.idNullCheck;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository repository;
    private final CustomerService customerService;
    private final PaymentMapper mapper;


    @Override
    public PaymentDto findById(Long id) {
        return mapper.entityToDto(findPayment(id));
    }

    @Override
    public List<PaymentDto> findAll() {
        return mapper.entityListToDtoList(repository.findAll());
    }

    @Override
    public PaymentDto update(PaymentRequest request, Long id) {
        findPayment(id);
        return saveProcess(request);
    }

    @Override
    public PaymentDto save(PaymentRequest request) {
        return saveProcess(request);
    }

    @Override
    public void delete(Long id) {
        idNullCheck(id);
        repository.deleteById(id);
    }


    private PaymentDto saveProcess(PaymentRequest request){
        Payment payment = mapper.requestToEntity(request);
        payment.setCustomer(customerService.findCustomer(request.customerId()));
        return mapper.entityToDto(payment);
    }

    private Payment findPayment(Long id){
        return repository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Payment","id",id));
    }

}
