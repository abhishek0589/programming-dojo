package com.abhishek.dojo.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreakII {
	
	public static void main(String[] args) {
		WordBreakII w = new WordBreakII();
		 w.wordBreak("catsanddog", Arrays.asList("cat","cats","and","sand","dog"));
		 // w.wordBreak("pineapplepenapple", Arrays.asList("apple", "pen", "applepen", "pine", "pineapple"));
	}

	public List<List<String>> wordBreak(String s, List<String> wordDict) {
        List<List<String>> result = new ArrayList<>();
        word_Break(result, new ArrayList<String>(), s, new HashSet<>(wordDict), 0);
        return result;
    }
    
    public void word_Break(List<List<String>> list, List<String> tempList, String s, Set<String> wordDict, int start) {
        if (start == s.length()) {
        	list.add(new ArrayList<>(tempList));
        	return;
        }
        for (int end = start + 1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(start, end))) {
            	tempList.add(s.substring(start, end));
            	word_Break(list, tempList, s, wordDict, end);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
	
}
