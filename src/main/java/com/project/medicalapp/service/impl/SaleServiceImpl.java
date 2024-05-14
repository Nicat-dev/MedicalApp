package com.project.medicalapp.service.impl;


import com.project.medicalapp.dto.SaleDto;
import com.project.medicalapp.dto.request.SaleRequest;
import com.project.medicalapp.exception.ApplicationException;
import com.project.medicalapp.mapper.SaleMapper;
import com.project.medicalapp.model.entity.Sale;
import com.project.medicalapp.model.enums.Exceptions;
import com.project.medicalapp.repository.SaleRepository;
import com.project.medicalapp.service.SaleService;
import com.project.medicalapp.util.ServiceValidator;
import jakarta.transaction.Transactional;
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
                .orElseThrow(() -> new ApplicationException(Exceptions.SALE_NOT_FOUND));
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
        return saveBy(request);
    }

    @Override
    @Transactional
    public SaleDto update(SaleRequest request, Long id) {
        return repository.findById(id).map(sale -> {
            Sale updateSale = mapper.requestToEntity(request);
            return mapper.entityToDto(updateSale);
        }).orElseThrow(() -> new ApplicationException(Exceptions.SALE_NOT_FOUND));
    }

    @Override
    public void delete(Long id) {
        ServiceValidator.idNullCheck(id);
        repository.deleteById(id);
    }

    private SaleDto saveBy(SaleRequest request) {
        return mapper.entityToDto(repository.save(mapper.requestToEntity(request)));
    }
}
