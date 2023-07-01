package com.abhishek.dojo.bitewise;

public class FindUniqueBitwise {

	public static void main(String[] args) {
		FindUniqueBitwise f = new FindUniqueBitwise();
		System.out.println(
				f.getDup(new int[] {3,3,2,2,1,5,5})
				);
	}
	
	public int getDup(int[] nums) {
		int temp = 0;
		for (int i = 0; i < nums.length; i++) {
			temp = temp ^ nums[i];
		}
		return temp;
	}
}
