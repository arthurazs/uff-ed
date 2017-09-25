/*
 * Copyright (c) 2017 @arthurazs
 * Refer to the MIT License
 *
 */
package uff.ed;

import uff.ed.lista.StudentQueue;

/**
 *
 * @author Arthur Zopellaro
 */
public class MainQueue {

    private static final Student student1 = new Student(1, "Arthur");
    private static final Student student2 = new Student(2, "Lucas");
    private static final Student student3 = new Student(3, "Christianne");
    private static final Student student4 = new Student(4, "William");
    private static final Student student5 = new Student(5, "Jane");
    private static final Student student6 = new Student(6, "John");
    private static final int ARRAY = 1;
    private static final int LINKED = 2;
    private static final int type = LINKED;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        StudentQueue queue;

        if (type == LINKED) {
            queue = new uff.ed.lista.linear.linked.Queue();
            System.out.println("Inserting students (5 true)");
        }
        else if (type == ARRAY) {
            queue = new uff.ed.lista.linear.array.Queue(4);
            System.out.println("Inserting students (4 true / 1 false)");
        }

        System.out.println("> SIZE " + queue.size());
        System.out.println(queue.add(student2));
        System.out.println(queue.add(student4));
        System.out.println(queue.add(student1));
        System.out.println(queue.add(student3));
        System.out.println(queue.add(student5));

        System.out.println("> SIZE " + queue.size());

        queue.print();
        System.out.println("> SIZE " + queue.size());

        System.out.println("\n> SIZE " + queue.size());
        boolean removed = queue.pop();
        System.out.println("Should pop");
        if (removed)
            System.out.println("Poped successfully!");
        System.out.println("> SIZE " + queue.size());

        queue.print();
        System.out.println("> SIZE " + queue.size());

        System.out.println("\n> SIZE " + queue.size());
        System.out.println("Inserting one last element  (1 true)");
        System.out.println(queue.add(student6));
        System.out.println("> SIZE " + queue.size());

        queue.print();
        System.out.println("> SIZE " + queue.size());

        System.out.println("\n> SIZE " + queue.size());
        if(type == ARRAY)
            System.out.println("Pop everyone (4 true/2 fail)");
        else if(type == LINKED)
            System.out.println("Pop everyone (5 true/1 fail)");
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println("> SIZE " + queue.size());
        
        throw new UnsupportedOperationException("implement array queue with pointers");
    }

}
