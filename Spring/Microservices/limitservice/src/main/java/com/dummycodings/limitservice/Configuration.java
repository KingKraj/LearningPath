/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dummycodings.limitservice;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 *
 * @author KarthickRaj
 */
@Data
@NoArgsConstructor
@Component
@ConfigurationProperties("limit-service")
public class Configuration {

    private int minimum;
    private int maximum;
    
    

}
