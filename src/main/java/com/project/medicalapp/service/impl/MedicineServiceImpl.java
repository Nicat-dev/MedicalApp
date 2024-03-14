package com.project.medicalapp.service.impl;

import com.project.medicalapp.dto.MedicineDto;
import com.project.medicalapp.dto.request.MedicineRequest;
import com.project.medicalapp.exception.ResourceNotFoundException;
import com.project.medicalapp.mapper.MedicineMapper;
import com.project.medicalapp.model.Medicine;
import com.project.medicalapp.repository.MedicineRepositroy;
import com.project.medicalapp.service.MedicineService;
import com.project.medicalapp.util.ServiceValidator;
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
    public MedicineDto update(MedicineRequest register) {
        idNullCheck(register.id());
        return null;
    }

    @Override
    public MedicineDto save(MedicineRequest register) {
        ServiceValidator.idEqualsNull(register.id());
        return mapper.medicineToDto(repositroy.save(mapper.registerToEntity(register)));
    }

    @Override
    public void delete(Long id) {
        idNullCheck(id);
        repositroy.deleteById(id);
    }


    private Medicine getById(Long id){
        return repositroy.findById(id).orElseThrow(()-> new ResourceNotFoundException("Medicine","id",id));
    }

}
