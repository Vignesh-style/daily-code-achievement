package org.victor.stack;

import java.util.Stack;

/**
 * Scaler problem :: Implement a First In First Out (FIFO) queue using stacks only.
 * The implemented queue should support all the functions of a normal queue (push, peek, pop, and empty).

 * Implement the UserQueue class:
 * void push(int X) : Pushes element X to the back of the queue.
 * int pop() : Removes the element from the front of the queue and returns it.
 * int peek() : Returns the element at the front of the queue.
 * boolean empty() : Returns true if the queue is empty, false otherwise.

 * NOTES:

 * You must use only standard operations of a stack, which means only push to top, peek/pop from top, size, and is empty operations are valid.
 * Depending on your language, the stack may not be supported natively. You may simulate a stack using a list or deque (double-ended queue) as long as you use only a stack's standard operations.
 * */

public class QueueUsingStack {

    static Stack<Integer> pushStack = new Stack<>();
    static Stack<Integer> popStack = new Stack<>();

    static void push(int X) {
        pushStack.push(X);
    }

    static int pop() {

        if (!popStack.isEmpty())
            return popStack.pop();

        else if (pushStack.empty())
            return -1;

        while (!pushStack.isEmpty()){
            popStack.push(pushStack.pop());
        }

        return popStack.pop();

    }

    static int peek() {

        if (!popStack.isEmpty())
            return popStack.peek();

        else if (pushStack.empty())
            return -1;

        while (!pushStack.isEmpty()){
            popStack.push(pushStack.pop());
        }

        return popStack.peek();

    }

    static boolean empty() {

        return pushStack.empty() && popStack.empty();

    }
}
