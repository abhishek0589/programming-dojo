package com.abhishek.dojo.bitewise;

public class SimpleNumber {

	public static void main(String[] args) {
		SimpleNumber s = new SimpleNumber();
		System.out.println(
				s.singleNumber(new int[] {5,5,6,6,5,6,3})
				);
	}

	public int singleNumber(int[] nums) {
		int one = 0, two =0;
		for (int i = 0; i < nums.length; i++) {
			one = (one ^ nums[i]) & ~two;
			two = (two ^ nums[i]) & ~one;
			System.out.println("nums[i]: " + nums[i] + " ,one: " + one + " ,two: " + two);
		}
		return one;
	}
}
