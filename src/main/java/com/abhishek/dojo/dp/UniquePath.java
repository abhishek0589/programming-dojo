package com.abhishek.dojo.dp;

// Leetcode 62 / 62 test cases passed.

public class UniquePath {
	
	public static void main(String[] args) {
		UniquePath u = new UniquePath();
		System.out.println(u.uniquePaths(3, 2)); // 3
	}
	
	 public int uniquePaths(int m, int n) {
	        // only right and down movement permitted. No left or down.
	        int[][] dp = new int[m][n];
	        // fill top row with 1. as there is exactly one way of moving right for top row for each cell
	        for (int i = 0; i < m; i++){
	                dp[i][0] = 1;
	        }
	        // fill leftmost column with 1. as there is exactly one way of moving down for leftmost column for each cell
	        for (int i = 0; i < n; i++){
	                dp[0][i] = 1;
	        }
	        for (int i = 1; i < m; i++){    
	            for (int j = 1; j < n; j++){
	                // number of ways you can reach each cell- go right and move down. or go down and move right
	                dp[i][j] = 
	                    dp[i-1][j]  // move left and take maximum ways to reach left
	                    + dp[i][j-1]; // move top and take maxumum ways to reach top
	            }
	        }
	        return dp[m-1][n-1];
	    }
}

