package com.example.easynotes.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class DBExceptions {

    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public static class ResourceNotFoundException extends BaseException {
        private static final long serialVersionUID = 3555714415375055302L;

        public ResourceNotFoundException(String resourceName, String fieldName, Object fieldValue) {
            super(resourceName, fieldName, fieldValue);
        }
    }
}
