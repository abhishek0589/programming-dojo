
package com.abhishek.dojo.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;

public class AlienDictionary {


	public static void main(String[] args) {
		AlienDictionary a = new AlienDictionary();
		//System.out.println(a.alienOrder(new String[] { "wrt", "wrf", "er", "ett", "rftt" }));
		//		System.out.println(a.alienOrder(new String[] { "aac", "aabb", "abab"}));
		System.out.println(a.alienOrder(new String[] {"abbd", "efgh", "klmn"}));

	}

	public String alienOrder(String[] words) {

		if (words == null || words.length == 0) return "";

		/************************ 1. Data structures **************************/ 
		// graphBeforeVsAfter-> map of letters occurred before vs set of letters occured after it
		// afterLettersVsCount-> how many times a letter is after letter
		Map<Character, Set<Character>> beforeAfterMap = new HashMap<>();
		Map<Character, Integer> afterLetterCount = new HashMap<>();

		/************************ 2. Build data structures **************************/ 
		//add all letters in afterLetter count
		for(String word : words) for (Character c : word.toCharArray())  afterLetterCount.putIfAbsent(c, 0);

		for (int i = 0; i < words.length - 1; i++) {
			String before = words[i];
			String after = words[i + 1];
			for (int j = 0; j < Math.min(before.length(), after.length()); j++) {
				if (before.charAt(j) != after.charAt(j)) {
					beforeAfterMap.putIfAbsent(before.charAt(j), new HashSet<>());
					Set<Character> set = beforeAfterMap.get(before.charAt(j));
					/** WARNING: we must check if we already build curChar -> nextChar relationship in graph
					 * if it contains, we cannot update inDegree map again. Otherwise, this nextChar
					 * will never be put in the queue when we do BFS traversal
					 * eg: for the input: {"za", "zb", "ca", "cb"}, we have two pairs of a -> b relationship
					 * if we increase inDegree value of 'b' again, the final result will not have 'b', since 
					 * inDegree of b will stay on 1 when queue is empty 
					 * correct graph: a -> b, z -> c
					 * incorrect graph: a -> b, a -> b, z -> c
					 * */
					// note- if set doesnt contain after letter for same before-after pair
					if (!set.contains(after.charAt(j))) { 
						set.add(after.charAt(j));
						beforeAfterMap.put(before.charAt(j), set);
						afterLetterCount.put(after.charAt(j), afterLetterCount.getOrDefault(after.charAt(j), 0) + 1);
					}
					// ALERT: However, the order among letters are unknown to you. So only compare first non repeating alphabet in each word
					break;
				}
			} 
		}

		/************************ ALGO (3. similar to course schedule) **************************/ 
		// once both maps are built, afterLettersVsCount map is starting point and graphBeforeVsAfter is reference map
		// all letters having zero count in afterLettersVsCount map are basically letters who have never occured after hence they become start letters
		// such letters are put first in queue

		// from such letters, start BFS, remove letters that have occurred after such letters using graphBeforeVsAfter
		// if after removal, afterLettersVsCount of removed map is zero then such letters can be added to queue

		Queue<Character> sorted = new LinkedList<>();
		for (Entry<Character, Integer> entry : afterLetterCount.entrySet()) if (entry.getValue() == 0 ) sorted.offer(entry.getKey());
		StringBuilder result = new StringBuilder();
		while (!sorted.isEmpty()) {
			Character beforeChar = sorted.poll();
			result.append(beforeChar);
			if (!beforeAfterMap.containsKey(beforeChar)) continue;
			for (Character afterLetter : beforeAfterMap.get(beforeChar)) {
					afterLetterCount.put(afterLetter, afterLetterCount.get(afterLetter) - 1);
					if (afterLetterCount.get(afterLetter) == 0) {
						sorted.offer(afterLetter);
					}
				}
		}
		// if in the end, number of letters in result are not same as number of letters in after letter map, return blank else return result
		return result.length() != afterLetterCount.size() ? "" : result.toString();
	}
}
