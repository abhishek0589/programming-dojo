package com.abhishek.dojo.design;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaxStack {
    private Deque<Integer> stack = new ArrayDeque<>();
    private Deque<Integer> maxesStack = new ArrayDeque<>();
    // Add a new item to the top of our stack. If the item is greater
    // than or equal to the last item in maxesStack, it's
    // the new max! So we'll add it to maxesStack.
    public void push(int item) {
        stack.push(item);
        if (maxesStack.isEmpty() || item >= maxesStack.peek()) {
            maxesStack.push(item);
        }
    }
    // Remove and return the top item from our stack. If it equals
    // the top item in maxesStack, they must have been pushed in together.
    // So we'll pop it out of maxesStack too.
    public int pop() {
        int item = stack.pop();
        if (item == maxesStack.peek()) {
            maxesStack.pop();
        }
        return item;
    }
    // The last item in maxesStack is the max item in our stack.
    public int getMax() {
        return maxesStack.peek();
    }
}

