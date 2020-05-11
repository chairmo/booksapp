package com.chairmo.exception;

public class ObjectNotFoundException extends RuntimeException {

    private static long serialVersionUID = 8156413739332024474L;

    public ObjectNotFoundException(String message){
        super(message);
    }
}
