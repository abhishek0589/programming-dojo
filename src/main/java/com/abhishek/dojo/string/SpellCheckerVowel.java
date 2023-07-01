package com.abhishek.dojo.string;

import java.util.Arrays;
import java.util.HashMap;

public class SpellCheckerVowel {

	public static void main(String[] args) {
		SpellCheckerVowel sp = new SpellCheckerVowel();
		String[] wordlist = { "KiTe", "kite", "hare", "Hare" };
		String[] queries = { "kite", "Kite", "KiTe", "Hare", "HARE", "Hear", "hear", "keti", "keet", "keto" };
		System.out.println(Arrays.deepToString(sp.spellchecker(wordlist, queries)));
	}

	public String[] spellchecker(String[] wordlist, String[] queries) {

		HashMap<String, String> oddVsFirstWord = new HashMap<>();

		String[] output = new String[queries.length];

		for (String word : wordlist) {
			oddVsFirstWord.putIfAbsent(word, word);
			word = word.replaceAll("[AEIOUaeiou]", "#");
			oddVsFirstWord.putIfAbsent(word.toLowerCase(), word);
			oddVsFirstWord.putIfAbsent(word.replaceAll("[AEIOUaeiou]", "#").toLowerCase(), word);
		}

		int count = 0;
		for (String query : queries) {
			if (oddVsFirstWord.containsKey(query)) {
				output[count] = oddVsFirstWord.get(query);
			}
			
			if (output[count].isEmpty()) {
				if (oddVsFirstWord.containsKey(query.toLowerCase())) {
					output[count] = oddVsFirstWord.get(query.toLowerCase());
				}
			}
			if (output[count].isEmpty()) {
				if (oddVsFirstWord.containsKey(query.replaceAll("[AEIOUaeiou]", "#").toLowerCase())) {
					output[count] = oddVsFirstWord.get(query.replaceAll("[AEIOUaeiou]", "#").toLowerCase());
				}
			}
			count++;
		}
		return output;
	}

}
