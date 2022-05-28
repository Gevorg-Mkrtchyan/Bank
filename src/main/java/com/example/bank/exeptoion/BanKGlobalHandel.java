package com.example.bank.exeptoion;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BanKGlobalHandel {
    @ExceptionHandler
    public ResponseEntity<BankIncorrectData> handelException(
            Exception exception) {
        BankIncorrectData data = new BankIncorrectData();
        data.setInfo(exception.getMessage());
        return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);

    }
}
