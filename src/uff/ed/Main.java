/*
 * Copyright (c) 2017 @arthurazs
 * Refer to the MIT License
 *
 */
package uff.ed;

import javax.swing.JOptionPane;
import uff.ed.lista.StudentCollection;

/**
 *
 * @author Arthur Zopellaro
 */
public class Main {

    private static Student student1 = new Student(1, "Arthur");
    private static Student student2 = new Student(2, "Lucas");
    private static Student student3 = new Student(3, "Christianne");
    private static Student student4 = new Student(4, "William");
    private static Student student5 = new Student(5, "Jane");
    private static Student student6 = new Student(6, "John");

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int pick = 2;
//        do {
//            pick = Integer.parseInt(JOptionPane.showInputDialog(
//                "Pick one:\n\n" +
//                " 1 - Unordered Linear Linked List\n" +
//                " 2 - Unordered Linear Array List"
//            ));
//        } while (pick < 1 || pick > 2);

        StudentCollection lista;

        switch (pick) {
            case 1:
                lista = new uff.ed.lista.linear.linked.Unordered();
                System.out.println("Inserting students (5 true)");
                break;
            case 2:
                lista = new uff.ed.lista.linear.array.Unordered(4);
                System.out.println("Inserting students (4 true / 1 false)");
                break;
            default:
                throw new IndexOutOfBoundsException("Variable 'pick' should be = 0 < Integer < 3");
        }

        System.out.println(lista.insert(student2));
        System.out.println(lista.insert(student4));
        System.out.println(lista.insert(student1));
        System.out.println(lista.insert(student3));
        System.out.println(lista.insert(student5));
        
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
        
        System.out.println("\nInserting one last element  (1 true)");
        System.out.println(lista.insert(student6));
        
        lista.print();
    }

}
