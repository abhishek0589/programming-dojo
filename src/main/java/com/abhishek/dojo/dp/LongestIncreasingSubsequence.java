package com.abhishek.dojo.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;

// LC- 24 / 24 test cases passed.
// Runtime: 16 ms, faster than 16.97% of Java online submissions for Longest Increasing Subsequence.
// Memory Usage: 36.8 MB, less than 70.00% of Java online submissions for Longest Increasing Subsequence.

public class LongestIncreasingSubsequence {

	public static void main(String[] args) {
		Integer[] target = longestIncreasingSubsequence(new int[] { 3, 0, 1, 4, 6, 0, 15, -1 });
		System.out.println(Arrays.deepToString(target));
		ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(target));
		Optional<Integer> max = list.stream().max(Comparator.naturalOrder());
		System.out.println("longest increasing sub: " + max.get().intValue());
	}

	// approach
	// 1. create a blank array and initialize it with all 1s assuming each
	// element has longest subsequence of atleast 1

	// 2. create two loops, outer loop with i starting from 1 and inner loop with
	// start with j till i-1

	// 3. at every point compare if num[j] < num [i] and if so then longest
	// increasing subsequence at i is 1+ longest increaing subsquence at j

	public static Integer[] longestIncreasingSubsequence(int[] nums) {

		Integer[] subseq = new Integer[nums.length];

		for (int i = 0; i < nums.length; i++) {
			subseq[i] = 1;
		}

		for (int i = 1; i < nums.length; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j]  && subseq[j] + 1 > subseq[i]) {
					subseq[i] = subseq[j] + 1;
				}
			}
		}

		return subseq;
	}
}
