/*
 * Copyright (c) 2017 @arthurazs
 * Refer to the MIT License
 *
 */
package uff.ed;

/**
 *
 * @author Arthur Zopellaro
 */
public class Element {

    private final String name;
    private final int id;

    public Element(int id, String name) {
        this.name = name;
        this.id = id;
    }

    public String getContent() {
        return name + " (" + id + ")";
    }

    public int getId() {
        return id;
    }

}
