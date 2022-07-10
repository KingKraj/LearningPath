/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dummycodings.currencyconvertion.controller;

import com.dummycodings.currencyconvertion.beans.CurrencyConvertion;
import com.dummycodings.currencyconvertion.proxy.CurrencyExchangeProxy;
import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author KarthickRaj
 */
@RestController
public class CurrencyConvertionController {

    @Autowired
    private CurrencyExchangeProxy exchangeProxy;

    @GetMapping("/currency-convertion/from/{from}/to/{to}/quantity/{quantity}")
    public ResponseEntity<CurrencyConvertion> getCurrencyConvertion(@PathVariable String from, @PathVariable String to, @PathVariable int quantity) {
        CurrencyConvertion currencyExchange = exchangeProxy.getCurrencyExchange(from, to);
        BigDecimal result = currencyExchange.getConversionMultiple().multiply(BigDecimal.valueOf(quantity));
        currencyExchange.setTotalCalculatedAmount(result);
        currencyExchange.setQuantity(quantity);
        return new ResponseEntity(currencyExchange, HttpStatus.ACCEPTED);
    }
}
