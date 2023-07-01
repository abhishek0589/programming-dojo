package com.abhishek.dojo.stack;

import java.util.LinkedList;
import java.util.Queue;

public class StackWithQueues {

	Queue<Integer> q;
	int top;

	/** Initialize your data structure here. */
	public StackWithQueues() {
		q = new LinkedList<>();
	}

	/** Push element x onto stack. */
	public void push(int x) {
		q.add(x);
		top = x;
		int size = q.size();
		// move all previously added items to end of the queue o(n)
		while (size > 1) {
			q.add(q.poll());
			size--;
		}
	}

	/** Removes the element on top of the stack and returns that element. */
	public int pop() {
		return q.poll();
	}

	/** Get the top element. */
	public int top() {
		return this.top;
	}

	/** Returns whether the stack is empty. */
	public boolean empty() {
		return q.size() == 0;
	}

	public static void main(String[] args) {
		StackWithQueues s = new StackWithQueues();
		s.push(1);
		s.push(2);
		s.push(3);
		
		System.out.println(s.pop());
		System.out.println(s.pop());
		
	}
}

