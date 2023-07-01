package com.abhishek.dojo.dfsbfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

// same as Word ladder
public class MinimumMutationGene {
	
	public static void main(String[] args) {
		minMutation("AACCGGTT", "AAACGGTA", new String[] {"AACCGGTA", "AACCGCTA", "AAACGGTA"});
	}
	
    public static int minMutation(String start, String end, String[] bank) {
    	if (bank == null || bank.length == 0) return 0;
        HashSet<String> set = new HashSet<>();
        for (String x : bank) {
        	set.add(x);
        }
        if (!set.contains(end)) return 0;
		Queue<String> queue = new LinkedList<String>();
		queue.add(start);
		int level = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) { // for traversal 
				String cur = queue.remove(); // for current item in queue
				if (cur.equals(end)) return level == 0 ? -1 : level;
				for (int j = 0; j < cur.length(); j++) { // for each current item in list
					char[] word = cur.toCharArray();
					for (char ch = 'A'; ch <= 'Z'; ch++) {
						word[j] = ch;
						String temp = new String(word);
						// add to queue only when word matches something in list. Remove word from wordlist as well
						if (!temp.equals(cur) && set.contains(temp)) { 
							System.out.println("level: "+ level + "word: " + temp);
							queue.add(temp);
							set.remove(temp);
							break;
						} else {
							//System.out.println("failed:" + temp);
						}
					}
				}
			}
			level++;
		}
		return -1;
    }


}