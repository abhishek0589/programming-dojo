package com.abhishek.dojo.string;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
	
	class Solution {
		
	    //n- positional indexing
	    public List<List<String>> groupAnagrams(String[] strs) {
	        HashMap<String, List<String>> map = new HashMap<>();
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
	        return new ArrayList<List<String>>(map.values());
	    }
	    
	 // nlogn- sorting
	    public List<List<String>> groupAnagrams1(String[] strs) {
	        HashMap<String, List<String>> map = new HashMap<>();
	        for (String word: strs){
	            char[] chars = word.toCharArray();
	            // sorting changes original data structure
	            Arrays.sort(chars);
	            // short for converting character array to string
	            String key = String.valueOf(chars);
	            if (!map.containsKey(key)){
	                map.put(key, new ArrayList<String>());
	            }
	            // directly add value to the value, no fancy xtra steps
	            map.get(key).add(word);
	        }
	        // create list of lists
	        return new ArrayList<List<String>>(map.values());
	    }
	    
	}
}
