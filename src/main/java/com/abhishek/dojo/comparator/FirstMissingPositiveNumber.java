package com.abhishek.dojo.comparator;

import java.util.Arrays;

public class FirstMissingPositiveNumber {

	public static void main(String[] args) {
		FirstMissingPositiveNumber f = new FirstMissingPositiveNumber();
		System.out.println(
				f.firstMissingPositive(new int[] {-3,-4,1,2,3,4,5,6,10,13})
				);

	}

	public int firstMissingPositive(int[] nums) {
		int n = nums.length;
		// Base case.
		int contains = 0;
		for (int i = 0; i < n; i++)
			if (nums[i] == 1) {
				contains++;
				break;
			}

		if (contains == 0)
			return 1;

		// nums = [1]
		if (n == 1)
			return 2;

		System.out.println("1 Original");
		Arrays.stream(nums).forEach(x -> System.out.print(x + " "));

		// Replace negative numbers, zeros,
		// and numbers larger than n by 1s.
		// After this convertion nums will contain 
		// only positive numbers.
		for (int i = 0; i < n; i++)
			if ((nums[i] <= 0) || (nums[i] > n))
				nums[i] = 1;

		System.out.println("\n2 remove negatives and elements greater");
		Arrays.stream(nums).forEach(x -> System.out.print(x + " "));
		// Use index as a hash key and number sign as a presence detector.
		// For example, if nums[1] is negative that means that number `1`
		// is present in the array. 
		// If nums[2] is positive - number 2 is missing.
		for (int i = 0; i < n; i++) {
			int a = Math.abs(nums[i]);
			// If you meet number a in the array - change the sign of a-th element.
			// Be careful with duplicates : do it only once.
			if (a == n)
				nums[0] = - Math.abs(nums[0]);
			else
				nums[a] = - Math.abs(nums[a]);
		}

		System.out.println("After positional indexing");
		Arrays.stream(nums).forEach(x -> System.out.print(x + " "));
		// Now the index of the first positive number 
		// is equal to first missing positive.
		for (int i = 1; i < n; i++) {
			if (nums[i] > 0)
				return i;
		}

		if (nums[0] > 0)
			return n;

		return n + 1;
	}
}
