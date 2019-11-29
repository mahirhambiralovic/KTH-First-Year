import java.util.EmptyStackException;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * A singly linked list, implementing the StackM interface.
 * 
 * @author (Mahir Hambiralovic)
 * @version (23-01-2019)
 */
public class LinkedList<T> implements Stack<T>{

    private ListElement<T> first;   // First element in list.
    private ListElement<T> last;    // Last element in list.
    private int size;               // Number of elements in list.


    /**
     * A list element.
     */
    public static class ListElement<T> {
        public T data;
        public ListElement<T> next;

        public ListElement(T data) {
            this.data = data;
            this.next = null;
        }
    }

    /**
     * Creates an empty list.
     */
    public LinkedList() {
        first = null;
        last = null;
        size = 0;
    }

            /**
             * Methods implementing Stack interface
             */

    /**
     * Adds the element to the top of the stack
     * @param elem
     */
    public void push(T elem){ addFirst(elem); }

    /**
     *  Removes and returns the top element in the stack, that is the element that was last added to the stack.
     * @return top element
     * @throws EmptyStackException if stack is empty
     */
    public T pop() throws EmptyStackException{
        T data = removeFirst();
        return data;
    }

    /**
     * Returns the top element in the stack without removing it.
     * @return top element
     * @throws EmptyStackException if stack is empty
     */
    public T top() throws EmptyStackException {
        T data = getFirst();
        return data;
    }


            /**
             * LinkedList methods
             */

    /**
     * Inserts the given element at the beginning of this list.
     *
     * @param element An element to insert into the list.
     */
    public void addFirst(T element) {
        // Create a new ListElement containing element
        ListElement le = new ListElement(element);

        // Check if list is empty
        if(isEmpty()){
            // Make le the first and last element
            first = le;
            last = le;
        }
        else if(this.size() == 1){
            first = le;
            first.next = last;
        }
        else{
            // Have le point to first
            le.next = first;
            // Make le first
            first = le;
        }
        size++;
    }

    /**
     * Inserts the given element at the end of this list.
     *
     * @param element An element to insert into the list.
     */
    public void addLast(T element) {
        // Create a new ListElement containing element
        ListElement le = new ListElement(element);

        // Check if list is empty
        if(isEmpty()){
            // Make le the first and last element
            first = le;
            last = le;
        }
        // If size is one, first pointer must be updated
        else if(this.size() == 1){
            first.next = le;
            last = le;
        }
        else{
            // Have last point to le
            last.next = le;
            last = le;
        }
        size++;
    }

    /**
     * @return The head of the list.
     * @throws NoSuchElementException if the list is empty.
     */
    public T getFirst() throws NoSuchElementException{
        if(this.isEmpty()){
            throw new NoSuchElementException();
        }
        return first.data;
    }

    /**
     * @return The tail of the list.
     * @throws NoSuchElementException if the list is empty.
     */
    public T getLast() throws NoSuchElementException{
        if(this.isEmpty()){
            throw new NoSuchElementException();
        }
        return last.data;
    }

    /**
     * Returns an element from a specified index.
     *
     * @param index A list index.
     * @return The element at the specified index.
     * @throws IndexOutOfBoundsException if the index is out of bounds.
     */
    public T get(int index) {
        if(isEmpty()){
            throw new IndexOutOfBoundsException();
        }
        else if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
        else {
            ListElement le = first;

            // Run through from first to next index times
            for (int i = 0; i < index; i++) {
                le = le.next;
            }
            return (T) le.data;
        }
    }

    /**
     * Removes the first element from the list.
     *
     * @return The removed element.
     * @throws NoSuchElementException if the list is empty.
     */
    public T removeFirst() {
        // Check if list is empty
        if(this.isEmpty()){
            throw new NoSuchElementException();
        }
        // If only one element in list
        else if(this.size() == 1){
            T data = first.data;
            first = null;
            last = null;
            size--;
            return data;
        }
        // If twoone element in list, last must also be updated
        else if(this.size() == 2){
            T data = first.data;
            first = last;
            last = first;
            size--;
            return data;
        }
        else {
            // Remove first element and replace it with second, returning its data
            ListElement second = first.next;
            T data = first.data;
            first = second;
            size--;
            return data;
        }
    }

    /**
     * Removes all of the elements from the list.
     */
    public void clear() {
        first = null;
        last = null;
        size = 0;
    }

    /**
     * @return The number of elements in the list.
     */
    public int size() {
        return size;
    }

    /**
     * Note that by definition, the list is empty if both first and last
     * are null, regardless of what value the size field holds (it should
     * be 0, otherwise something is wrong).
     *
     * @return <code>true</code> if this list contains no elements.
     */
    public boolean isEmpty() {
        return first == null && last == null;
    }

    /**
     * Creates a string representation of this list. The string
     * representation consists of a list of the elements enclosed in
     * square brackets ("[]"). Adjacent elements are separated by the
     * characters ", " (comma and space). Elements are converted to
     * strings by the method toString() inherited from Object.
     *
     * Examples:
     *  "[1, 4, 2, 3, 44]"
     *  "[]"
     *
     * @return A string representing the list.
     */
    public String toString() {
        StringBuilder s = new StringBuilder("[");

        // Add all elements to s
        for(int i = 0; i < size(); i++){
            s.append(get(i));
            if(i != size() -1){
                s.append(", ");
            }
        }
        s.append("]");
        return s.toString();
    }
}
