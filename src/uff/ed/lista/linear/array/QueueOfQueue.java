/*
 * Copyright (c) 2017 @arthurazs
 * Refer to the MIT License
 *
 */
package uff.ed.lista.linear.array;


/**
 *
 * @author Arthur Zopellaro
 */
public class QueueOfQueue  {

    private final Queue lista[];
    private int size;

    public QueueOfQueue(int size) {
        lista = new Queue[size];
        this.size = 0;
    }

    public int size() {
        return size;
    }

    public boolean add(Queue queue) {
        if (size < lista.length) {
            lista[size++] = queue;
            return true;
        }
        return false;

    }

    public boolean pop() {
        if (size > 0) {
            for (int i = 0; i < size - 1; i++)
                lista[i] = lista[i + 1];
            size--;
            return true;
        }
        return false;
    }

    public void print() {
        System.out.println("\nPrinting queue");
        Queue queue;
        for (int i = 0; i < size; i++) {
            System.out.print("\n");
            System.out.print("# " + i + " ");
            queue = lista[i];
            queue.print();
        }
    }

}
