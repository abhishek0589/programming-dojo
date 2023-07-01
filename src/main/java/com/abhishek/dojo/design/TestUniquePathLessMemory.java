package com.abhishek.dojo.design;

import java.util.Arrays;

public class TestUniquePathLessMemory {
	public static void main(String[] args) {
		TestUniquePathLessMemory t = new TestUniquePathLessMemory();
		System.out.println(t.uniquePaths(4,4));
	}

	public int uniquePaths(int m, int n) {
		// base case
		if (m == 0 && n == 0){
			return 0;
		}

		int[] top = new int[m];       
		int[] left = new int[n];
		int[] sum = new int[m];

		Arrays.fill(top, 1);
		Arrays.fill(sum, 1);

		for (int i = 1; i < m; i++){
			Arrays.fill(left, 1);
			for (int j = 1; j < n; j++){
				sum[j] = top[i] + left[j];
				left[j] = top[i] + left[j];
			}
			top = Arrays.copyOf(sum, sum.length);
			System.out.println(Arrays.toString(sum));
		}
		return sum[m-1];
	}
}
