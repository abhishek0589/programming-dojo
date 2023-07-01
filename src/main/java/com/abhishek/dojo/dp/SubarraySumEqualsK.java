package com.abhishek.dojo.dp;

import java.util.HashMap;
import java.util.Map;

// a.	Algo- Prefix sum- If a cumulative sum repeats at index I and j in an array, 
// 		then cumu-sum[i] – cumu-sum[j] = 0, it means sum of the numbers between indices i+1 and j, is zero

// b.	Similarly, extending same thought, if difference between two cumulative sums is K, 
//		then cumu-sum[i] – cumu-sum[j] = K, it means sum of consecutive elements between indices i+1 and j is K

// time complexity- o(n) space complexity o(n)

// https://leetcode.com/problems/subarray-sum-equals-k/solution/
public class SubarraySumEqualsK {
	
	public static void main(String[] args) {
		SubarraySumEqualsK s = new SubarraySumEqualsK();
		// [[3,4] [7] 	[7,2,-3,1]	[1,4,2]]
		System.out.println(
		s.subarraySum(new int[] {3,4,7,2,-3,1,4,2}, 7) // 4
				);
	}
	
	public int subarraySum(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		int count = 0, sum = 0;
		map.put(0, 1);
		for (int i = 0; i < nums.length; i++) {
			sum = sum + nums[i];
			// need to understand this better
			count = count + (map.get(sum - k) != null ? map.get(sum - k) : 0);
			// increment sum's occurance count by 1`
			map.compute(sum, (key, val) -> val == null ? 1 : val + 1);
		}
		return count;
	}
}