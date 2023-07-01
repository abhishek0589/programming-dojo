package com.abhishek.dojo.string;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class PermutationPalindrome {

	public static void main(String[] args) {
		
	}
	
	public boolean isPalindrome(String sample) {
		char[] letters = sample.toCharArray();
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < letters.length; i++) {
			if (map.containsKey(letters[i])) {
				int value = map.get(letters[i]);
				map.put(letters[i], ++value);
			} else {
				map.put(letters[i], 1);
			}
		}
		Set<Character> keySet = map.keySet();
		int count = 0;
		for (Iterator<Character> iterator = keySet.iterator(); iterator.hasNext();) {
			Character character = (Character) iterator.next();
			if (map.get(character) % 2 != 0) {
				count++;
			}
		}
		if (count > 1) {
			return false;
		} else {
			return true;
		}
	}
}
