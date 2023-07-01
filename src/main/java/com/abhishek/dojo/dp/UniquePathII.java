package com.abhishek.dojo.dp;

// Passes all leetcode tests 43/43 https://leetcode.com/problems/unique-paths-ii/submissions/

public class UniquePathII {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		if (obstacleGrid.length == 0) {
			return 0;
		}
		if (obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1] == 1 || obstacleGrid[0][0] == 1) {
			return 0;
		}
		if (obstacleGrid.length == 1) {
			return obstacleGrid[0][0] == 0 ? 1 : 0;
		}
		// only right and down movement permitted. No left or down.
		int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
		// fill top row with 1. as there is exactly one way of moving right for top row
		// for each cell
		for (int i = 0; i < obstacleGrid.length; i++) {
			if (obstacleGrid[i][0] == 1)
				break;
			dp[i][0] = 1;
		}
		// fill leftmost column with 1. as there is exactly one way of moving down for
		// leftmost column for each cell
		for (int i = 0; i < obstacleGrid[0].length; i++) {
			if (obstacleGrid[0][i] == 1)
				break;
			dp[0][i] = 1;
		}
		for (int i = 1; i < obstacleGrid.length; i++) {
			for (int j = 1; j < obstacleGrid[i].length; j++) {
				// number of ways you can reach each cell- go right and move down. or go down
				// and move right
				if (obstacleGrid[i][j] != 1) {
					dp[i][j] = dp[i - 1][j] // move left and take maximum ways to reach left
							+ dp[i][j - 1]; // move top and take maxumum ways to reach top
				} else {
					dp[i][j] = 0;
				}
			}
		}
		return dp[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
	}
}
