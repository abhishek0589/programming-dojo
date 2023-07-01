package com.abhishek.dojo.stack;

import java.util.Stack;

public class BasicCalculatorIII {
	
	public static void main(String[] args) {
		BasicCalculatorIII bs = new BasicCalculatorIII();
		bs.calculate("1 - (-7)");
	}
	
	public int calculate(String s) {
        if (s == null || s.length() == 0) {
            throw new IllegalArgumentException("invalid input");
        }
        s = s.trim().replace(" ", "");
        int i = 0;
        Stack<Long> operands = new Stack<>();
        Stack<Character> operators = new Stack<>();
        StringBuilder number = new StringBuilder(); // deal with non single digit numbers

        while (i < s.length()) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                number.append(c);
            } else if (this.isValidOperator(c)) {
                if (number.length() != 0) {
                    operands.push(Long.parseLong(number.toString()));
                    number = new StringBuilder();
                }
                // Basically based on different priority of operators
                if (operators.isEmpty()) {
                    // it says it only contains non-negative integer, but now we have "-1 + 2", "-(2+3)*4"
                    operators.push(c);
                } else if (!operators.isEmpty() && (c == '*' || c == '/') && (operators.peek() == '+' || operators.peek() == '-')) {
                    // do nothing, keep pushing because */ has higher priority than +-
                    operators.push(c);
                } else if (!operators.isEmpty() && (c == '+' || c == '-') && (operators.peek() == '*' || operators.peek() == '/')) {
                    // calculate all previous expressions till hit the left bracket
                    while (!operators.isEmpty() && operators.peek() != '(') {
                        operands.push(this.calculateValue(operands, operators.pop()));
                    }
                    operators.push(c);
                } else if (c == '(') {
                    operators.push(c);
                } 
                // notice the sequence of open and close bracket 
                else if (c == ')') {
                	while (!operators.isEmpty() && operators.peek() != '(') {
                        operands.push(this.calculateValue(operands, operators.pop()));
                    }
                    operators.pop(); // pop out the left (
                } else {
                    // for normal +- with previous +- || */ with previous */ case just calculate 1 step ahead
                    // but because 15 / 3 / 5 should be 1, but it won't work 3 / 5 = 0, so we have to calculate 
                    // every time we can calculate and get result 
                    if (!operators.isEmpty() && operators.peek() != '(') {
                        operands.push(this.calculateValue(operands, operators.pop()));
                    }
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
        return (int)operands.pop().longValue();
    }

    private boolean isValidOperator(char op) {
        if (op == '+' || op == '-' || op == '*' || op == '/' || op == '(' || op == ')') {
            return true;
        }
        return false;
    }

    private long calculateValue(Stack<Long> operands, char op) {
    	if (operands.size() == 1 && op == '-') {
    		return -operands.pop();
    	} else {
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
                throw new IllegalArgumentException("invalid op! " + op);
            }
    	}
    }
}