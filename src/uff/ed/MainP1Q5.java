/*
 * Copyright (c) 2017 @arthurazs
 * Refer to the MIT License
 *
 */
package uff.ed;

import uff.ed.lista.linear.linked.P1Q5;

/**
 *
 * @author Arthur Zopellaro
 */
public class MainP1Q5 {

    private static final Student student1 = new Student(1, "Arthur");
    private static final Student student2 = new Student(2, "Lucas");
    private static final Student student3 = new Student(3, "Christianne");
    private static final Student student4 = new Student(4, "William");
    private static final Student student5 = new Student(5, "Jane");
    private static final Student student6 = new Student(6, "John");

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        P1Q5 lista;

        lista = new P1Q5();
        System.out.println("Inserting students (5 true)");

        lista.insert(student2);
        lista.insert(student4);
        lista.insert(student1);
        lista.insert(student3);
        lista.insert(student5);
        lista.insert(student6);

        System.out.println("> SIZE " + lista.size());
        lista.print();

        lista.print_easy(3);
        lista.print_hard(3);
    }

}
