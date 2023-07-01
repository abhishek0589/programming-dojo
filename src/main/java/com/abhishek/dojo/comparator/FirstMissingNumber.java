package com.abhishek.dojo.comparator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
/*
Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, 
find the one that is missing from the array.

Example 1: Input: [3,0,1]. Output: 2

Example 2: Input: [9,6,4,2,3,5,7,0,1]. Output: 8
Note: Your algorithm should run in linear runtime complexity. 
Could you implement it using only constant extra space complexity?

*/
public class FirstMissingNumber {

	public static void main(String[] args) {
		FirstMissingNumber f = new FirstMissingNumber();
		System.out.println(f.missingNumber(new int[] {3,0,1}));
	}

	//o(n) o(1) space
	public int missingNumber(int[] nums) {
		int sum = 0;
		for (int i = 0; i < nums.length; i++) sum += nums[i];
		// note- we consider nums.length and not nums.length-1 for sum
		// numbers are starting from 0 and not from 1
		// if numbers were to start from 1, we must consider nums.length-1
		return nums.length * (nums.length + 1) / 2 - sum; 
	}

	//o(nlogn) o(1) space
	public int missingNumber1(int[] nums) {
		List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
		Collections.sort(list);
		for (int i = 0 ; i < list.size() - 1; i++) {
			if (list.get(i+1)-list.get(i) > 1) {
				return list.get(i) + 1;
			}
		}
		// we should not do this because 0th element should always be 0 as per problem statement
		return list.get(0) > 0 ? 0 : list.get(list.size() - 1) + 1;
	}

}
