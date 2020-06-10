
/**
 * Write a description of class Node here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Node<T>
{
    // instance variables - replace the example below with your own
    private Node<T> previous;
    private Node<T> next;
    private T data;

    /**
     * Constructor for objects of class Node
     */
    public Node(T data)
    {
        init(data, this, this);
    }
    
    /**
     * Constructor where you choose the data, previous node and next node.
     * @param data the datatype to enter.
     * @param prev the node stored behind the current node.
     * @param next the node stored after the current node.
     */
    public Node(T data, Node prev, Node next) {
        init(data, prev, next);
    }
    
    /**
     * Code to reduce code duplication in constructors.
     */
    private void init(T data, Node prev, Node next) {
        this.data = data;
        this.previous = prev;
        this.next = next;
    }
    
    /**
     * Set the next node
     * @param next the next node.
     */
    public void setNext(Node next) {
        this.next = next;
    }
    
    /**
     * Set the previous node.
     * @param previous the previous node.
     */
    public void setPrevious(Node previous) {
            this.previous = previous;
    }
    
    /**
     * Set the nodes data to something new.
     * @param new data to put in the node.
     */
    public void setData(T data) {
        this.data = data;
    }
    
    /**
     * Get the previous node.
     * @return the previous node.
     */
    public Node<T> getPrevious() {
        return previous;
    }
    
    /**
     * Get the next node.
     * @return the next node.
     */
    public Node<T> getNext() {
        return next;
    }
    
    /**
     * @return the data stored in the node.
     */
    public T getData() {
        return data;
    }
}
