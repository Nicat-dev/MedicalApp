package com.project.medicalapp.exception;

public class ResourceIdCanNotBeNull extends RuntimeException{
    public ResourceIdCanNotBeNull(String resource,String field,Object value) {
        super(String.format(" %s with %s => [ %s ] id cannot be null",resource,field,value));
    }
}
