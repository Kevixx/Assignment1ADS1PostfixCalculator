package com.example.assignment1ads1.Persistance;


import com.example.assignment1ads1.Model.Interface.Token;
import com.example.assignment1ads1.Model.Operand;
import com.example.assignment1ads1.Model.Operator;
import com.example.assignment1ads1.Model.Stack;
import com.example.assignment1ads1.Persistance.Interface.IEvaluateService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class EvaluateService implements IEvaluateService {
    private final Stack stack;

    public EvaluateService() {
        stack = new Stack<Token>();
    }


    public int evaluateExpression(ArrayList<Token> tokenList) {

        for (Token token : tokenList) {

            if (token instanceof Operand) {
                stack.push(token); // Push operands onto the stack
            }

            else if (token instanceof Operator) {

                Operator operator = (Operator) token;

                Operand operand2 = (Operand) stack.pop();
                Operand operand1 = (Operand) stack.pop();

                int resultValue = performOperation(Integer.parseInt(operand1.getValue()),
                        Integer.parseInt(operand2.getValue()), operator.getValue().charAt(0));

                Operand resultOperand = new Operand(resultValue);
                stack.push(resultOperand); // Push the result back onto the stack
            }
        }
        return Integer.parseInt(((Operand) stack.pop()).getValue()); // Result is on the top of the stack
    }

    private int performOperation(int operand1, int operand2, char operator) {
        // Perform the appropriate operation based on the operator
        switch (operator) {
            case '+':
                return operand1 + operand2;
            case '-':
                return operand1 - operand2;
            case '*':
                return operand1 * operand2;
            case '/':
                if (operand2 != 0) {
                    return operand1 / operand2;
                } else {
                    throw new ArithmeticException("Division by zero");
                }
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }
}
