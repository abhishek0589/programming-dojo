package com.abhishek.dojo.binarysearch;

// LC- 196 / 196 test cases passed.
// Runtime: 0 ms, faster than 100.00% of Java online submissions for Search in Rotated Sorted Array.
// Memory Usage: 36.6 MB, less than 100.00% of Java online submissions for Search in Rotated Sorted Array.
// approach1- sort array and find element using binary search- log n + n log n = n log n
// approach2- can we do better? use binary search to find pivot and then again binary search to get element 

public class FindInRotateSortedArrayLogN {
	public static void main(String[] args) {
		FindInRotateSortedArrayLogN f = new FindInRotateSortedArrayLogN();
		int[] nums = new int[] { 3, 1 };
		f.search(nums, 1);
	}

	// similar to binary search
	// compare start, mid and end
	// compare target 

	// start--------mid----------end
	public int search(int[] nums, int target) {
		int start = 0, end = nums.length - 1;

		while (start < end) {

			int mid = (start + end)/ 2;
			if (nums[mid] == target) return mid;
			else if (nums[start] <= nums[mid]) {
				if (target >= nums[start] && target < nums[mid]) 
					end = mid - 1;
				else 
					start = mid + 1;
			}
			else {
				if (target <= nums[end] && target > nums[mid]) 
					start = mid + 1;
				else 
					end = mid - 1;
			}
		}
		if (start == end && nums[start] == target) return start;
		return -1;
	}
}
