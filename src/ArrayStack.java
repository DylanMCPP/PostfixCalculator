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
import java.util.Arrays;
public class ArrayStack<T> implements Stack<T> {

    private int top;
    private T[] stack;
    private static final int defaultSize = 100;
    private boolean integrityOK = false;
    private int MAX_CAPACITY = 10000;
    
    public ArrayStack() {
        this(defaultSize);
    }

    public ArrayStack(int size) {
        if (size < 0)
            throw new NegativeArraySizeException("Attempted to create a stack of a negative size.");
        if (size > MAX_CAPACITY)
            throw new IllegalArgumentException("Attempted to create a stack larger than the maximum allowed size.");
        @SuppressWarnings("unchecked")
        T[] tempStack = (T[])new Object[size];
        stack = tempStack;
        top = -1;
        integrityOK = true;
    }

    private void checkIntegrity() {
        if (!integrityOK)
            throw new SecurityException("ArrayStack object is corrupt.");
    }

    public void push(T inp) {
        checkIntegrity();
        if (inp == null)
            throw new NullPointerException("Attempted to add a null reference to the stack.");
        if (top == stack.length) {
            if (2*stack.length <= MAX_CAPACITY) {
                stack = Arrays.copyOf(stack, 2*stack.length);
            } else
                throw new IllegalArgumentException("ArrayStack size limit reached: resized array would exceed the maximum allowed size.");
        }
        
        stack[++top] = inp;
    }

    public T pop() {
        @SuppressWarnings("unchecked")
        T result = (T)"hello";
        return result;
    }

    public T peek() {
        @SuppressWarnings("unchecked")
        T result = (T)"hello";
        return result;
    }

    public boolean isEmpty() {
        return false;
    }

    public void clear() {

    }
}
