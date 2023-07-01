package com.abhishek.dojo.string;

public class TotalNumberOfPalindromicStrings {
	// expand for current and current+1 index of i- i ranging from 0 to N
	// same solution is used for longest palindromic string
	public static void main(String[] args) {
		TotalNumberOfPalindromicStrings t = new TotalNumberOfPalindromicStrings();
		System.out.println(t.countSubstrings("aabaa")); // 9
	}
	
	public int countSubstrings(String s) {
		int count = 0;
		for (int i = 0; i < s.length() - 1; i++) {
			count += expandAroundCenter(s, i, i);
			count += expandAroundCenter(s, i, i+1);	
		}
		return count + 1;
	}

	public int expandAroundCenter(String s, int i, int j) {
		int count = 0;
		while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
			i--;
			j++;
			count++;
		}
		return count;
	}
}
