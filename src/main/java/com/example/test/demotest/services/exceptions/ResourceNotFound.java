package com.example.test.demotest.services.exceptions;

public class ResourceNotFound extends RuntimeException {

    public ResourceNotFound(String message){
        super("Resource not found. " + message);

    }
}
