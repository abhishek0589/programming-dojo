package com.abhishek.dojo.greedy;

import java.util.Arrays;

// LC- 48 / 48 test cases passed.
// Runtime: 2 ms, faster than 100.00% of Java online submissions for Candy.
// Memory Usage: 39.3 MB, less than 100.00% of Java online submissions for Candy.

public class Candy {
	public static void main(String[] args) {
	}

	    public int candy(int[] ratings) {
	       int[] candies = new int[ratings.length];
			Arrays.fill(candies, 1);

			// move forward
			// the first loop makes sure children with a higher rating get more candy than its left neighbor
			for (int i = 0; i < ratings.length - 1; i++) {
				if (ratings[i+1] > ratings[i]) {
					candies[i+1] = candies[i] + 1;
				}
			}

			//move backwards
			// the second loop makes sure children with a higher rating get more candy than its right neighbor
			for (int i = ratings.length - 1; i > 0; i--) {
				if (ratings[i-1] > ratings[i]){
					candies[i-1] = Math.max(candies[i] + 1, candies[i-1]);
				}
			}

			int sum = 0;
			for (int i = 0; i < candies.length; i++) {
				sum += candies[i];
			}

			return sum;
	    }

}
