package com.example.eindopdrachtnovibackend.exception;

public class UsernameNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public UsernameNotFoundException(String firstname) {
        super("Cannot find user " + firstname);
    }

}
