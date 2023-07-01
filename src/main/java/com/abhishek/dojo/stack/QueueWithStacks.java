package com.abhishek.dojo.stack;
/*
  Implement Queue using Stacks - LeetCode: https://leetcode.com/problems/implement-queue-using-stacks/

  Authorship: Credit for the code in this file goes to the authors of the
  book "Elements of Programming Interviews" by Adnan Aziz, Amit Prakash, and
  Tsung-Hsien Lee.

  This code passes all Leetcode test cases as of Feb. 4 2019
  Runtime: 54 ms, faster than 95.59% of Java online submissions for Implement Queue using Stacks.
  Memory Usage: 25.7 MB, less than 81.58% of Java online submissions for Implement Queue using Stacks.

  The video to explain this code is here: https://www.youtube.com/watch?v=Wg8IiY1LbII
 */

import java.util.Stack;

public class QueueWithStacks  {
	
	Stack<Integer> pushStack, popStack;

	//Initialize the 2 stacks and the size of the queue
	public QueueWithStacks() {
		pushStack = new Stack<>();
		popStack= new Stack<>();
	}

	//Push element to the pushStack and increase the size of the queue should be called something like "enqueue" but whatever
	public void push(int item) {
		pushStack.push(item);
	}

	// get the element from the front of the queue. should be called "dequeue" but oh well (we are conforming to the naming from Leetcode)
	public int pop() {
		// Ensure that the pop stack has an item to pop
		ensureThereAreItemsInPopStack();
		// if we now have elements to pop then pop the item.If the popStack is empty by this point then the overarching
		// queue is empty. Throw an exception seems to make the most sense. Returning
		// -1 would be misleading since that is a valid return value.
		if (!popStack.isEmpty())  return popStack.pop();
		// as per LC problem statement
		return -1;
	}

	// peek the item at the front of the queue
	public int peek() {
		// Ensure that the pop stack has an item to peek
		ensureThereAreItemsInPopStack();
		// Peek the item if the queue is not empty
		if (!popStack.isEmpty()) return popStack.peek();
		return -1;
	}

	private void ensureThereAreItemsInPopStack() {
		if (popStack.isEmpty()) {
			while (!pushStack.isEmpty()) {
				popStack.push(pushStack.pop());
			}
		}
	}
	
	public static void main(String[] args) {
		QueueWithStacks q = new QueueWithStacks();
		q.push(1);
		q.push(2);
		System.out.println(q.peek());
		System.out.println(q.pop());
	}
}


