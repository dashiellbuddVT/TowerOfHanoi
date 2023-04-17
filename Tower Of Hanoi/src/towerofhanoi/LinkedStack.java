package towerofhanoi;
import stack.StackInterface;
import java.util.EmptyStackException;


/**
 * 
 * @author dashiell budd
 * @version 3/20/23
 * @param <T>
 */
public class LinkedStack<T> implements StackInterface<T> {

    private int size;
    private Node<T> topNode;
    
    @Override
    public void clear() {
        topNode = null;
        size = 0;
    }

    /**
     * @Override
     * @return true if empty false if not
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * @Override
     * @return the top item
     */
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
            
        return topNode.getData();
    }

    @SuppressWarnings("unchecked")
    @Override
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        T top = topNode.getData();
        topNode = topNode.getNextNode();
        size--;
        return top;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void push(T entry) {
        if (entry == null)
        {
            throw new IllegalArgumentException();
        }
        Node<T> newNode = new Node<T>(entry, topNode);
        topNode = newNode;
        size++;
    }
    
    /**
     * returns the size of the stack
     * @return the size of the stack
     */
    public int size()
    {
        return size;
    }
    
    /**
     * the toString version
     * @return the string version of the stack
     */
    @SuppressWarnings("unchecked")
    public String toString()
    {
        String ret = "[";
        Node<T> item = topNode;
        for (int i = 0; i < size; i++)
        {
            ret += (item.getData()).toString();
            item = item.getNextNode();
            if (i != size - 1) {
                ret += ", ";
            }
        }
        ret += "]";
        return ret;     
    }

    /**
     * returns true if the object given is the same as the calling object
     * @param other the 2nd object being compared
     * @return true if same false if not
     */
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null) {
            return false;
        }
        if (this.getClass().equals(other.getClass())) {
            LinkedStack<?> otherStack = (LinkedStack<?>) other;
            if (this.size() != otherStack.size()) {
                return false;
            }

            Node curr1 = this.topNode;
            Node curr2 = otherStack.topNode;
            
            for (int i = 0; i < this.size(); i++) {
                if (!(curr1.getData().equals(curr2.getData())))
                {
                    return false;
                }
                curr1 = curr1.getNextNode();
                curr2 = curr2.getNextNode();
            }
            return true;
        }
        return false;
    }
    /**
     * 
     * @author dashiell budd
     * @version 3/19/23
     * @param T 
     */
    private class Node<T>
    {
        private T data;
        private Node<T> next;
        
        /**constructor default
         * 
         * @param data
         */
        public Node(T data) 
        { 
            this.data = data; 
        }
        
        /**
         * constructor
         * @param entry the data
         * @param node the next node
         */
        public Node(T entry, Node<T> node) 
        { 
            this(entry); 
            this.setNextNode(node); 
        }
        
        /**
         * sets the next node
         * @param n the next node
         */
        public void setNextNode(Node<T> n)
        {
            next = n;
        }
        
        /**
         * returns next node
         * @return the next node
         */
        public Node getNextNode()
        {
            return next;
        }
        
        /**
         * returns the data
         * @return the data in the node
         */
        public T getData()
        {
            return data;
        }
      
    }

}
