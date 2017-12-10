/*
 * Copyright (c) 2017 @arthurazs
 * Refer to the MIT License
 *
 */
package uff.ed.lista.linear.array;

import uff.ed.Element;
import uff.ed.lista.Queue;

/**
 *
 * @author Arthur Zopellaro
 */
public class ArrayQueue implements Queue {

    private final Element array[];
    private int size;
    private int head;
    private int tail;
    private final int capacity;

    public ArrayQueue(int capacity) {
        array = new Element[capacity];
        this.capacity = capacity;
        this.size = this.head = this.tail = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean enqueue(Element element) {
        if (size < capacity) {
            array[tail] = element;
            tail = (tail + 1) % capacity;
            size++;
            return true;
        }
        return false;

    }

    @Override
    public boolean dequeue() {
        if (size > 0) {
            head = (head + 1) % capacity;
            size--;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        Element element;
        String result = "|";
        
        System.out.println("");
        System.out.println("");
        
        if (size > 0) {
            for (int i = head; i < head + size; i++) {
                int position = i % capacity;
                element = array[position];
                result += " " + element.getContent() + ",";
            }
            result = result.substring(0, result.length() - 1);
        }
        result = result + " |";
        return result;
    }

}
