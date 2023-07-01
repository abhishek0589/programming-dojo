package com.abhishek.data.structure.trie;

import java.util.List;

// disadvantage- This is not efficient in terms of time as we can’t quickly find a particular child
public class TrieLinked {
	char c;
	List<TrieLinked> children;
}
