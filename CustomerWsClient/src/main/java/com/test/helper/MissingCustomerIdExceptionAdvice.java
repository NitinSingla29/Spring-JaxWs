package com.test.helper;

import com.test.dto.Status;
import com.test.exception.MissingCustomerIdException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class MissingCustomerIdExceptionAdvice {

    @ResponseBody
    @ExceptionHandler(MissingCustomerIdException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    Status invalidAccountNumberHandler(MissingCustomerIdException ex) {
        return Status.FAILURE;
    }
}
