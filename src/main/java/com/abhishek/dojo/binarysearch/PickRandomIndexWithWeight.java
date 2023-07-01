package com.abhishek.dojo.binarysearch;

import java.util.Arrays;
import java.util.Random;
// LC- 57 / 57 test cases passed.

public class PickRandomIndexWithWeight {
	public static void main(String[] args) {
		PickRandomIndexWithWeight p = new PickRandomIndexWithWeight();
		int[] nums = { 1, 3, 3, 5 };
		System.out.println(p.getElement(nums));
	}

	/**
	 * Bruteforce solution input- [1,3,3,5] generate a new array with number of
	 * elements as per weighted averages [0,1,1,1,2,2,2,3,3,3,3,3] total elements in
	 * array = sum of each weighted average = 12 request a random number between 0
	 * and 11 return the element at index problem with bruteforce solution- if
	 * weighted averages have higher values then size of array would increase
	 * drastically
	 */
	// 2. Optmized solution/algo
	// get running sum of weighted averages
	public int[] getRunningSumOfWA(int[] nums) {
		int[] copy = nums.clone();
		int[] runningSum = new int[nums.length];
		for (int i = 0; i < copy.length; i++) {
			runningSum[i] = (i != 0) ? runningSum[i - 1] + copy[i] : copy[0];
		}
		return runningSum;
	}

	public int getElement(int[] nums) {
		Random r = new Random();
		int[] runningSum = getRunningSumOfWA(nums);
		int random = r.nextInt(runningSum[runningSum.length - 1]) + 1;
		// perform binary search-
		// If item found, returns index.
		// If item not found returns negative of insertion point (negative of last array
		// index)- this increases the possibility of getting hogher weighted average
		int pos = Arrays.binarySearch(runningSum, random);
		if (pos < 0)
			pos = -(pos + 1);
		return pos;
	}
}
