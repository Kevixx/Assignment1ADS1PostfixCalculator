package com.example.assignment1ads1.Model.Interface;

import com.example.assignment1ads1.Model.LinkedList;
import com.example.assignment1ads1.Model.Operand;
import com.example.assignment1ads1.Model.Operator;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Operand.class, name = "Operand"),
        @JsonSubTypes.Type(value = Operator.class, name = "Operator")
})
public interface Token {
    String getValue();
}
