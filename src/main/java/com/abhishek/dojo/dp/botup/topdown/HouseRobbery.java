package com.abhishek.dojo.dp.botup.topdown;

// 69 / 69 test cases passed.

public class HouseRobbery {

	// bottom up solution
	// this is little better to understand compared to even odd approach
	// at every position of i, we are taking max of (current position + profit obtained till i-2) 
	// and profit obtained till i-1
	public static int rob(int[] nums) {
		int[] wealth = new int[nums.length];

		if (nums.length == 0) return 0;
		if (nums.length == 1) return nums[0];

		for (int i = 0; i < nums.length; i++) {
			if (i == 0) wealth[i] = nums[0];
			else if (i == 1) wealth[i] = Math.max(nums[1], nums[0]);
			else  {
				// We can clearly see that this problem follows the Fibonacci number pattern. 
				// The only difference is that every Fibonacci number is a sum of the two preceding numbers, 
				// whereas in this problem every number (total wealth) is the maximum of previous two numbers.
				wealth[i] =  Math.max(wealth[i-2] + nums[i], wealth[i-1]);
			}
		}
		return wealth[nums.length-1];
	}

	public static void main(String[] args) {
		System.out.println(rob(new int[] { 1000, 1000, 1 }));
		System.out.println(rob(new int[] { 3, 10, 3, 1, 2 }));
	}
}
