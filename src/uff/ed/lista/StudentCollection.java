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
public interface StudentCollection {

    public boolean insert(Student student);
    public Student search(int cpf);
    public Student remove(int cpf);
    public void print();
    
}
