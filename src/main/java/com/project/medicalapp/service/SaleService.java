package com.project.medicalapp.service;

import com.project.medicalapp.dto.SaleDto;
import com.project.medicalapp.dto.request.SaleRequest;
import com.project.medicalapp.model.Sale;

import java.util.List;

public interface SaleService {

    Sale findSale(Long id);
    SaleDto find(Long id);
    List<SaleDto> findAll();
    SaleDto save(SaleRequest request);
    SaleDto update(SaleRequest request,Long id);
    void delete(Long id);

}
