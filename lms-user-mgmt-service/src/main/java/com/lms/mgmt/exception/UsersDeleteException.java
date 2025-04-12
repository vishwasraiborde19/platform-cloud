package com.lms.mgmt.exception;

public class UsersDeleteException extends RuntimeException {
    public UsersDeleteException(RuntimeException message) {
        super(message);
    }
}
