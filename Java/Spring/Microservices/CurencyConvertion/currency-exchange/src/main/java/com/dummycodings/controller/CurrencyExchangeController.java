package com.dummycodings.controller;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.dummycodings.beans.CurrencyExchange;
import com.dummycodings.repository.CurrencyExchangeRepository;

@RestController
public class CurrencyExchangeController {

    @Autowired
    private Environment environment;
    @Autowired
    private CurrencyExchangeRepository exchangeRepsotiory;

    @GetMapping("currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange getCurrencyExchange(@PathVariable String from, @PathVariable String to) {
        CurrencyExchange exchange = new CurrencyExchange();
        Optional<CurrencyExchange> exchangeInfoBundle = exchangeRepsotiory.findByFromAndTo(from, to);
        if (exchangeInfoBundle.isPresent()) {
            CurrencyExchange exchangeInfo = exchangeInfoBundle.get();
            exchange.setFrom(exchangeInfo.getFrom());
            exchange.setTo(exchangeInfo.getTo());
            exchange.setId(exchangeInfo.getId());
            exchange.setConversionMultiple(exchangeInfo.getConversionMultiple());
            String port = environment.getProperty("local.server.port");
            exchange.setEnvironment(port);

        }
        return exchange;
    }

}
