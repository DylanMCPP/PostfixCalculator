// 
//  Name:   Michalak, Dylan
//  Project:  # 3
//  Due:        10/19/2022
//  Course:  cs-2400-01-f22 
// 
//  Description: 
//    A java class that converts infix arithmetic expressions to postfix and calculates
//    their resulting value, using a Stack ADT implemented with a resizeable array.
// 
public interface Stack<T> {
    
    /**
     * Adds an entry to the top of the stack
     * @param inp the entry being added
     * @throws NullPointerException if the caller tries to add a null reference to the stack
     */
    public void push(T inp);

    /**
     * Removes an entry from the top of the stack and returns it
     * @return the entry at the top of the stack
     * @throws EmptyStackException if the stack is empty
     */
    public T pop();

    /**
     * Returns the entry at the top of the stack without removing it
     * @return the entry at the top of the stack
     * @throws EmptyStackException if the stack is empty
     */
    public T peek();

    /**
     * Returns whether or not the stack is empty
     * @return true if empty, otherwise false
     */
    public boolean isEmpty();

    /**
     * Removes all entries from the stack
     */
    public void clear();
}
