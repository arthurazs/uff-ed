/*
 * Copyright (c) 2017 @arthurazs
 * Refer to the MIT License
 *
 */
package uff.ed.lista.linear.array;

import uff.ed.lista.linear.linked.*;
import uff.ed.Student;
import uff.ed.lista.StudentQueue;

/**
 *
 * @author Arthur Zopellaro
 */
public class Queue implements StudentQueue {

    private Student lista[];
    private int size;

    public Queue(int size) {
        lista = new Student[size];
        this.size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean add(Student student) {
        if (size < lista.length) {
            lista[size++] = student;
            return true;
        }
        return false;

    }

    @Override
    public boolean pop() {
        if (size > 0) {
            for (int i = 0; i < size - 1; i++)
                lista[i] = lista[i + 1];
            size--;
            return true;
        }
        return false;
    }

    @Override
    public void print() {
        System.out.println("\nPrinting queue");
        Student student;
        for (int i = 0; i < size; i++) {
            student = lista[i];
            System.out.println("#" + i + " " + student.getContent());
        }
    }

}
