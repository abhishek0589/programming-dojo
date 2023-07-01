package com.abhishek.dojo.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopRepeatingWord {

	// note- see how map is converted to list and sorted using comparator
	public String topKFrequent(String s, String[] banned) {
		HashMap<String, Integer> numVsCount = new HashMap<>();
		String[] nums = s.split(" ");
		for (String num : nums) {
			num = num.replace(",", "").toLowerCase().trim();
			Integer count = numVsCount.getOrDefault(num, 0);
			numVsCount.put(num, ++count);
		}
		List<Map.Entry<String, Integer>> list = new ArrayList<>(numVsCount.entrySet());
		Collections.sort(list, (a, b) -> b.getValue() - a.getValue());
		
		int index = 0;
		for (String ban : banned) if (list.get(index).getKey().equals(ban)) index++;
		return list.get(index).getKey();
	}

	public static void main(String[] args) {
		TopRepeatingWord tkre = new TopRepeatingWord();
		System.out.println(tkre.topKFrequent("bob hit a ball, the hit BALL flew far after it was hit.", new String[] {"hit"}));
	}
}
