/*
 * Copyright (c) 2017 @arthurazs
 * Refer to the MIT License
 *
 */
package uff.ed.lista;

import uff.ed.Student;

/**
 *
 * @author Arthur Zopellaro
 */
public interface StudentQueue {

    public boolean add(Student student);

    public boolean pop();

    public void print();

    public int size();

}
