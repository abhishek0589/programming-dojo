package com.abhishek.dojo.dp.botup.topdown;

import java.util.Arrays;
import java.util.function.Function;

//74 / 74 test cases passed.

public class HouseRobberII {

	public static void main(String[] args) {
		HouseRobberII c = new HouseRobberII();
		System.out.println(c.rob(new int[] { 1, 2, 3, 1 }));
	}

	public int rob(int[] nums) {
		if (nums.length == 0) return 0;
		if (nums.length == 1) return nums[0];

		return Math.max(rob().apply(Arrays.copyOfRange(nums, 0, nums.length - 1)),
				rob().apply(Arrays.copyOfRange(nums, 1, nums.length)));
	}

	// return entire function
	// best practice- write a function with no params and return function interface. pass params to apply function instead
	public Function<int[], Integer> rob(){
		return  (input)-> {
			for (int i = 0; i < input.length; i++) {
				if (i == 0) input[i] = input[0];
				else if (i == 1) input[i] = Math.max(input[1], input[0]);
				else input[i] = Math.max(input[i - 2] + input[i], input[i - 1]);
			}
			return input[input.length - 1];
		};
	}
}
