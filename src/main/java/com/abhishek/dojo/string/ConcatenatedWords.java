package com.abhishek.dojo.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// exactly similar to word break problem
public class ConcatenatedWords {

	public List<String> findAllConcatenatedWordsInADict(String[] words) {
		if (words.length < 2) return new ArrayList<>();
		List<String> res = new ArrayList<>();
		Set<String> dic = new HashSet<>(Arrays.asList(words));
		dic.remove("");

		for (String word : words){
			if (word.length() == 0) continue;
			dic.remove(word);
			if (dfs(word, dic, 0)) {
				res.add(word);
			}
			dic.add(word);
		}
		return res;
	}


	public boolean dfs(String s, Set<String> wordDict, int start) {
		if (start == s.length()) {
			return true;
		}
		for (int end = start + 1; end <= s.length(); end++) {
			if (wordDict.contains(s.substring(start, end)) && dfs(s, wordDict, end)) {
				return true;
			}
		}
		return false;
	}

}
