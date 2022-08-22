/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dummycodings.currency.conversion.controller;

import com.dummycodings.currency.conversion.beans.CurrencyConversion;
import com.dummycodings.currency.conversion.proxy.CurrencyExchangeProxy;
import java.math.BigDecimal;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author KarthickRaj
 */
@RestController
public class CurrencyConversionController {

    @Autowired
    private CurrencyExchangeProxy currencyExchangeProxy;

    @GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion calculateCurrencyConversion(
            @PathVariable String from,
            @PathVariable String to,
            @PathVariable BigDecimal quantity) {

        CurrencyConversion retrieveExchangeValue = currencyExchangeProxy.retrieveExchangeValue(from, to);

        return new CurrencyConversion(retrieveExchangeValue.getId(),
                from, to, quantity,
                retrieveExchangeValue.getConversionMultiple(),
                quantity.multiply(retrieveExchangeValue.getConversionMultiple()),
                retrieveExchangeValue.getEnvironment());

    }

}
