package com.abhishek.dojo.string;
// https://leetcode.com/problems/longest-palindromic-substring/
public class LongestPalindromicString {
	
	public static void main(String[] args) {
		LongestPalindromicString l = new LongestPalindromicString();
		System.out.println(l.longestPalindrome("helloklolkhello"));
	}
	
	public String longestPalindrome(String s) {
        if (s.length() == 0) return "";
        if (s.length() == 1) return s;
        
        String longest = "";
        for (int i = 0; i < s.length()-1; i++){
            String test1 = helper(s,i,i);
            String test2 = helper(s,i,i+1);
            if (longest.length() < Math.max(test1.length(), test2.length()))
                longest = test1.length() > test2.length() ? test1 : test2;
        }
        return longest;
    }
    
    public String helper(String s, int i, int j){
        String palindrome = "";
        while (i >=0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            palindrome = s.substring(i,j+1);
            i--;
            j++;
        }
        return palindrome;
    }
}
