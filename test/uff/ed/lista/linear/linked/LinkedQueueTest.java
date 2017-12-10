/*
 * Copyright (c) 2017 @arthurazs
 * Refer to the MIT License
 *
 */
package uff.ed.lista.linear.linked;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.BeforeClass;
import uff.ed.lista.Queue;
import uff.ed.Element;

/**
 *
 * @author Arthur Zopellaro
 */
public class LinkedQueueTest {
    
    private Queue queue;
    private static Element element1;
    
    @BeforeClass
    public static void setUpClass() {
        element1 = new Element(1, "Test 1");
    }
    
    @Before
    public void setUp() {
        queue = new LinkedQueue();
    }
    
    @Test
    public void testCreation() {
        int result = queue.size();
        
        assertEquals(0, result);
    }
    
    @Test
    public void testDequeueNone() {
        assertFalse(queue.dequeue());
    }
    
    @Test
    public void testEnqueueOne() {
        assertTrue(queue.enqueue(element1));
    }
    
    @Test
    public void testEnqueueManyDequeueMany() {
        boolean result = true;

        //should fail
        result = result && !queue.dequeue();
        
        //should pass
        result = result && queue.enqueue(element1);
        result = result && queue.enqueue(element1);
        result = result && queue.enqueue(element1);
        result = result && queue.dequeue();
        result = result && queue.dequeue();
        result = result && queue.dequeue();
        
        //should fail
        result = result && !queue.dequeue();
        
        assertTrue(result);
    }
    
    @Test
    public void testSize() {
        int expected = 2;

        queue.dequeue();
        queue.enqueue(element1);
        queue.enqueue(element1);
        queue.enqueue(element1);
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.enqueue(element1);
        queue.enqueue(element1);
        
        int result = queue.size();
        
        assertEquals(expected, result);
    }
    
    @Test
    public void testOutputAfterEmpty() {
        String expected = "| |";

        queue.dequeue();
        queue.enqueue(element1);
        queue.enqueue(element1);
        queue.enqueue(element1);
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.enqueue(element1);
        queue.enqueue(element1);
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        
        String result = queue.toString();
        
        assertEquals(expected, result);
    }
    
    @Test
    public void testNoOutput() {
        String expected = "| |";

        String result = queue.toString();
        
        assertEquals(expected, result);
    }
    
    @Test
    public void testManyOutput() {
        String expected = "| Test 4 (4), Test 5 (5), Test 6 (6) |";
        Element element2 = new Element(2, "Test 2");
        Element element3 = new Element(3, "Test 3");
        Element element4 = new Element(4, "Test 4");
        Element element5 = new Element(5, "Test 5");
        Element element6 = new Element(6, "Test 6");

        queue.dequeue();
        queue.enqueue(element1);
        queue.enqueue(element2);
        queue.enqueue(element3);
        queue.enqueue(element4);
        queue.dequeue();
        queue.dequeue();
        queue.enqueue(element5);
        queue.enqueue(element6);
        queue.dequeue();
        
        String result = queue.toString();
        
        assertEquals(expected, result);
    }

}
