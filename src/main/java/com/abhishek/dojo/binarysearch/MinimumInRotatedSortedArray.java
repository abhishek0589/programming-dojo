package com.abhishek.dojo.binarysearch;


// LC- 146 / 146 test cases passed.


public class MinimumInRotatedSortedArray {
	public static void main(String[] args) {
		MinimumInRotatedSortedArray f = new MinimumInRotatedSortedArray();
		int[] array = new int[] { 4, 5, 6, 7, 8, 1, 2 };
		System.out.println("minimum in rotated array:" + f.search(array, 2));
	}
	
	// very simple sol
    public int findMin(int[] nums) {
		if (nums.length == 0) {
			return -1;
		}
		for ( int i =0; i < nums.length - 1; i++){
            if (nums[i] > nums[i+1]){
                return nums[i+1];
            }
        }
        return nums[0];
    }

    // complicated solution
	public int search(int[] nums, int target) {
		if (nums.length == 0) {
			return -1;
		}
		if (nums.length == 1) {
			return nums[0] == target ? 0 : -1;
		}
		int pivot = getPivot(nums, 0, nums.length - 1);
		if (pivot == nums.length - 1) { // pivot at end; min should be 0
			return nums[0];
		} else if (pivot < nums.length - 1) {
			return nums[pivot + 1];
		}
		return -1;
	}

	private int getPivot(int[] nums, int lo, int hi) {
		while (hi - lo > 1) {
			int mid = (lo + hi) / 2;
			if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
				return mid;
			} else if (nums[mid] < nums[0]) {
				hi = mid;
			} else {
				lo = mid;
			}
		}
		return 0;
	}
}
