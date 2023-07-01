package com.abhishek.dojo.string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

// leetcode -> leet, lee, code

// algo
// lee (3)
// leet(4) -> code (8)
public class Wordbreak {

	public static void main(String[] args) {
		Wordbreak w = new Wordbreak();
		//w.wordBreak("leetcode", new HashSet<>(Arrays.asList("leet", "lee", "code", "de")));
		w.bfs("catsandog", new HashSet<>(Arrays.asList("cats", "og", "and", "cat")));
	}

	public boolean dfs(String s, List<String> wordDict) {
		return dfs(s, new HashSet<>(wordDict), 0);
	}

	public boolean dfs(String s, Set<String> wordDict, int start) {
		if (start == s.length()) {
			return true;
		}
		for (int end =	 start + 1; end <= s.length(); end++) {
			if (wordDict.contains(s.substring(start, end)) && dfs(s, wordDict, end)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean bfs(String s, Set<String> wordDict) {
		if (wordDict.contains(s)) return true;
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(0);
		// use a set to record checked index to avoid repeated work.
		// This is the key to reduce the running time to O(N^2).
		Set<Integer> visited = new HashSet<Integer>();
		visited.add(0);
		while (!queue.isEmpty()) {
			int start = queue.poll();
			for (int i = start+1; i <= s.length(); i++) {
				if (visited.contains(i))
					continue;
				if (wordDict.contains(s.substring(start, i))) {
					if (i == s.length()) 
						return true;
					queue.offer(i);
					visited.add(i);
				}
			}
		}
		return false; 
	}


}
