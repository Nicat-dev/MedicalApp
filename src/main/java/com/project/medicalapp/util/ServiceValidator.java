package com.project.medicalapp.util;

import com.project.medicalapp.exception.ResourceExistsException;
import com.project.medicalapp.exception.ResourceIdCanNotBeNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Objects;
import java.util.Optional;

public class ServiceValidator {

    public static void idNullCheck(Long id){
        if (Objects.isNull(id)){
            throw new ResourceIdCanNotBeNull("id","id",id);
        }
    }

    public static void idEqualsNull(Long id){
        if (Objects.nonNull(id)){
            throw new ResourceExistsException("id","id",id);
        }
    }

    public static <T, ID> boolean ifExist(JpaRepository<T,ID> repository, ID id){
        Optional<T> optional = repository.findById(id);
        return optional.isPresent();
    }

}
