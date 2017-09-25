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
public class Unordered implements StudentCollection {

    private StudentNode head;

    public Unordered() {
        head = null;
    }

    @Override
    public boolean insert(Student student) {
        StudentNode node = new StudentNode(student);
        node.setNext(head);
        head = node;
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

        if (head != null) {
            if (head.getStudent().getCpf() == cpf)
                return head.getStudent();
            else
                return removeNext(head, cpf);
        }

        return null;
    }
    
    private Student removeNext(StudentNode currentNode, int cpf){
        StudentNode nextNode = currentNode.getNext();
        StudentNode foundNode;

        if (nextNode != null) {
            if (nextNode.getStudent().getCpf() == cpf) {
                foundNode = nextNode;
                currentNode.setNext(foundNode.getNext());
                return foundNode.getStudent();
            }
            else
                return removeNext(nextNode, cpf);
        }
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

}
