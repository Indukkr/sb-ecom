package com.ecommerce.sb_ecom.exception;

public class ResourceNotFoundException extends RuntimeException {

    String resourceName;
    String field;
    String fieldName;
    Long fieldID;

    public ResourceNotFoundException() {

    }

    public ResourceNotFoundException(String field, String fieldName, String resourceName) {

        super(String.format("%s not found with %s : %s",resourceName,field, fieldName));

        this.field = field;
        this.fieldName = fieldName;
        this.resourceName = resourceName;
    }

    public ResourceNotFoundException(String field,  String resourceName,Long fieldID) {

        super(String.format("%s not found with %s : %d",field,resourceName, fieldID));
        this.field = field;
        this.fieldID = fieldID;
        this.resourceName = resourceName;
    }
}
