/*
 * Copyright (c) 2017 @arthurazs
 * Refer to the MIT License
 *
 */
package uff.ed.lista.linear.linked;

import uff.ed.Student;
import uff.ed.lista.StudentQueue;

/**
 *
 * @author Arthur Zopellaro
 */
public class Queue implements StudentQueue {

    private StudentNode head;
    private StudentNode tail;
    private int size;

    public Queue() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public boolean add(Student student) {
        StudentNode node = new StudentNode(student);
        if (size == 0) {
            tail = head = node;
        }
        else{
            tail.setNext(node);
            tail = node;
        }
        size++;
        return true;
    }


    @Override
    public boolean pop() {
        if (size  == 1){
            tail = head = null;
            size--;
        }
        else if (size > 1){
            head = head.getNext();
            size--;
        }
        else
            return false;
        return true;
    }

    @Override
    public void print() {
        System.out.println("\nPrinting queue");
        StudentNode node = head;
        Student student;
        int count = 0;
        while (node != null) {
            student = node.getStudent();
            System.out.println("#" + count + " " + student.getContent());
            count++;
            node = node.getNext();
        }
    }

    @Override
    public int size() {
        return size;
    }

}
