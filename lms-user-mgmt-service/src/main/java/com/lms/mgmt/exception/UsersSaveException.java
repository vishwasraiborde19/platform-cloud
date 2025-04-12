package com.lms.mgmt.exception;

public class UsersSaveException extends RuntimeException {
    public UsersSaveException(RuntimeException message) {
        super(message);
    }
}
