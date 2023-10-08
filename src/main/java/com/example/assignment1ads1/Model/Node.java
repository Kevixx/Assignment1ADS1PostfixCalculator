package com.example.assignment1ads1.Model;

public class Node<T> {
    private T elm;
    private Node<T> next;

    public Node(T elm, Node<T> next){
        this.elm = elm;
        this.next = next;
    }

    public T getElm() {
        return elm;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }
}
