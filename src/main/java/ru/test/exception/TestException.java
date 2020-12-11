package ru.test.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.BAD_REQUEST)
public class TestException extends RuntimeException {
    public TestException(String message) {
        super(message);
    }
}
