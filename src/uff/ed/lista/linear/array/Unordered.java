/*
 * Copyright (c) 2017 @arthurazs
 * Refer to the MIT License
 *
 */
package uff.ed.lista.linear.array;

import uff.ed.Student;
import uff.ed.lista.StudentCollection;

/**
 *
 * @author Arthur Zopellaro
 */
public class Unordered implements StudentCollection {

    private final Student lista[];
    private int size;

    public Unordered(int size) {
        lista = new Student[size];
        this.size = 0;
    }

    @Override
    public boolean insert(Student student) {
        if (size < lista.length) {
            lista[size++] = student;
            return true;
        }
        return false;
    }

    @Override
    public Student search(int cpf) {
        for (int i = 0; i < size; i++) {
            Student student = lista[i];
            if (student.getCpf() == cpf) {
                return student;
            }
        }
        return null;
    }

    @Override
    public Student remove(int cpf) {
        for (int i = 0; i < size; i++) {
            Student student = lista[i];
            if(student.getCpf()==cpf){
                lista[i] = lista[size-1];
                size--;
                return student;
            }
        }
        return null;
    }

    @Override
    public void print() {
        System.out.println("\nPrinting list:");
        for (int i = 0; i < size; i++) {
            Student student = lista[i];
            System.out.println(student.getContent());
        }
    }

}
