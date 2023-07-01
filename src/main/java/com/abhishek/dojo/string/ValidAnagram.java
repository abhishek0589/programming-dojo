package com.abhishek.dojo.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ValidAnagram {
	public boolean isAnagram(String s, String t) {
		HashMap<String, List<String>> map = new HashMap<>();
		List<String> strs = Arrays.asList(s, t);
        for (String word: strs){
            // sorting changes original data structure
        	int[] positional = new int[26];
            for (int i = 0; i < word.length(); i++) {
            	positional[word.charAt(i) - 'a']++;
            }
            // short for converting character array to string
            String key = Arrays.toString(positional);
            if (!map.containsKey(key)){
                map.put(key, new ArrayList<String>());
            }
            // directly add value to the value, no fancy xtra steps
            map.get(key).add(word);
        }
        // create list of lists
        return new ArrayList<List<String>>(map.values()).size() == 1;
	}
}
