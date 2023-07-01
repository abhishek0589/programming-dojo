package com.abhishek.dojo.dp;

import java.util.HashMap;
import java.util.Map;

// 46 / 46 test cases passed.
public class DeleteAndEarn {
	public static void main(String[] args) {
		int[] arr = { 3, 4, 2, 2, 5, 6 };
		System.out.println(deleteAndEarn(arr));
	}
	
	// generate a new array such that it has values from 0 uptil max of above array (bad if array values are higher)
	// after generating a sequential array, this problem becomes house robbery problem as even in house robbery problem you can not theft in adjancent houses
	// question has a condition- if you pick num[i], you cannot pick, num[i]+1 (next higher) or num[i]-1 (next lower)
	public static int deleteAndEarn(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		Map<Integer, Integer> map = new HashMap<>();
		int max = 0; // setup max
		for (int num : nums) {
			map.put(num, 1 + map.getOrDefault(num, 0));
			max = Math.max(max, num);
		}
		int[] scores = new int[max + 1]; // why max + 1 - because num is from 1 to 1000 and we are scoring from zero
		for (int i = 0;i < scores.length; i++) {
			if (i == 0) {
				scores[0] = map.getOrDefault(0, 0);
			}
			else if (i == 1) {
				scores[1] = map.getOrDefault(1, 0);
			}
			else{
				scores[i] = Math.max(scores[i - 2] + i * map.getOrDefault(i, 0), scores[i - 1]);
			}
		}
		return scores[scores.length-1];}

}