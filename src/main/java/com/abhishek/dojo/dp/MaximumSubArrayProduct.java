package com.abhishek.dojo.dp;

// LC- 184 / 184 test cases passed.
// Runtime: 1 ms, faster than 99.01% of Java online submissions for Maximum Product Subarray.
// Memory Usage: 37.5 MB, less than 57.32% of Java online submissions for Maximum Product Subarray.

public class MaximumSubArrayProduct {
	public static void main(String[] args) {

	}

	// similar to max subarray sum. Except you need to keep track of highest and lowest
	// apart from creating variables for highest and lowest, you need to make a swap if num is less than zero
	// without swap, maximum will not be able to pick negative product created from min function
	public int maxProduct(int[] nums) {
		if (nums.length == 0) return -1;
		if(nums.length == 1) return nums[0];
		int maxAtEnd = nums[0], max = nums[0], lowAtEnd = nums[0];
		for (int i = 1; i < nums.length; i++){
			// notice the swap
			if(nums[i] < 0){
				int temp = lowAtEnd;
				lowAtEnd = maxAtEnd;
				maxAtEnd = temp;
			}
			lowAtEnd = Math.min(lowAtEnd * nums[i],  nums[i]);
			maxAtEnd = Math.max(maxAtEnd * nums[i],  nums[i]);
			max = Math.max(max,maxAtEnd);
		}
		return max;
	}
}
