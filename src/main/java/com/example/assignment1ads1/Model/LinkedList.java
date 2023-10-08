package com.example.assignment1ads1.Model;

import com.example.assignment1ads1.Model.Interface.ListADT;

public class LinkedList<T> implements ListADT<T> {

    private Node<T> first;
    private int size;

    public LinkedList() {
        first = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    public void add(T data) {
        Node<T> newNode = new Node(data, null);
        if (size == 0) {
            first = newNode;
        } else {
            Node<T> current = first;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
        size++;
    }


    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        Node<T> removedElement = null;

        if (index == 0) {
            // Special case: Removing the head of the list
            removedElement = first;
            first = first.getNext();

        } else {
            Node<T> current = first;
            for (int i = 0; i < index - 1; i++) {
                current = current.getNext();
            }
            removedElement = current.getNext();
            // Adjust the pointers to skip the element to be removed
            current.setNext(current.getNext().getNext());
        }
        size--;
        return removedElement.getElm();
    }
}

