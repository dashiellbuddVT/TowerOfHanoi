package towerofhanoi;

import java.util.EmptyStackException;

import student.TestCase;



/**
 * 
 * @author dashiell budd
 * @version 3/21/23
 *
 */
public class LinkedStackTest extends TestCase {
    private String word;
    private String word2;
    private String word3;
    private String word4;
    private LinkedStack<String> stack;
    private LinkedStack<String> stack2;
    private LinkedStack<String> emptyStack;
    private LinkedStack<String> nullStack;
      
    /**
     * sets up the elements
     */
    public void setUp()
    {
        word = "apple";
        word2 = "car";
        word3 = "table";
        word4 = "chair";
                
        stack = new LinkedStack<String>();
        stack2 = new LinkedStack<String>();
        emptyStack = new LinkedStack<String>();
        
        
        stack.push(word);
        stack.push(word2);
        stack.push(word3);
        stack.push(word4);
        
        stack2.push(word);
        stack2.push(word2);
        stack2.push(word3);
        stack2.push(word4);

    }
    
    /**
     * tests the peek method
     */
    public void testPeek()
    {
        assertEquals(word4 , stack.peek());
        Exception thrown = null;
        try
        {
            emptyStack.peek();
        }
        catch (EmptyStackException exception)
        {
            thrown = exception;
        }
        assertNotNull(thrown);
    }
    
    /**
     * tests the is empty method
     */
    public void testIsEmpty()
    {
        assertFalse(stack.isEmpty());
        assertTrue(emptyStack.isEmpty());
    }
    
    /**
     * tests the pop method
     */
    public void testPop()
    {
        assertEquals(word4 , stack.pop());
        assertEquals(word3 , stack.pop());
        assertEquals(word2 , stack.pop());
        assertEquals(word , stack.pop());
        
        Exception thrown = null;
        try
        {
            stack.pop();
        }
        catch (EmptyStackException exception)
        {
            thrown = exception;
        }
        assertNotNull(thrown);
    }
    
    /**
     * tests the push method
     */
    public void testPush()
    {
        
        assertEquals(stack , stack2);
        stack.push("ball");
        assertNotSame(stack , stack2);
    }

    /**
     * tests the size method
     */
    public void testSize()
    {
        assertEquals(4 , stack.size());
    }
    /**
     * tests the clear method
     */
    public void testClear()
    {
        stack.clear();
        assertEquals(0 , stack.size());
        assertEquals(stack.toString() , "[]");
    }
    
    /**
     * tests the to string method
     */
    public void testToString()
    {
        assertEquals(stack.toString(), "[chair, table, car, apple]");
    }
    
    /**
     * test the equals method
     */
    public void testEquals()
    {
        assertTrue(stack.equals(stack));
        assertTrue(stack.equals(stack2));
        assertFalse(stack.equals(nullStack));
        stack2.push("car");
        assertFalse(stack.equals(stack2));
        stack2.pop();
        stack2.pop();
        stack2.push("car");
        assertFalse(stack.equals(stack2));
        assertFalse(stack.equals(word));
    }
    
}
