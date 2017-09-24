/*
 * Copyright (c) 2017 @arthurazs
 * Refer to the MIT License
 *
 */
package uff.ed;

import uff.ed.lista.Lista;
import uff.ed.lista.linear.linked.Unordered;

/**
 *
 * @author Arthur Zopellaro
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Student student1 = new Student(1, "Arthur");
        Student student2 = new Student(2, "Lucas");
        Student student3 = new Student(3, "Christianne");
        Student student4 = new Student(4, "William");
        
        Lista lista = new Unordered();
        lista.insert(student2);
        lista.insert(student4);
        lista.insert(student1);
        lista.insert(student3);
        lista.print();
        
        Student found = lista.search(student4.getCpf());
        System.out.println("\nShould find");
        if (found != null)
            System.out.println("Found student: " + found.getContent());
        
        Student removed = lista.remove(student4.getCpf());
        System.out.println("\nShould remove");
        if (removed == student4)
            System.out.println(removed.getContent() + " successfully removed!");
        
        int fake_cpf = removed.getCpf();
        found = lista.search(fake_cpf);
        System.out.println("\nShould not find");
        if (found == null)
            System.out.println("Student with cpf " + fake_cpf + " not found!");
        
        removed = lista.remove(fake_cpf);
        System.out.println("\nShould not remove");
        if (removed == null)
            System.out.println("Student with cpf " + fake_cpf + " not found!");
        
        lista.print();
    }
    
}
