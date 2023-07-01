package com.abhishek.dojo.dp;

import java.util.ArrayList;
import java.util.List;

public class MaximumSumOfTriangularSeries {
	public static void main(String[] args) {
		List<List<Integer>> triangle = new ArrayList<List<Integer>>();
		ArrayList<Integer> test = new ArrayList<Integer>();
		test.add(2);
		triangle.add(test);
		test = new ArrayList<Integer>();
		test.add(3);
		test.add(6);
		triangle.add(test);
		test = new ArrayList<Integer>();
		test.add(9);
		test.add(1);
		test.add(2);
		triangle.add(test);
		System.out.println(maximumTotal(triangle));
	}

	public static int maximumTotal(List<List<Integer>> triangle) {
		int n = triangle.size();
		if(n == 0){
			return 0;
		}
		if(n == 1){
			return triangle.get(0).get(0);
		}

		int[][] dp = new int[n][n];
		// First row with only one node
		dp[0][0] = triangle.get(0).get(0);
		int max = Integer.MIN_VALUE;
		for(int i=1;i<n;i++){
			List<Integer> row = triangle.get(i);
			for(int j=0;j<=i;j++){
				if(j==0){
					// First node
					dp[i][j]=dp[i-1][j]+row.get(j);
				}else if(j == i){
					// Last node
					dp[i][j]=dp[i-1][j-1]+row.get(j);
				}else{
					// Middle node
					dp[i][j]=Math.max(dp[i-1][j-1]+row.get(j),dp[i-1][j]+row.get(j));
				}
				if(i == n-1){
					// Last row. Keep track of the minimum
					max = Math.max(max,dp[i][j]);
				}
			}
		}
		return max;
	}
}
