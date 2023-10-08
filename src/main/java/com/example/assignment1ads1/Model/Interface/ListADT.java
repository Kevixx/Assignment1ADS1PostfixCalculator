package com.example.assignment1ads1.Model.Interface;

public interface ListADT<T> {

    int size();

    void add(T elm);
    T remove(int index);
}
