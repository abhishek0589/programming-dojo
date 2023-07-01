package com.abhishek.dojo.string;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParenthesis {
	public static void main(String[] args) {
		ValidParenthesis v = new ValidParenthesis();
		System.out.println(v.isValid("()"));
	}
	public boolean isValid(String s) {
		if (s == null || s.length() == 0) return true;
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> openVsClose = new HashMap<>();
        openVsClose.put('(', ')');
        openVsClose.put('{', '}');
        openVsClose.put('[', ']');
        for (int i = 0; i < s.length(); i++){
            if (openVsClose.containsKey(s.charAt(i))){
                stack.push(s.charAt(i));
            } else {
            	if (stack.isEmpty()) 
            		return false;
                if (s.charAt(i) != openVsClose.get(stack.pop()))
                    return false;
                
            }
        }
        return stack.size() == 0;
    }
	
}
