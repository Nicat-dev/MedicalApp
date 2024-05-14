package com.project.medicalapp.util;

import com.project.medicalapp.exception.*;
import com.project.medicalapp.model.enums.Exceptions;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Objects;
import java.util.Optional;

public class ServiceValidator {

    public static void idNullCheck(Long id){
        if (Objects.isNull(id)){
            throw new ApplicationException(Exceptions.RESOURCE_ID_CAN_NOT_BE_NULL);
        }
    }

    public static <T, ID> boolean ifExist(JpaRepository<T,ID> repository, ID id){
        Optional<T> optional = repository.findById(id);
        return optional.isPresent();
    }

}
