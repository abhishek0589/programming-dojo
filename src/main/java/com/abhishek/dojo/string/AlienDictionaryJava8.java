package com.abhishek.dojo.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

public class AlienDictionaryJava8 {

	public String alienOrder(String[] words) {
		StringBuilder result = new StringBuilder();
		Map<Character, Set<Character>> beforeAfter = new HashMap<>(); Map<Character, Integer> afterFreq = new HashMap<>();	
		if (words == null || words.length == 0) return result.toString();
		for(String word : words) for (Character c : word.toCharArray())  afterFreq.put(c, 0);
		for (int i = 0; i < words.length - 1; i++) {
			String before = words[i], after = words[i + 1];
			for (int j = 0; j < Math.min(before.length(), after.length()); j++) 
				if (before.charAt(j) != after.charAt(j)) {
					char beforec = before.charAt(j), afterc = after.charAt(j);
					if (beforeAfter.compute(beforec, (k,v) -> v != null ? v : new HashSet<>()).add(afterc))
						afterFreq.compute(afterc, (k,v) -> v != null ? ++v : 1);
					break;
				}
		}
		
		Queue<Character> sorted = new LinkedList<>();
		sorted.addAll(afterFreq.entrySet().stream().filter(e -> e.getValue() == 0).map(e -> e.getKey()).collect(Collectors.toList()));
		while (!sorted.isEmpty()) {
			Character beforeChar = sorted.poll();
			result.append(beforeChar);
			if (beforeAfter.containsKey(beforeChar))
				for (Character afterLetter : beforeAfter.get(beforeChar)) 
					if (afterFreq.compute(afterLetter, (k,v) -> --v) == 0) 
						sorted.offer(afterLetter);
		}
		return result.length() != afterFreq.size() ? "" : result.toString();
	}
}
