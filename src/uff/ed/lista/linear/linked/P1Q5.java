/*
 * Copyright (c) 2017 @arthurazs
 * Refer to the MIT License
 *
 */
package uff.ed.lista.linear.linked;

import uff.ed.Student;
import uff.ed.lista.StudentCollection;

/**
 *
 * @author Arthur Zopellaro
 */
public class P1Q5 implements StudentCollection {

    private StudentNode head;
    private int size;

    public P1Q5() {
        head = null;
        size = 0;
    }

    @Override
    public boolean insert(Student student) {
        StudentNode node = new StudentNode(student);
        node.setNext(head);
        head = node;
        size++;
        return true;
    }

    @Override
    public Student search(int cpf) {
        StudentNode node = head;
        Student found = null;

        while (node != null) {
            if (node.getStudent().getCpf() == cpf) {
                found = node.getStudent();
                break;
            }
            node = node.getNext();
        }

        return found;
    }

    @Override
    public Student remove(int cpf) {

        Student removed = null;
        if (head != null)
            if (head.getStudent().getCpf() == cpf)
                removed = head.getStudent();
            else
                removed = removeNext(head, cpf);

        if (removed != null)
            size--;

        return removed;
    }

    private Student removeNext(StudentNode currentNode, int cpf) {
        StudentNode nextNode = currentNode.getNext();
        StudentNode foundNode;

        if (nextNode != null)
            if (nextNode.getStudent().getCpf() == cpf) {
                foundNode = nextNode;
                currentNode.setNext(foundNode.getNext());
                return foundNode.getStudent();
            }
            else
                return removeNext(nextNode, cpf);
        return null;
    }

    @Override
    public void print() {
        System.out.println("\nPrinting list:");
        StudentNode node = head;
        while (node != null) {
            System.out.println(node.getStudent().getContent());
            node = node.getNext();
        }
    }

    public void print_easy(int nLastElements) {
        System.out.println("\nPrinting list:");
        print_easy(head, nLastElements, 0);
    }
    
    public void print_hard(int nLastElements) {
        System.out.println("\nPrinting list:");
        print_hard(head, nLastElements);
    }
    
    private void print_easy(StudentNode node, int n, int count){
        if(node!=null){
            count++;
            if(size-count < n)
                System.out.println(node.getStudent().getContent());
            print_easy(node.getNext(), n, count);
        }
    }
    
    private int print_hard(StudentNode node, int n){
        int count = 0;
        if(node!=null){
            count = print_hard(node.getNext(), n);
            if(count < n)
                System.out.println(node.getStudent().getContent());
            count++;
        }
        return count;
    }

    @Override
    public int size() {
        return size;
    }

}
