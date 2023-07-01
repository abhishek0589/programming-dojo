package com.abhishek.dojo.stack;

import java.util.Stack;


// ********HOW TO SOLVE?*********

// Apply bodmas- 
// if stack has pending/peeking *, / ops and current ops are + and - then process
// if stack has pendgin/peeking +,- ops and current ops are *, - then dont process
// if stack has consecutive plus, minus, multiple and divide then process



public class BasicCalculatorII {
	public static void main(String[] args) {
		BasicCalculatorII bs = new BasicCalculatorII();
		System.out.println(bs.calculate("5-3-2*3*3*3/5+10"));
	}
	
	 public int calculate(String s) {
	        if (s == null || s.length() == 0) {
	            throw new IllegalArgumentException("invalid input");
	        }
	        s = s.trim();
	        int i = 0;
	        // even though leetcode does not have this use case System.out.println(ins.calculate("0-2147483648")); // -2147483648
	        // It can still pass with Integer, but use long for overflow case in general
	        Stack<Long> operands = new Stack<>();
	        Stack<Character> operators = new Stack<>();
	        StringBuilder number = new StringBuilder(); // deal with non single digit numbers

	        while (i < s.length()) {
	            char c = s.charAt(i);
	            if (Character.isDigit(c)) {
	                number.append(c);
	            } else if (c == '+' || c == '-' || c == '*' || c == '/') {
	                if (number.length() != 0) {
	                    operands.push(Long.parseLong(number.toString()));
	                    number = new StringBuilder();
	                }
	                // Basically based on different priority of operators
	                if (operators.isEmpty()) {
	                    operators.push(c);
	                } else if (!operators.isEmpty() && (c == '*' || c == '/')  && (operators.peek() == '+' || operators.peek() == '-')) {
	                    // do nothing, keep pushing because */ has higher priority than +-
	                    operators.push(c);
	                } else if (!operators.isEmpty() && (c == '+' || c == '-')  && (operators.peek() == '*' || operators.peek() == '/')) {
	                    // calculate all previous expressions
	                    while (!operators.isEmpty()) {
	                        operands.push(this.calculateValue(operands, operators.pop()));
	                    }
	                    operators.push(c);
	                } else {
	                    // only calculating one step, for */, and +- case, one step is fine
	                    operands.push(this.calculateValue(operands, operators.pop()));
	                    operators.push(c);
	                }
	            }
	            i++;
	        }

	        if (number.length() != 0) {
	            operands.push(Long.parseLong(number.toString()));
	        }
	        // for "3+2*2" case that's why we need a while loop
	        while (!operators.isEmpty()) {
	            operands.push(this.calculateValue(operands, operators.pop()));
	        }

	        return (int)operands.pop().longValue(); // Since it is Long, an object can't be cast to primitive, .longValue first then cast
	    }


	    private long calculateValue(Stack<Long> operands, char op) {
	        long o2 = operands.pop();
	        long o1 = operands.pop();

	        if (op == '+') {
	            return o1 + o2;
	        } else if (op == '-') {
	            return o1 - o2;
	        } else if (op == '*') {
	            return o1 * o2;
	        } else if (op == '/') {
	            return o1 / o2;
	        } else {
	            throw new IllegalArgumentException("invalid op!");
	        }
	    }
}
