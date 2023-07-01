package com.abhishek.data.structure.trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// The efficient way is an implementation where we use hash map to store children of a node. 
// Now we allocate memory only for alphabets in use, and don’t waste space storing null pointers.
// also search operation is now done in constant time

public class TrieMap {
	
	String prefix;
	Map<Character, TrieMap> children;
	boolean isEnd;

	public TrieMap(String s) {
		this.prefix = s;
		this.children = new HashMap<>();
	}

	public void load(List<String> repository) {
		for (String word : repository) {
			// important- reset current whenever u add a new word and build tree from
			// begining again
			TrieMap current = this;
			for (int i = 0; i < word.length(); i++) {
				if (!current.children.containsKey(word.charAt(i))) {
					current.children.put(word.charAt(i), new TrieMap(word.substring(0, i + 1)));
				}
				current = current.children.get(word.charAt(i));
				current.isEnd = i == word.length() - 1;
			}
		}
	}

	public List<String> get(String prefix) {
		List<String> result = new ArrayList<>();
		// Iterate to the end of the prefix
		TrieMap curr = this;
		for (char c : prefix.toCharArray()) {
			if (curr.children.containsKey(c)) {
				curr = curr.children.get(c);
			} else {
				return result;
			}
		}
		// At the end of the prefix, find all child words
		return findAllChildren(prefix, curr, result);
	}

	public List<String> findAllChildren(String prefix, TrieMap curr, List<String> result) {
		if (curr.isEnd)
			result.add(curr.prefix);
		for (Character c : curr.children.keySet()) {
			findAllChildren(prefix, curr.children.get(c), result);
		}
		return result;
	}
}