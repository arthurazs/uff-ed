/*
 * Copyright (c) 2017 @arthurazs
 * Refer to the MIT License
 *
 */
package uff.ed;

/**
 *
 * @author Arthur Zopellaro
 */
public class Student {

    private String name;
    private int cpf;

    public Student(int cpf, String name) {
        this.name = name;
        this.cpf = cpf;
    }

    public String getContent() {
        return name + " (" + cpf + ")";
    }

    public int getCpf() {
        return cpf;
    }

}
