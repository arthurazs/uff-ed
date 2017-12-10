/*
 * Copyright (c) 2017 @arthurazs
 * Refer to the MIT License
 *
 */
package uff.ed.lista;

import uff.ed.Element;

/**
 *
 * @author Arthur Zopellaro
 */
public interface Collection {

    public boolean insert(Element element);

    public Element search(int id);

    public Element remove(int id);

    public void print();

    public int size();

}
