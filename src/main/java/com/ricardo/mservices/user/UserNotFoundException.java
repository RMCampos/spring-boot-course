package com.ricardo.mservices.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {

    public static final String MESSAGE = "User Not Found.";

    public UserNotFoundException(String s) {
        super(s);
    }
}
