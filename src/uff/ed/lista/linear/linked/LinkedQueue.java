/*
 * Copyright (c) 2017 @arthurazs
 * Refer to the MIT License
 *
 */
package uff.ed.lista.linear.linked;

import uff.ed.Element;
import uff.ed.lista.Queue;

/**
 *
 * @author Arthur Zopellaro
 */
public class LinkedQueue implements Queue {

    private Node head;
    private Node tail;
    private int size;

    public LinkedQueue() {
        head = tail = null;
        size = 0;
    }

    @Override
    public boolean enqueue(Element element) {
        Node node = new Node(element);
        if (size == 0)
            head = node;
        else
            tail.setNext(node);
        tail = node;
        size++;
        return true;
    }


    @Override
    public boolean dequeue() {
        if (size > 0){
            head = head.getNext();
            size--;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        Node node = head;
        Element element;
        String result = "|";
        if (size > 0) {
            while (node != null) {
                element = node.getElement();
                result += " " + element.getContent() + ",";
                node = node.getNext();
            }
            result = result.substring(0, result.length() - 1);
        }
        result = result + " |";
        return result;
    }

    @Override
    public int size() {
        return size;
    }

}
