package com.disney.alkemy.exceptions;

import org.springframework.security.authentication.BadCredentialsException;

public class ParamNotFound extends RuntimeException{
    public ParamNotFound(String error) {
        super(error);
    }

}
