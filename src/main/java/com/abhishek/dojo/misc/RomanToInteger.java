package com.abhishek.dojo.misc;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class RomanToInteger {

	public static void main(String[] args) {
		String s = "IX";
		romanToInt(s);
	}

	private static int romanToInt(String s) {
		Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1); 
        map.put('V', 5); 
        map.put('X', 10);
        map.put('L', 50); 
        map.put('C', 100); 
        map.put('D', 500);
        map.put('M', 1000);
        Set<Character> reducer = new HashSet<>(Arrays.asList('I', 'X', 'C'));
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
          if (reducer.contains(s.charAt(i)) && i != s.length() - 1 &&
        		  map.get(s.charAt(i)) < map.get(s.charAt(i+1))) // pattern
              result += -map.get(s.charAt(i));
          else 
              result += map.get(s.charAt(i));
        }
        return result;
	}
	
	public int romanToInt1(String s) {
        char[] roms = new char[] { 'C', 'D', 'I', 'L', 'M',  'V', 'X'};
		int[] vals = new int[] {100, 500, 1, 50, 1000, 5, 10};
		Set<Character> reducer = new HashSet<>(Arrays.asList('I', 'X', 'C'));
		int result = 0;

		for (int i = 0; i < s.length(); i++) {
			int curIndex = Arrays.binarySearch(roms, s.charAt(i));
			if (reducer.contains(s.charAt(i)) && i != s.length() - 1 && vals[curIndex] < vals[Arrays.binarySearch(roms, s.charAt(i + 1))]) {
					result += -vals[curIndex];
			} else
				result += vals[curIndex];
		}
        return result;
    }
}
