package com.abhishek.dojo.stack;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BasicCalculatorIIIOptimized {

	public int calculate(String s) {
		s = s.trim().replace(" ", "");
		Queue<Character> q = new LinkedList<>();
		//use queue to evaluate inner expressions
		for (char c : s.toCharArray()) q.offer(c);
		// why x- this is needed because,if lets say last letter is digit 
		// then only num is calculated and expression is not processed
		// with a non digit letter (like x) entire loop runs one more time
		// and processes last number
		q.offer('x'); 
		return helper(q);
	}
	//"5-((3-2)*3*3*3)/5+10"
	private int helper(Queue<Character> q) {
		//use a single stack- just for numbers and no operators
		Stack<Integer> stack = new Stack<>();
		// tracks all operators, '+' is default operator to start with
		char op = '+'; int num = 0, sum = 0;
		while (!q.isEmpty()) {
			char c = q.poll();
			//collect numbers
			if (c >= '0' && c <= '9')  num = num * 10 + c - '0';
			//recursively call the program in case another open bracket is found
			//****NOTE- Recursive call returns the number back*** not just a non returning recursion
			else if (c == '(') num = helper(q); 
			else {
				if (op == '+') stack.push(num);
				if (op == '-') stack.push(-num);
				if (op == '*') stack.push(stack.pop() * num);
				if (op == '/') stack.push(stack.pop() / num);
				if (c == ')') break;
				//note- num is reset and operator is added to variables
				num = 0;
				op = c;
			}
		}
		for (int item : stack) sum += item;
		return sum;
	}
	
	public static void main(String[] args) {
		BasicCalculatorIIIOptimized b = new BasicCalculatorIIIOptimized();
		System.out.println(b.calculate("5-((3-2)*3*3*3)/5+10"));
	}
}
