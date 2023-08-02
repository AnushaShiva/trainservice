package com.example.trainservice.ExceptioController;

import com.example.trainservice.exception.TrainDetailsNotFoundException;
import org.apache.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyControllerAdvice {


    @ExceptionHandler(TrainDetailsNotFoundException.class)
    public ResponseEntity<String> handelNoSuchElement(TrainDetailsNotFoundException trainDetailsNotFoundException){
        return new ResponseEntity<String>(trainDetailsNotFoundException.getErrorMessage(), null, HttpStatus.SC_BAD_REQUEST);
    }
}
