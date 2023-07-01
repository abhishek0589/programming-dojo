package com.abhishek.dojo.string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

// same as minimum mutation gene
public class WordLadder {

	public static void main(String[] args) {
		WordLadder w = new WordLadder();
		// System.out.println(w.ladderLength("hit", "cog", new
		// HashSet<>(Arrays.asList("hot","dot","dog","lot","log","cog"))));
		System.out.println(w.ladderLength("leet", "code",
				Arrays.asList("lest", "leet", "lose", "code", "lode", "robe", "lost")));
	}

	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		if (wordList == null || wordList.size() == 0 || !wordList.contains(endWord)) return 0;
		Set<String> set = new HashSet<>(wordList);
		Queue<String> ladder = new LinkedList<>();
		ladder.add(beginWord);
		int level = 0;
		while(!ladder.isEmpty()){ // BFS
			int size = ladder.size();
			level++;
			for (int i = 0; i < size; i++){ // level tracking is needed
				String word = ladder.poll();
				for (int j = 0; j < word.length(); j++){
					char[] worda = word.toCharArray();
					for (char k = 'a'; k <= 'z'; k++) {
						if (worda[j] == k) //dont move forward if two words are same
							continue;
						worda[j] = k;
						String temp = new String(worda);
						if (set.contains(temp)){
							set.remove(temp);
							ladder.offer(temp);
							if (temp.equals(endWord)){
								return level + 1;
							}                            
						} 
					}
				}
			}
		}
		return 0;
	}
}
