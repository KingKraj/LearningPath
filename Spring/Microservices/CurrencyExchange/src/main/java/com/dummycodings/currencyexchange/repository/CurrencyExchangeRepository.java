/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.dummycodings.currencyexchange.repository;

import com.dummycodings.currencyexchange.beans.CurrencyExchange;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author KarthickRaj
 */
@Repository
public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Long> {

    public Optional<CurrencyExchange> findByFromIgnoreCaseAndToIgnoreCase(String from, String to);
}
