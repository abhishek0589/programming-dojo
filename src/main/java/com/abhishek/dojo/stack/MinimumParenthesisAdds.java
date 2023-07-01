package com.abhishek.dojo.stack;

import java.util.Stack;

/*
921. Minimum Add to Make Parentheses Valid- https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/
Given a string S of '(' and ')' parentheses, we add the minimum number of parentheses ( '(' or ')', and in any positions ) so that the resulting parentheses string is valid.
Formally, a parentheses string is valid if and only if:
It is the empty string, or
It can be written as AB (A concatenated with B), where A and B are valid strings, or
It can be written as (A), where A is a valid string.
Given a parentheses string, return the minimum number of parentheses we must add to make the resulting string valid.

Example 1: Input: "())"
Output: 1
Example 2: Input: "((("
Output: 3
Example 3: Input: "()"
Output: 0
Example 4: Input: "()))(("
Output: 4
Note:
S.length <= 1000
S only consists of '(' and ')' characters.
*/

public class MinimumParenthesisAdds {

	public static void main(String[] args) {
		MinimumParenthesisAdds m = new MinimumParenthesisAdds();
		System.out.println(
				m.minAddToMakeValidOptimized("()))((")
				);
		
	}

	public int minAddToMakeValidOptimized(String S) {
		int open = 0, close = 0;
		for (char brace : S.toCharArray()){
			if (brace == '('){
				open++;
			} else {
				if (open > 0){
					open--;
				} else {
					close++;
				}
			}
		}
		return open + close;
	}
	
	public int minAddToMakeValidBruteforce(String S) {
		if (S.length()==0) return 0;
	    Stack<String> s = new Stack<>();
	    int counter = 0;
	    for (String brace : S.split("")){
	        if (brace.equals("(")){
	            s.push(brace);
	            counter++;
	        } else {
	            counter += s.size() != 0 && s.pop().equals("(") ? -1 : 1;
	        }
	    }
	    return counter;
	}
}
