package com.example.assignment1ads1.Persistance.Interface;

import com.example.assignment1ads1.Model.Interface.Token;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public interface IEvaluateService {
    int evaluateExpression(ArrayList<Token> tokenList);
}
