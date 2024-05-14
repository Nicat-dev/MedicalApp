package com.project.medicalapp.service.impl;

import com.project.medicalapp.dto.MedicineDto;
import com.project.medicalapp.dto.request.MedicineRequest;
import com.project.medicalapp.exception.ApplicationException;
import com.project.medicalapp.mapper.MedicineMapper;
import com.project.medicalapp.model.entity.Medicine;
import com.project.medicalapp.model.enums.Exceptions;
import com.project.medicalapp.repository.MedicineRepositroy;
import com.project.medicalapp.service.MedicineService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.project.medicalapp.util.ServiceValidator.idNullCheck;

@Service
@RequiredArgsConstructor
public class MedicineServiceImpl implements MedicineService {

    private final MedicineRepositroy repositroy;
    private final MedicineMapper mapper;

    @Override
    public MedicineDto findById(Long id) {
        return mapper.medicineToDto(getById(id));
    }

    @Override
    public List<MedicineDto> findAll() {
        return mapper.medicineListToDtoList(repositroy.findAll());
    }

    @Override
    @Transactional
    public MedicineDto update(MedicineRequest register, Long id) {
        return repositroy.findById(id).map(medicine -> {
            Medicine updateMedicine = mapper.registerToEntity(register);
            updateMedicine.setId(id);
            return mapper.medicineToDto(repositroy.save(updateMedicine));
        }).orElseThrow(() -> new ApplicationException(Exceptions.MEDICINE_NOT_FOUND_EXCEPTION));
    }

    @Override
    public MedicineDto save(MedicineRequest register) {
        return mapper.medicineToDto(repositroy.save(mapper.registerToEntity(register)));
    }

    @Override
    public void delete(Long id) {
        repositroy.delete(getById(id));
    }


    private Medicine getById(Long id) {
        return repositroy.findById(id)
                .orElseThrow(() -> new ApplicationException(Exceptions.MEDICINE_NOT_FOUND_EXCEPTION));
    }

}
