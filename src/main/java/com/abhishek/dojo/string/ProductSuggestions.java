package com.abhishek.dojo.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.abhishek.data.structure.trie.TrieMap;

public class ProductSuggestions {

	public static void main(String[] args) {
		new ProductSuggestions().getAutoCompleteResults(5,
				Arrays.asList("bag", "badge", "bags", "baggage", "cox", "cloth"), "bags");
		new ProductSuggestions().getAutoCompleteResults(5,
				Arrays.asList("coddle", "coddles", "code", "coder", "coders", "cods"), "codler");
	}

	public List<List<String>> getAutoCompleteResults(int numOfProducts, List<String> dictionary, String customerQuery) {
		List<List<String>> result = new ArrayList<>();
		TrieMap trie = new TrieMap("");
		trie.load(dictionary);
		for (int i = 2; i <= customerQuery.length(); i++) {
			String query = customerQuery.substring(0, i);
			List<String> subResults = trie.get(query);
			result.add(subResults.size() > 3 ? subResults.subList(0, 3) : subResults);
			System.out.print("query: " + query + " => " + subResults.toString() + "\n");
		}
		return result;
	}

}
