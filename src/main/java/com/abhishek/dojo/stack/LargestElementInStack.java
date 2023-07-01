package com.abhishek.dojo.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class LargestElementInStack {
	
	Deque<Integer> stack = new ArrayDeque<Integer>();
	Deque<Integer> tracker = new ArrayDeque<Integer>();
	
	public static void main(String[] args) {
		LargestElementInStack test = new LargestElementInStack();
		test.push(5);
		test.push(7);
		test.push(2);
		test.push(11);
		test.push(1);
		
		System.out.println(test.getMax());
	}
	
	public void push(int item) {
		stack.push(item);
		if (tracker.isEmpty() || item > tracker.peek()) {
			tracker.push(item);
		}
	}
	
	public void pop() {
		int item = stack.pop();
		if (stack.peek() == item) {
			stack.pop();
		}
	}
	
	public int getMax() {
		return tracker.peek();
	}
}