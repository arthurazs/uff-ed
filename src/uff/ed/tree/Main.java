/*
 * Copyright (c) 2017 @arthurazs
 * Refer to the MIT License
 *
 */
package uff.ed.tree;

/**
 *
 * @author Arthur Zopellaro
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        AVL avl = new AVL(true);
        
        for (int i = 0; i < 17; i++) {
            Empregado empr = new Empregado(i);
            avl.inserir(empr);
        }
        
        avl.print();
    }
    
}
