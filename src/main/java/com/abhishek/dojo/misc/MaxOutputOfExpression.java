package com.abhishek.dojo.misc;

public class MaxOutputOfExpression {

	public static void main(String[] args) {
		MaxOutputOfExpression m = new MaxOutputOfExpression();
		System.out.println(m.getMaxOutput(new int[] { 3, 5, -2, 1 }));
	}

	public int getMaxOutput(int[] nums) {
		int result = 0;
		for (int i = 0; i < nums.length; i++) {
			int product = result * nums[i];
			int add = result + nums[i];
			int sub = result - nums[i];
			result = Math.max(product, Math.max(add, sub));
		}
		return result;
	}
}
