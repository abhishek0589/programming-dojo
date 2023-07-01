package com.abhishek.dojo.stack;

import java.util.Stack;

public class BasicCalculator1optimized {

	// expression will not have any brackets. expression will have all possible operations (add, sub, multiply, divide)
	public static void main(String[] args) {
		BasicCalculatorIIOptimized b = new BasicCalculatorIIOptimized();
		System.out.println(b.calculate("523-3-2+5+10"));
	}

	public int calculate(String s) {
		s = s.trim().replace(" ", ""); // sanitize
		//use a single stack- just for numbers and no operators
		Stack<Integer> stack = new Stack<>();
		// tracks all operators, '+' is default operator to start with
		char op = '+'; 
		int num = 0, sum = 0; // keep sum. used in the end

		for (int i = 0; i < s.length(); i++) { // iterate over entire expression
			char c = s.charAt(i);
			if (Character.isDigit(c)) {
				num = num * 10 + c - '0';
			}
			// process expression when current item is operator- 
			// catch- use previous operator not currnent operator
			if (!Character.isDigit(c) || i == s.length() - 1) {
				if (op == '+')  	stack.push(num);
				else if (op == '-') stack.push(-num);
				num = 0; // reset num
				op = c; // update operator
			}
		}
		// add all numbers in the end
		for (int item : stack) {
			sum += item;
		}
		return sum;
	}
}
