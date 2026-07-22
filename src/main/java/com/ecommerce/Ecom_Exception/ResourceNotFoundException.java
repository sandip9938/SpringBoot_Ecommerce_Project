package com.ecommerce.Ecom_Exception;

/**
 * ResourceNotFoundException
 */
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message) {
        super(message);
    }

    String resourceName;
    String fieldName;
    Object fieldValue;
    Long fieldId;

    // This constructor initializes a ResourceNotFoundException with the specified
    // resource name, field name, and field value.
    public ResourceNotFoundException(String resourceName, String fieldName, Object fieldValue) {
        super(String.format("%s not found with %s : '%s'", resourceName, fieldName, fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    // This constructor initializes a ResourceNotFoundException with the specified
    // resource name, field name, and field ID.
    public ResourceNotFoundException(String resourceName, String fieldName, Long fieldId) {
        super(String.format("%s not found with %s : '%s'", resourceName, fieldName, fieldId));
        this.resourceName = resourceName;
        this.fieldName = fieldName; 
        this.fieldId = fieldId;
    }

}
