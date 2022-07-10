/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dummycodings.currencyexchange.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 *
 * @author KarthickRaj
 */
@RestController
@ControllerAdvice
public class CustomExceptionHandling extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ExchangeNotFoundException.class)
    public final ResponseEntity<Object> hanldExchangeNotFoundException(Exception ex, WebRequest request) throws Exception {
        ExchangeNotFoundException exchangeNotFoundException = new ExchangeNotFoundException(ex.getMessage());
        request.getDescription(false);
        return new ResponseEntity(exchangeNotFoundException, HttpStatus.NOT_FOUND);
    }
}
