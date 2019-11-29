import java.util.EmptyStackException;

/**
 * A Stack interface.
 * 
 * @author (Mahir Hambiralovic)
 * @version (23-01-2019)
 */
public interface Stack<T> {
    /**
     * Adds the element to the top of the stack
     * @param elem
     */
    void push(T elem);

    /**
     *  Removes and returns the top element in the stack, that is the element that was last added to the stack.
     * @return top element
     * @throws EmptyStackException if stack is empty
     */
    T pop() throws EmptyStackException;

    /**
     * Returns the top element in the stack without removing it.
     * @return top element
     * @throws EmptyStackException if stack is empty
     */
    T top();

    /**
     * Returns the number of elements in the stack.
     * @return number of elements in the stack
     */
    int size();

    /**
     * Returns true if the stack is empty.
     * @return boolean true if stack is empty
     */
    boolean isEmpty();
}
