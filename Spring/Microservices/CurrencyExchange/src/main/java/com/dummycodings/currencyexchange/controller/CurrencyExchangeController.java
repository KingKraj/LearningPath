/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dummycodings.currencyexchange.controller;

import com.dummycodings.currencyexchange.beans.CurrencyExchange;
import com.dummycodings.currencyexchange.exception.ExchangeNotFoundException;
import com.dummycodings.currencyexchange.repository.CurrencyExchangeRepository;
import java.math.BigDecimal;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author KarthickRaj
 */
@RestController
public class CurrencyExchangeController {

    @Autowired
    private Environment env;
    @Autowired
    private CurrencyExchangeRepository currencyExchangeRepo;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange getCurrencyRate(@PathVariable String from, @PathVariable String to) throws Exception {
        String port = env.getProperty("server.port");
        Optional<CurrencyExchange> findByFromAndTo = currencyExchangeRepo.findByFromIgnoreCaseAndToIgnoreCase(from, to);
        if (findByFromAndTo.isPresent()) {
            CurrencyExchange exchange = findByFromAndTo.get();
            exchange.setEnvironment(port);
            return exchange;
        } else {
            throw new ExchangeNotFoundException("unable to find Match for Given Exchange ..!");
        }
    }

}
