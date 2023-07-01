package com.abhishek.dojo.dp.botup.topdown;

// verify if jump can be made till end or not
public class JumpGame1 {

	public static void main(String[] args) {
		JumpGame1 j = new JumpGame1();
		j.jump(new int[] {2,1,3,2,3,4,5,1,2,8});
	}

	public boolean jump(int[] nums) {
		//result array that stores minimum path
		int[] result = new int[nums.length];
		// 0 jumps needed at start point
		result[0] = 0;
		//initialize result array with max
		// this is needed because, we will be doing comparison between result array values and would take minimum between them
		// if we put 0 instead of max, irrespective of any comparison, 0 would be minimum and result will be all zero
		for(int i=1; i < nums.length ; i++) {
			result[i] = Integer.MAX_VALUE-1;
		}
		// i runs from 1 to length. j  runs from 0 to i- similar to longest increasing subsequence problem 
		for (int i = 1; i < nums.length; i++) {
			for (int j = 0; j < i; j++) {
				// in the range or not check- can jump or not
				// in order to jump to i, j (index) + value at j should be greater or equal to i
				// example for 2,1,3,2,3,4,5,1,2,8 
				// if i=2 and j=1, then j (1) + value at j (1) >= i, hence jump can be made
				// however, if i 4 and j start from begining, then j(0) + value at j (2) = 2 is not >= i (4) hence jump cant be made
				// this is the only place where we take reference from num array
				if (nums[j] + j >= i && result[i]!= 1) { // 1 is already lowest possible value
					// below comparison is all from result array, nothing from source array
					// choose minimum between existing minpath and upcoming min path
					result[i] = Math.min(result[i], result[j] + 1);
				}
			}
		}
		return result[result.length-1] != Integer.MAX_VALUE-1;
	}
}
