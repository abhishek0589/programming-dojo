package com.abhishek.dojo.stack;
import java.util.Stack;

/** 
 * key things to remember-
 * 
 * 1. Data structure- 
 * 
 * 		1. Stacks
 * 		2. String builder
 * 
 * 2. Logic-
 * 
 * 		1. Maintain two stacks (one for operand and other for operator) and a string builder to store single/multidigit operands
 
 * 		2. In process method-
 * 				1. Check whether number is empty- Extract number from string builder and push to operand
 * 				2. Check whether peek in operand is open bracket, if no then there must be either plus or minus operator
 * 				3. If peeking operator is open bracket then dont calculate anything
 * 				4. Call calculate method and push the result to the operand
 
 * 		3. Evaluate expression at 3 instances-
 * 				1. When closing bracket is observed- Process the expression before ) sign and pop open bracket
 * 				2. When + or - sign is observed- Process the expression before + or - sign.
 * 				3. When wile iteration is done and you exit from loop- Take leftover from number string and unless operator stack is empty

 * 		4. When you calculate- Pass operands and pop operator
 * 
 * 3. Runtime complexity
 * 
 * 4. Space complexity
 * 
*/

public class BasicCalculator {
	public static void main(String[] args) {
		BasicCalculator bc = new BasicCalculator();
		// System.out.println(bc.calculate("(1+(2-3)+3"));
		System.out.println(bc.calculate("1+(2-3)+3"));
	}

	public int calculate(String s) {
		if (s == null || s.length() == 0) {
			throw new IllegalArgumentException("Invalid args");
		}
		s = s.trim();
		int i = 0;
		Stack<Character> operators = new Stack<>();
		Stack<Integer> operands = new Stack<>();
		StringBuilder number = new StringBuilder();
		// while loop-> // 2 + (1+1+1) +2 -> 2+3+2
		// by the end while loop has processed elements inside
		while (i < s.length()) {
			char c = s.charAt(i);
			if (Character.isDigit(c)) {
				number.append(c);
			} else if (c == '(') {
				operators.push(c);
			} else if (c == ')') {
				// Calculated values are pushed back on operand
				if (number.length() != 0) {
					operands.push(Integer.parseInt(number.toString()));
					number = new StringBuilder();
				}
				if (!operators.isEmpty() && operators.peek() != '(') {
					operands.push(this.calculateValue(operands, operators.pop()));
				}
				// Expression evaluation is complete, we can now pop left bracket (xyz) -> xyz
				if (!operators.isEmpty()) {
					operators.pop();
				}
			} else if (c == '+' || c == '-') {
				// Push the number to operand stack
				if (number.length() != 0) {
					operands.push(Integer.parseInt(number.toString()));
					number = new StringBuilder();
				}
				if (!operators.isEmpty() && operators.peek() != '(') {
					operands.push(this.calculateValue(operands, operators.pop()));
				}
				operators.push(c);
			}
			i++;
		}
		// process outermost elements not inside any bracket
		// 2 + 3 +2
		if (number.length() != 0) {
			operands.push(Integer.parseInt(number.toString()));
		}
		while (!operators.isEmpty()) {
			operands.push(this.calculateValue(operands, operators.pop()));
		}
		return operands.pop();
	}

	private int calculateValue(Stack<Integer> operands, char operator) {
		// notice the sequence here
		Integer o2 = operands.pop();
		Integer o1 = operands.pop();
		if (operator == '+') {
			System.out.println(o1 + "+" + o2);
			return o1 + o2;
		}
		if (operator == '-') {
			System.out.println(o1 + "-" + o2);
			return o1 - o2;
		} else {
			throw new IllegalArgumentException();
		}
	}
}
