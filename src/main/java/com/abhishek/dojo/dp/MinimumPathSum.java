package com.abhishek.dojo.dp;

public class MinimumPathSum {
	
	// notice- if and else if. its not if followed by other ifs
    public int minPathSum(int[][] grid) {
    	int dp[][] = new int[grid.length][grid[0].length];
    	for (int i = 0; i < grid.length; i++) {
    		for (int j = 0; j < grid[i].length; j++) {
                if( i == 0 && j == 0) dp[i][j] = grid[i][j];
    			else if (i == 0) dp[i][j] = dp[i][j-1] + grid[i][j];
    			else if (j ==0) dp[i][j] = dp[i-1][j] + grid[i][j];
    			else  dp[i][j]  = grid[i][j] + Math.min(dp[i-1][j] , dp[i][j-1]);
    		}
    	}
        return dp[grid.length-1][grid[0].length-1];
    }

    	
	
}
