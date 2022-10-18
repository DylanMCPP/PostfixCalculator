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
    private int MAX_CAPACITY = 10000; //prevents the stack from being initialized above hardware memory capacity, causing a potential crash and data loss
    
    public ArrayStack() {
        this(defaultSize);
    }

    public ArrayStack(int size) {
        if (size < 0)
            throw new NegativeArraySizeException("Attempted to create a stack of a negative size.");
        if (size > MAX_CAPACITY)
            throw new IllegalArgumentException("Attempted to create a stack larger than the maximum allowed size.");
        @SuppressWarnings("unchecked")
        T[] tempStack = (T[])new Object[size]; //cast is okay because all values in new array are null references
        stack = tempStack;
        top = -1;
        integrityOK = true;
    }

    //internal method that checks to make sure the stack was properly initiated before operating on it
    private void checkIntegrity() {
        if (!integrityOK)
            throw new SecurityException("ArrayStack object is corrupt.");
    }

    public void push(T inp) {
        checkIntegrity();
        if (top == stack.length) {
            if (2*stack.length <= MAX_CAPACITY) {
                stack = Arrays.copyOf(stack, 2*stack.length);
            } else
                throw new IllegalStateException("ArrayStack size limit reached: resized array would exceed the maximum allowed size.");
        } 
        stack[++top] = inp;
    }

    public T pop() {
        checkIntegrity();
        if (this.isEmpty())
            throw new IllegalStateException("Attempted to pop from an empty stack"); //to avoid crash from nullPointerException
        T entry = stack[top];
        stack[top--] = null;
        return entry;
    }

    public T peek() {
        checkIntegrity();
        if (this.isEmpty())
            throw new IllegalStateException("Attempted to pop from an empty stack"); //to avoid crash from nullPointerException
        return stack[top];
    }

    public boolean isEmpty() {
        return (top < 0);
    }

    public void clear() {
        for (int i = 0; i <= top; i++) { //no enhanced loop to avoid wasting time on empty references
            stack[i] = null; 
        }
        top = -1;
    }
}
