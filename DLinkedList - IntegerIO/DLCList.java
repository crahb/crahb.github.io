import java.util.List;
/**
 * Write a description of class DLCList here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class DLCList<T> implements IList<T>
{
    private Node<T> start;
    //private Node<T> end;
    private int size;
    /**
     * Constructor for objects of class DLCList
     */
    public DLCList()
    {
        //instance variables
        start = null;
        size = 0;
    }

    /**
     * Add new element to the end of a list.
     * @param Type to add to the list
     */
    public boolean add(T type) { 
        if(start == null) {
            start = new Node<>(type); //empty list, add first node
            //end = new Node<>(type);
        }
        else {
            Node temp = new Node<>(type, start.getPrevious(), start);
            start.getPrevious().setNext(temp);
            start.setPrevious(temp);
        }
        size++;
        return true;
    }

    /**
     * Add an element to the front of a list.
     * @param type of element to add in.
     */
    public boolean addFirst(T type) {
        if(start == null) {
            start = new Node<>(type); //empty list, add first node
        }
        else {
            Node temp = new Node<>(type, start.getPrevious(), start);
            start.getPrevious().setNext(temp);
            start.setPrevious(temp);
            start = temp;
        }
        size++;
        return true;
    }

    public boolean addLast(T type) {
        add(type);
        return true;
    }
    
    /**
     * Delete the object at the index.
     * @param index to be deleted.
     */
    public void delete(int index) {
        Node nodeToDelete = getNodeAt(index);
        if(nodeToDelete != null) {
            nodeToDelete.getPrevious().setNext(nodeToDelete.getNext());
            nodeToDelete.getNext().setNext(nodeToDelete.getPrevious());
            size--;
        }
        else{
                System.out.println("No node at specified index"); //for testing.
        }
    }
    
    /**
     * Delete the first item in the DLCList.
     */
    public void deleteFirst() {
        if(start == null) {
            //empty list, leave if/else
        }
        else if(start.getPrevious() == start) {
            start = null; //set start to null if its the only object in the list.
        }
        else {
            start.getNext().setPrevious(start.getPrevious());
            start.getPrevious().setNext(start.getNext());
            start = start.getNext();
            size--;
        }
    }

    /**
     * Delete the last item in the DLCList.
     */
    public void deleteLast() {
        if(start == null) {
            //empty list, nothing to delete
        }
        else if(start.getPrevious() == start) {
            start = null; //set start to null if its the only object in the list.
        }
        else {
            Node newPrevious = start.getPrevious().getPrevious(); //the new previous for start
            start.setPrevious(newPrevious);
            start.getPrevious().setNext(start); //setting the new previous' next to start
            size--;
        }
    }

    /**
     * Returns the size of the DLCList.
     */
    public int size() {
        return size;
    }

    /**
     * Clear the entire DLCList. removes nodes and data. Potentially inefficient
     */
    public void clear() {
        start = null;
        size = 0;
    }

    /**n
     * Check if the list contains a specific data type.
     * @return true if it contains the same datatype thrown in the parameter.
     */
    public boolean contains(T data) { 
        //boolean contains = false;
        /*for(int i = 0; i < size(); i++) {
            T dataToCheck = get(i);
            if(dataToCheck == data) {      //my original solution
                return true;
            }
        }
        return false; */
        boolean found = false;             //Better way.
        int index = 0;
        while(index < size && !found) {
            if(get(index) == data) {     
                found = true;
            }
            index ++;
        }
        return found;
    }


    /**
     * Get the instance's reference stored at the specified index.
     * @param index to get the object at.
     * @return the data at that parameter.
     */
    public T get(int index) {
        return getNodeAt(index).getData();
    }
    
    /**
     * Get the first item in the list.
     * @return the first item stored in the list (the reference).
     */
    @Override
    public T getFirst() {
        return start.getData();
    }
    
    /**
     * Get the last item in the list.
     * @return the last item stored in the list (the reference).
     */
    @Override
    public T getLast() {
        return start.getPrevious().getData();
    }

    /**
     * Set the specified index to a specified object.
     * @param index to send the object.
     * @param object to store at the specified index.
     */
    public void set(int index, T data) {
        Node<T> newNode = getNodeAt(index);
        newNode.setData(data);
    }

    /**
     * Insert an object into a specified index, will not overwrite the current object at this index.
     * @param index to insert object.
     * @param object to put in the list.
     */
    public void insert(int index, T data) { 
        if(index < size()) {
            Node tempNode = getNodeAt(index-1);
            Node newNode = new Node<>(data, tempNode, tempNode.getNext());
            tempNode.setNext(newNode);
            tempNode.getNext().setPrevious(newNode);
            size++;
        }
        else {
            System.out.println("No node at specified index.");
        }
    }
    
    /**
     * Get the node at the "index"
     * @param amount of times to loop.
     * @return the node at the specified index.
     */
    private Node<T> getNodeAt(int index) {
        if(index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Bad index at " + index);
        }
        
        Node tempNode = start;
        for(int i = 0; i < index; i++) { //index's are actual position here.
            tempNode = tempNode.getNext();
        }
        return tempNode;
    }
    
    /**
     * Quickly add an entire list to the DLCList.
     * Primariliy for testing (hence usage of List)
     */
    public void addAll(List<T> listToAdd) {
        for(T listItem : listToAdd) {
            add(listItem);
        }
    }
    
    public String toString() {
        String returnString = "[";
        for(int i = 0; i < size; i++) {
            if(i == size - 1) {
                returnString += get(i).toString() + "]";
            }
            else {
                returnString += get(i).toString() + ", ";
            }
        }
        if(returnString.equals("[")) {
            returnString += " ]";
        }
        return returnString;
    }
}
