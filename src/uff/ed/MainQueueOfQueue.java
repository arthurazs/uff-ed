/*
 * Copyright (c) 2017 @arthurazs
 * Refer to the MIT License
 *
 */
package uff.ed;

import uff.ed.lista.StudentQueue;
import uff.ed.lista.linear.array.Queue;
import uff.ed.lista.linear.array.QueueOfQueue;

/**
 *
 * @author Arthur Zopellaro
 */
public class MainQueueOfQueue {

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

        Queue queue1 = new Queue(2);
        Queue queue2 = new Queue(3);
        Queue queue3 = new Queue(2);
        Queue queue4 = new Queue(3);
        QueueOfQueue queueOfQueue = new QueueOfQueue(3);

        queue1.add(student2);
        queue1.add(student4);
        queue1.add(student1);
        queue1.add(student3);
        queue1.add(student5);
        
        queue2.add(student2);
        queue2.add(student4);
        queue2.add(student1);
        queue2.add(student3);
        queue2.add(student5);
        
        queue3.add(student1);
        queue3.add(student3);
        queue3.add(student5);
        
        queue4.add(student2);
        queue4.add(student4);
        queue4.add(student3);
        queue4.add(student5);
        
        System.out.println("Inserting queue (3 true / 1 false)");
        System.out.println(queueOfQueue.add(queue1));
        System.out.println(queueOfQueue.add(queue2));
        System.out.println(queueOfQueue.add(queue3));
        System.out.println(queueOfQueue.add(queue4));
        
        
        System.out.println("\n> SIZE " + queueOfQueue.size());
        queueOfQueue.print();
        System.out.println("> SIZE " + queueOfQueue.size());

        System.out.println("\nPoping queue");
        System.out.println(queueOfQueue.pop());
        
        System.out.println("\n> SIZE " + queueOfQueue.size());
        queueOfQueue.print();
        System.out.println("> SIZE " + queueOfQueue.size());

    }

}
