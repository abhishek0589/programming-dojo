package com.abhishek.dojo.slidingwindow;

import java.util.ArrayList;
import java.util.List;

// LC- 18 / 18 test cases passed.
// Runtime: 50 ms, faster than 12.17% of Java online submissions for Sliding Window Maximum.
// Memory Usage: 42.3 MB, less than 43.75% of Java online submissions for Sliding Window Maximum.
public class MaxInSlidingWindow {
	public int[] maxSlidingWindow(int[] nums, int k) {
		if (nums.length == 0) {
			return new int[0];
		}
		List<Integer> list = new ArrayList<Integer>();
		// outer loop to run from i = 0 till length -k
		for (int i = 0; i <= nums.length - k; i++) {
			int max = nums[i];
			// inner loop to scan every window of k from given position of i- sliding window
			for (int j = 1; j < k; j++) {
				if (nums[i + j] > max)
					max = nums[i + j];
			}
			list.add(max);
		}
		int[] arr = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			arr[i] = list.get(i);
		}
		return arr;
	}
}