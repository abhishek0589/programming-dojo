package com.abhishek.dojo.string;

import java.util.HashSet;
import java.util.Set;

public class ValidPalindrome {

	public static void main(String[] args) {
		System.out.println(new ValidPalindrome().isPalindromeBetter("A man, a plan, a canal: Panama"));
		System.out.println(new ValidPalindrome().isPalindrome("A man, a plan, a canal: Panama"));
	}

	public boolean isPalindromeBetter(String s) {
		if(s == null || s.length() <=1) return true;
		StringBuilder sb = new StringBuilder();
		for (char c : s.toLowerCase().toCharArray()) if(Character.isLetter(c) || Character.isDigit(c)) sb.append(c);
		// track characters we've seen an odd number of times
		Set<Character> unpairedCharacters = new HashSet<>();
		for (char c : sb.toString().toCharArray()) {
			if (!unpairedCharacters.add(c)) unpairedCharacters.remove(c);
		}
		// the string has a palindrome permutation if it
		// has one or zero characters without a pair
		return unpairedCharacters.size() <= 1;
	}

	public boolean isPalindrome(String s) {
		if(s == null || s.length() <=1) return true;
		StringBuilder sb = new StringBuilder();
		for (char c : s.toCharArray()) if(Character.isLetter(c) || Character.isDigit(c)) sb.append(c);
		return sb.toString().toLowerCase().equals(ReverseString.reverse(sb.toString().toLowerCase()));
	}
}
