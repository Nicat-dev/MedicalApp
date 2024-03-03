package com.project.medicalapp.util;

import com.project.medicalapp.exception.ResourceIdCanNotBeNull;

import java.util.Objects;

public class ServiceValidator {

    public static void idNullCheck(Long id){
        if (Objects.isNull(id)){
            throw new ResourceIdCanNotBeNull("id","id",id);
        }
    }

}
