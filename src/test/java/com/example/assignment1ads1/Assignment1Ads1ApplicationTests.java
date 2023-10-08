package com.example.assignment1ads1;

import com.example.assignment1ads1.Model.Interface.Token;
import com.example.assignment1ads1.Model.LinkedList;
import com.example.assignment1ads1.Model.Operand;
import com.example.assignment1ads1.Model.Stack;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.example.assignment1ads1.Model.*;
import com.example.assignment1ads1.Persistance.EvaluateService;
import com.example.assignment1ads1.Persistance.Interface.IEvaluateService;

import java.util.ArrayList;
import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class Assignment1Ads1ApplicationTests {

    private IEvaluateService evaluateService;

    @BeforeEach
     void setUp() {
        evaluateService = new EvaluateService();
    }


    @Test
    void getNext() {
        Node<Integer> node = new Node<>(1, null);
        assertNull(node.getNext());
    }

    @Test
    void setNext() {
        Node<Integer> node = new Node<>(1, null);
        Node<Integer> nextNode = new Node<>(2, null);
        node.setNext(nextNode);
        assertEquals(nextNode, node.getNext());
    }


    @Test
    void size() {
        LinkedList<Integer> list = new LinkedList<>();
        assertEquals(0, list.size());
        list.add(1);
        assertEquals(1, list.size());
    }

    @Test
    void remove() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(2, list.remove(1));
        assertEquals(2, list.size());
    }


    @Test
    void push() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        assertEquals(1, stack.size());
    }

    @Test
    void pop() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        assertEquals(2, stack.pop());
        assertEquals(1, stack.size());
    }

    @Test
    void popEmptyStack() {
        Stack<Integer> stack = new Stack<>();
        assertThrows(EmptyStackException.class, stack::pop);
    }


    @Test
    void getValueOperand() {
        Operand operand = new Operand(5);
        assertEquals("5", operand.getValue());
    }


    @Test
    void getValueOperator() {
        Operator operator = new Operator('+');
        assertEquals("+", operator.getValue());
    }

    @Test
    public void testAddition() {
        ArrayList<Token> tokens = new ArrayList<>();
        tokens.add(new Operand(2));
        tokens.add(new Operand(3));
        tokens.add(new Operator('+'));

        int result = evaluateService.evaluateExpression(tokens);
        assertEquals(5, result);
    }

    @Test
    public void testSubtraction() {
        ArrayList<Token> tokens = new ArrayList<>();
        tokens.add(new Operand(5));
        tokens.add(new Operand(3));
        tokens.add(new Operator('-'));

        int result = evaluateService.evaluateExpression(tokens);
        assertEquals(2, result);
    }

    @Test
    public void testMultiplication() {
        ArrayList<Token> tokens = new ArrayList<>();
        tokens.add(new Operand(4));
        tokens.add(new Operand(5));
        tokens.add(new Operator('*'));

        int result = evaluateService.evaluateExpression(tokens);
        assertEquals(20, result);
    }

    @Test
    public void testDivision() {
        ArrayList<Token> tokens = new ArrayList<>();
        tokens.add(new Operand(10));
        tokens.add(new Operand(2));
        tokens.add(new Operator('/'));

        int result = evaluateService.evaluateExpression(tokens);
        assertEquals(5, result);
    }

    @Test
    public void testComplexExpression() {
        ArrayList<Token> tokens = new ArrayList<>();
        tokens.add(new Operand(2));
        tokens.add(new Operand(3));
        tokens.add(new Operand(1));
        tokens.add(new Operator('*'));
        tokens.add(new Operator('+'));
        tokens.add(new Operand(9));
        tokens.add(new Operator('-'));

        int result = evaluateService.evaluateExpression(tokens);
        assertEquals(-4, result);
    }

    @Test
    void evaluateExpressionWithInvalidOperator() {
        ArrayList<Token> tokens = new ArrayList<>();
        tokens.add(new Operand(2));
        tokens.add(new Operand(3));
        tokens.add(new Operator('%'));
        assertThrows(IllegalArgumentException.class, () -> evaluateService.evaluateExpression(tokens));
    }


    @Test
    void evaluateExpressionWithDivisionByZero() {
        ArrayList<Token> tokens = new ArrayList<>();
        tokens.add(new Operand(2));
        tokens.add(new Operand(0));
        tokens.add(new Operator('/'));
        assertThrows(ArithmeticException.class, () -> evaluateService.evaluateExpression(tokens));
    }
}

