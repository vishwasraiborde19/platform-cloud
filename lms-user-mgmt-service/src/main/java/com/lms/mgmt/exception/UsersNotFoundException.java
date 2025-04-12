package com.lms.mgmt.exception;

public class UsersNotFoundException extends RuntimeException {
    public UsersNotFoundException(RuntimeException message) {
        super(message);
    }
}
