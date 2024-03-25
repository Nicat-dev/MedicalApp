package com.project.medicalapp.exception;

public class ResourceNotExistException extends RuntimeException {
    public ResourceNotExistException(String resource, String  field, Object value) {
        super(String.format(" %s with %s => [ %s ] already exists",resource,field,value));
    }
}
