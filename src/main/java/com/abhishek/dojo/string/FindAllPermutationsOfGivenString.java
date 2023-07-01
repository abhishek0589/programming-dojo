package com.abhishek.dojo.string;

import java.util.HashSet;

public class FindAllPermutationsOfGivenString {

	HashSet<String> initials = new HashSet<String>();
	HashSet<String> set = new HashSet<String>();
	HashSet<String> palindromes = new HashSet<String>();

	public static void main(String[] args) {
		FindAllPermutationsOfGivenString permutations = new FindAllPermutationsOfGivenString();
		String given = "aaa";
		String temp = "";
		for (int i = 0; i < given.length(); i++) {
			temp = temp + given.charAt(i);
			permutations.initials.add(temp);
		}

		for (String initial : permutations.initials) {
			permutations.set = new HashSet<String>();
			permutations.permute(initial, 0, initial.length());
			permutations.set.forEach(System.out::println);
			for (String x : permutations.set) {
				if (permutations.isPalindrome(x)) {
					permutations.palindromes.add(x);
				}
			}
		}
		permutations.palindromes.forEach(System.out::println);
		System.out.println(permutations.palindromes.size());
	}

	private boolean isPalindrome(String permute) {
		int l = 0;
		int r = permute.length() - 1;
		char[] givenArr = permute.toCharArray();
		while (l < r) {
			char temp = givenArr[l];
			givenArr[l] = givenArr[r];
			givenArr[r] = temp;
			l++;
			r--;
		}
		if (String.valueOf(givenArr).equals(permute)) {
			return true;
		}
		return false;
	}

	public void permute(String given, int l, int r) {
		if (l == r) {
			set.add(given);
		} else {
			for (int i = l; i < r; i++) {
				given = swap(given, l, i);
				permute(given, l + 1, r);
				given = swap(given, l, i);
			}
		}
	}

	public String swap(String given, int l, int r) {
		char[] givenArr = given.toCharArray();
		char temp = givenArr[l];
		givenArr[l] = givenArr[r];
		givenArr[r] = temp;
		return String.valueOf(givenArr);
	}

}
