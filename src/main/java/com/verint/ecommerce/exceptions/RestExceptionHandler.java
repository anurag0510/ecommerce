package com.verint.ecommerce.exceptions;

import com.verint.ecommerce.models.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(value = {EcommerceServiceException.class})
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorMessage handleUserServiceException(EcommerceServiceException ex, WebRequest request) {
        ErrorMessage returnValue = new ErrorMessage();
        returnValue.setDetails(ex.getMessage());
        returnValue.setError("BAD REQUEST");
        returnValue.setStatusCode(400);
        return returnValue;
    }

    @ExceptionHandler(value = {IllegalArgumentException.class})
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorMessage handleUserServiceException(IllegalArgumentException ex, WebRequest request) {
        ErrorMessage returnValue = new ErrorMessage();
        returnValue.setDetails(ex.getMessage());
        returnValue.setError("BAD REQUEST");
        returnValue.setStatusCode(400);
        return returnValue;
    }

    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorMessage handleMethodArgumentNotValidException(MethodArgumentNotValidException ex, WebRequest request) {
        ErrorMessage returnValue = new ErrorMessage();
        returnValue.setDetails(processFieldError(ex.getBindingResult().getFieldErrors()));
        returnValue.setError("BAD REQUEST");
        returnValue.setStatusCode(400);
        return returnValue;
    }

    @ExceptionHandler(value = {ConstraintViolationException.class})
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorMessage handleConstraintViolationException(ConstraintViolationException ex, WebRequest request) {
        ErrorMessage returnValue = new ErrorMessage();
        returnValue.setDetails(ex.getLocalizedMessage());
        returnValue.setError("BAD REQUEST");
        returnValue.setStatusCode(400);
        return returnValue;
    }

    private List<String> processFieldError(List<FieldError> errorList) {
        List<String> returnList = new ArrayList<>();
        for (FieldError fieldError : errorList) {
            returnList.add(fieldError.getDefaultMessage());
        }
        return returnList;
    }
}
