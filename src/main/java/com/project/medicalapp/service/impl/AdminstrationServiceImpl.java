package com.project.medicalapp.service.impl;

import com.project.medicalapp.dto.AdminstrationDto;
import com.project.medicalapp.dto.request.EmployeRegister;
import com.project.medicalapp.exception.ResourceIdCanNotBeNull;
import com.project.medicalapp.exception.ResourceNotFoundException;
import com.project.medicalapp.mapper.AdminstrationMapper;
import com.project.medicalapp.model.Adminstration;
import com.project.medicalapp.repository.AdminstrationRepository;
import com.project.medicalapp.repository.RoleRepository;
import com.project.medicalapp.service.AdminstrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class AdminstrationServiceImpl implements AdminstrationService {

    private final AdminstrationMapper mapper;
    private final AdminstrationRepository repository;
    private final RoleRepository roleRepository;

    @Override
    public List<AdminstrationDto> getList() {
        return mapper.entityListToDtoList(repository.findAll());
    }

    @Override
    public AdminstrationDto getById(Long id) {
        idNullCheck(id);
        return mapper.entityToDto( repository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Adminstration",id.toString(),id)));
    }

    @Override
    public AdminstrationDto updateById(EmployeRegister register) {
        idNullCheck(register.id());
        Adminstration adminstration = mapper.requestToEntity(register);
        adminstration.setRole(roleRepository.findById(register.roleId())
                .orElseThrow(()-> new ResourceNotFoundException("Role",register.roleId().toString(),register)));
        return mapper.entityToDto(repository.save(adminstration));
    }

    @Override
    public void deleteById(Long id) {
        idNullCheck(id);
        repository.deleteById(id);
    }

    private void idNullCheck(Long id){
        if (Objects.isNull(id)){
            throw new ResourceIdCanNotBeNull("id",id.toString(),id);
        }
    }

}
