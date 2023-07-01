package com.abhishek.dojo.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKRepeatingElements {
	// note- see how map is converted to list and sorted using comparator
	public int topKFrequent(Integer[] nums, int k) {
		HashMap<Integer, Integer> numVsCount = new HashMap<Integer, Integer>();
		for (int num : nums) {
			Integer count = numVsCount.getOrDefault(num, 0);
			numVsCount.put(num, ++count);
		}
		List<Map.Entry<Integer, Integer>> list = new ArrayList<>(numVsCount.entrySet());
		Collections.sort(list, (a, b) -> b.getValue() - a.getValue());
		return list.get(0).getKey();
	}
	
	public static void main(String[] args) {
		TopKRepeatingElements tkre = new TopKRepeatingElements();
		Integer[] nums = {}; // 1
		System.out.println(tkre.topKFrequent(nums, 2));
	}
}
