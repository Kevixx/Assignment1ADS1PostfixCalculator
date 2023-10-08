package com.example.assignment1ads1.Model;

import com.example.assignment1ads1.Model.Interface.Token;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Operator implements Token {

    private final char operator;

    public Operator(@JsonProperty("operator") char operator) {
        this.operator = operator;
    }

    @Override
    public String getValue() {
        return String.valueOf(operator);
    }
}
