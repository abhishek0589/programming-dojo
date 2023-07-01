package com.abhishek.data.structure.trie;

// disadvantages- memory issues as lot of space is wasted
public class TrieNodeArray {

	static final int ALPHABET_SIZE = 26;
	TrieNodeArray[] children = new TrieNodeArray[ALPHABET_SIZE];
	// isEndOfWord is true if the node
	// represents end of a word
	boolean isEndOfWord;

	TrieNodeArray() {
		isEndOfWord = false;
		for (int i = 0; i < ALPHABET_SIZE; i++)
			children[i] = null;
	}

};
