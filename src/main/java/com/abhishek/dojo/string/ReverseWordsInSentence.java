package com.abhishek.dojo.string;
import static com.abhishek.dojo.string.ReverseString.reverse;
// https://leetcode.com/problems/reverse-words-in-a-string/
public class ReverseWordsInSentence {
	
	// cases
	// 1. Spaces in beginning and end
	// 2. More than 1 space in between words
	// 3. special checks for last word
	public static void main(String[] args) {
		ReverseWordsInSentence r = new ReverseWordsInSentence();
		System.out.println(r.reverseSentence("the sky is blue")); // blue is sky the
	}

	private String reverseSentence(String s) {
		s = s.replaceAll(" +", " ").trim();
        if (s == null || s.length() <= 1) return s;
        s = ReverseString.reverse(s);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ' ') {
				sb.append(reverse(s.substring(sb.length(), i))).append(' ');
			} else if (i == s.length() - 1){
				sb.append(reverse(s.substring(sb.length(), s.length())));
            }
		}
		return sb.toString();
	}
}
