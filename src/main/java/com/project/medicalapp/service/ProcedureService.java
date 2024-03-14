package com.project.medicalapp.service;

import com.project.medicalapp.dto.ProcedureDto;
import com.project.medicalapp.dto.request.ProcedureRequest;

import java.util.List;

public interface ProcedureService {

    ProcedureDto find(Long id);
    List<ProcedureDto> findAll();
    ProcedureDto save(ProcedureRequest request);
    ProcedureDto update(ProcedureRequest request);
    void delete(Long id);

}
