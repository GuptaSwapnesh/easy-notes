package com.example.easynotes.exception;

public abstract class BaseException extends Exception {

    private String message;
    private String resourceName;
    private String fieldName;
    private Object fieldValue;

    public BaseException(String message) {
        this.message = message;
    }

    public BaseException(String resourceName, String fieldName, Object fieldValue) {
        super(String.format("%s not found with %s : '%s'", resourceName, fieldName, fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public String getResourceName() {
        return resourceName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public Object getFieldValue() {
        return fieldValue;
    }
}
