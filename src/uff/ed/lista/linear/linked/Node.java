/*
 * Copyright (c) 2017 @arthurazs
 * Refer to the MIT License
 *
 */
package uff.ed.lista.linear.linked;

import uff.ed.Element;

/**
 *
 * @author Arthur Zopellaro
 */
public class Node {

    private final Element element;
    private Node next;

    public Node(Element element) {
        this.element = element;
        this.next = null;
    }

    public Element getElement() {
        return element;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

}
