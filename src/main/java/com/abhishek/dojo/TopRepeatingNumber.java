package com.abhishek.dojo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TopRepeatingNumber {
	
	public static void main(String[] args) {
		int[] nums = {1,1,1,1,3,3,5,5,5,5,5,5,6,6,6,6,6,7,7,7,7,8};
		Map<Integer, Integer> numVsCount = new HashMap<Integer, Integer>();
		for (int num: nums) {
			numVsCount.putIfAbsent(num, 1);
			if (numVsCount.containsKey(num)) {
				int count = numVsCount.get(num);
				numVsCount.put(num, ++count);
			}
		}
		Iterator<Map.Entry<Integer, Integer>> itr = numVsCount.entrySet().iterator();
		List<NumPair> numls = new ArrayList<NumPair>();
		while(itr.hasNext()) {
			Map.Entry<Integer, Integer> entry = itr.next();
			NumPair a  = new NumPair (entry.getKey(), entry.getValue());
			numls.add(a);
		}
		numls = numls.stream().sorted((a,b) -> -(a.getCount() - b.getCount())).collect(Collectors.toList());
		numls.stream().forEach(System.out::println);
	}
	
	
}

