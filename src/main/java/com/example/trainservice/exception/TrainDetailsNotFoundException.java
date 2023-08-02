package com.example.trainservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseStatus;

@Component
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class TrainDetailsNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private String ErrorCode;
    private String ErrorMessage;
    public TrainDetailsNotFoundException(String errorCode, String errorMessage) {
        super();
        ErrorCode = errorCode;
        ErrorMessage = errorMessage;
    }
    public String getErrorCode() {
        return ErrorCode;
    }
    public void setErrorCode(String errorCode) {
        ErrorCode = errorCode;
    }
    public String getErrorMessage() {
        return ErrorMessage;
    }
    public void setErrorMessage(String errorMessage) {
        ErrorMessage = errorMessage;
    }
    public static long getSerialversionuid() {
        return serialVersionUID;
    }
    public TrainDetailsNotFoundException() {}

    @Override
    public String toString() {
        return "AddDetailsExceptions [ErrorCode=" + ErrorCode + ", ErrorMessage=" + ErrorMessage + "]";
    }



}
