/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dummycodings.limitservice.beans;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author KarthickRaj
 */
@Data
@NoArgsConstructor
public class Limits {

    private int min;
    private int max;

    public Limits(int min, int max) {
        this.min = min;
        this.max = max;
    }

}
