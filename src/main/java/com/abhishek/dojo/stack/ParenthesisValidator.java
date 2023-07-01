package com.abhishek.dojo.stack;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class ParenthesisValidator {
	public static void main(String[] args) {
		System.out.println(isValidString());
	}

	private static boolean isValidString() {
		String s = "[{}]";
		Set<Character> openers = new HashSet<>();
		openers.add('[');
		openers.add('{');

		HashMap<Character, Character> clsVsOpn = new HashMap<>();
		clsVsOpn.put(']', '[');
		clsVsOpn.put('}', '{');

		Stack<Character> stack = new Stack<>();

		for (Character ch : s.toCharArray()) {
			if (openers.contains(ch)) {
				stack.push(ch);
			} else {
				Character actualOpener = stack.pop();
				Character expectedOpener = clsVsOpn.get(ch);
				if (!actualOpener.equals(expectedOpener)) {
					return false;
				}
			}
		}
		if (!stack.isEmpty()) {
			return false;
		}

		return true;
	}
}
