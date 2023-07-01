package com.abhishek.dojo.slidingwindow;

import java.util.HashMap;
import java.util.Map;

//bruteforce approach- scan source string starting with window size of target string.
//if not, increment window size by one and search again
//keep repeating this process

//better approach- fast and slow pointer approach - sliding window solution

public class MinimumWindowSubstring {
	
	public static void main(String[] args) {
		
		MinimumWindowSubstring m = new MinimumWindowSubstring();
		System.out.println(m.getMinimumWindowSubstring("ADOBECODEBPANC", "ABC")); //5
		System.out.println(m.getMinimumWindowSubstring("ADOBECODEBANC", "ABC")); //4
		System.out.println(m.getMinimumWindowSubstring("ADOBECODEBAC", "ABC")); //3
	}

	public int getMinimumWindowSubstring(String s, String t) {
		
		int[] shortest = new int[] { 0, Integer.MAX_VALUE };
		Map<Character, Integer> count = new HashMap<>();
		int missingCharacters = t.length();
		int slow = 0;
		// create the counts hash table
		for (int i = 0; i < t.length(); i++)
			count.put(t.charAt(i), 0);
		
		for (int fast = 0; fast < s.length(); fast++) {// check if character at fast index is incounts hash
			
			char charAtFast = s.charAt(fast);
			if (count.containsKey(charAtFast)) { // if you haven't seen that character before
				if (count.get(charAtFast) == 0)
					missingCharacters--;
				count.put(charAtFast, count.getOrDefault(charAtFast, 0) + 1);
			}
			
			// would execute first when you have got one full match for the first time
			// shrink window until you have an incomplete set
			while (missingCharacters == 0) {
				// updates result range if smaller than previous range
				if ((fast - slow) < (shortest[1] - shortest[0])) {
					shortest[0] = slow;
					shortest[1] = fast;
				}
				char charAtSlow = s.charAt(slow);
				if (count.containsKey(charAtSlow)) {
					count.put(charAtSlow, count.getOrDefault(charAtSlow, 0) - 1);
					if (count.getOrDefault(charAtSlow, 0) == 0)
						missingCharacters += 1;
				}
				slow++;
			}
		}
		
		return shortest[1] == Integer.MAX_VALUE ? 0 : shortest[1] - shortest[0] + 1;
	}
}
