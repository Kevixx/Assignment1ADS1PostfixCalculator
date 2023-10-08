package com.example.assignment1ads1.Model;

import com.example.assignment1ads1.Model.Interface.Token;
import com.fasterxml.jackson.annotation.JsonProperty;
public class Operand implements Token {

    private int value;

    public Operand(@JsonProperty("value") int value) {
        this.value = value;
    }


    public String getValue() {
        return Integer.toString(value);
    }
}
