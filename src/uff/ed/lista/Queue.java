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
public interface Queue {

    public boolean enqueue(Element element);

    public boolean dequeue();

    @Override
    public String toString();

    public int size();

}
