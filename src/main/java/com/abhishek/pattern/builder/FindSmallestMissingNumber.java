package com.abhishek.pattern.builder;

import java.util.Arrays;
// [1,2,0]
// [1 2 0] unsorted missing integer (smallest positive- 3)
// [4 5 2 3] // 1
// array can contain negative elements
// expected answer should b smallest positive integer element
// [-3, 1, 2, 4] = 3
// [-3, 4, 6,7]
public class FindSmallestMissingNumber {

	public static void main(String[] args) {
		FindSmallestMissingNumber s = new FindSmallestMissingNumber();
		int [] nums = new int[] {1,2,0}; // 3
		System.out.println("smallest:" + s.getSmallestPositiveInteger(nums));
		nums = new int[] { 3, 4, -1, 1 }; // 2
		System.out.println("smallest:" + s.getSmallestPositiveInteger(nums));
		
		nums = new int[] {1,2,0}; // 3
		System.out.println("smallest:" + s.getSmallestPositiveIntegerUsingHeap(nums));
		nums = new int[] { 3, 4, -1, 1 }; // 2
		System.out.println("smallest:" + s.getSmallestPositiveIntegerUsingHeap(nums));
		
		
		
	}

	// approach1- sort array and scan lower and upper bounds - n log n 
	public int getSmallestPositiveInteger(int[] nums) {
		if (nums.length == 0) {
			return 1;
		}
		Arrays.sort(nums);
		// scan lower bound
		if (nums[0] > 1) {
			return 1;
		} 
		// scan upper bound
		else if (nums[0] <=1) {
			// if array is non contiguous
			for (int i = 0; i < nums.length - 1; i ++) {
				if (nums[i] > 0) {
					if (nums[i+1] - nums[i] > 1) {
						return nums[i] + 1;
					}
				}
			}
			// if array is contiguous
			return nums[nums.length - 1] + 1;
		}
		throw new IllegalArgumentException();
	}
	
	// approach2- possibility of using min/max heap to scan array element and keep track of lowest
	// constant space, order of n time
	public int getSmallestPositiveIntegerUsingHeap(int[] nums) {
		// PriorityQueue<Integer> q = new PriorityQueue<Integer>(1);
		int min = 0;
		int max = 0;
		boolean nonContiguous = false;
		for (int i = 0; i < nums.length - 1; i ++) {
			min = Math.min(min, nums[i]);
			max = Math.max(max, nums[i]);
			if (Math.abs(nums[i] - min) > 1) {
				nonContiguous = true;
				min = min + 1;
			}
		}
		if (min == 1) {
			return max + 1;
		} 
		// 1) min is 1 but array was not contiguous
		else {
			for (int i = 0; i < nums.length - 1; i ++) {
				
			}
		}
		
		
		
		
		return min;
	}

}
