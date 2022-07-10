/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dummycodings.currencyconvertion.proxy;

import com.dummycodings.currencyconvertion.beans.CurrencyConvertion;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author KarthickRaj
 */
@FeignClient(name = "Currency-Exchange")
public interface CurrencyExchangeProxy {

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyConvertion getCurrencyExchange(@PathVariable String from, @PathVariable String to);
}
