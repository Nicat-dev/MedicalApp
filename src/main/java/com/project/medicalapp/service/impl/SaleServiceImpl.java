package com.project.medicalapp.service.impl;


import com.project.medicalapp.dto.SaleDto;
import com.project.medicalapp.dto.request.SaleRequest;
import com.project.medicalapp.exception.ResourceNotFoundException;
import com.project.medicalapp.mapper.SaleMapper;
import com.project.medicalapp.model.Sale;
import com.project.medicalapp.repository.SaleRepository;
import com.project.medicalapp.service.SaleService;
import com.project.medicalapp.util.ServiceValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SaleServiceImpl implements SaleService {

    private final SaleRepository repository;
    private final SaleMapper mapper;

    @Override
    public Sale findSale(Long id) {
        return repository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Sale","id",id));
    }

    @Override
    public SaleDto find(Long id) {
        return mapper.entityToDto(findSale(id));
    }

    @Override
    public List<SaleDto> findAll() {
        return mapper.entityListToDtoList(repository.findAll());
    }

    @Override
    public SaleDto save(SaleRequest request) {
        ServiceValidator.idEqualsNull(request.id());
        return saveBy(request);
    }

    @Override
    public SaleDto update(SaleRequest request) {
        ServiceValidator.idNullCheck(request.id());
        return saveBy(request);
    }

    private SaleDto saveBy(SaleRequest request){
        return mapper.entityToDto(repository.save(mapper.requestToEntity(request)));
    }
}
