package com.example.assignment1ads1.Model;

import com.example.assignment1ads1.Model.Interface.ListADT;

import java.util.EmptyStackException;

public class Stack<T> {
    ListADT<T> linkedList;

    public Stack() {
        linkedList = new LinkedList<>();
    }

    public void push(T element) {
        linkedList.add(element);
    }

    public int size() {
        return linkedList.size();
    }

    public T pop() {
        if (linkedList.size() == 0) {
            throw new EmptyStackException();
        }
        return linkedList.remove(linkedList.size() - 1);
    }
}
