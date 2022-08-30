package com.disney.alkemy.exceptions;

public class ParamNotFound extends RuntimeException{
    public ParamNotFound(String error) {
        super(error);
    }
}
