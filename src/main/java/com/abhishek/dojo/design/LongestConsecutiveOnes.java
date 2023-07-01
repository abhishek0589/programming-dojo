package com.abhishek.dojo.design;

public class LongestConsecutiveOnes {
	public static void main(String[] args) {
		LongestConsecutiveOnes o = new LongestConsecutiveOnes();
		int[][] M = { 
				{ 1, 0, 1, 0 }, 
				{ 0, 1, 1, 0 }, 
				{ 0, 0, 1, 1 },
				{ 0, 0, 0, 1 }
				};//3
		System.out.println(o.longestLine(M));
	}


	public int longestLine(int[][] grid) {
		if (grid.length == 0) return 0;
		
		int row = grid.length; //row
		int col = grid[0].length; //col
		
		int len = 0;
		for (int i = 0; i < row; i++) { // row. dir array is passed to iterate horizontally over same row
			len = Math.max(len, check(grid, i, 0, new int[]{0, 1})); // this is how array is directly passed in functions. needs to go through new keyword
		}    

		for (int i = 0; i < col; i++) { // col
			len = Math.max(len, check(grid, 0, i, new int[]{1, 0}));
		}

		for (int i = 0; i < row; i++) { // diagonal
			len = Math.max(len, check(grid, i, 0, new int[]{1, 1}));
			len = Math.max(len, check(grid, i, col - 1, new int[]{1, -1}));
		}
		
		for (int i = 1; i < col; i++) { // anti-diagonal
			len = Math.max(len, check(grid, 0, i, new int[]{1, 1}));
			len = Math.max(len, check(grid, 0, col - i - 1, new int[]{1, -1}));
		}

		return len;
	}

	private int check(int[][] matrix, int row, int col, int[] dir) {
		int len = 0, count = 0;
		for (//initialization is totally optional and can be ignored if you need values to be collected in glovbal vars
				; row >= 0 && col >= 0 && row < matrix.length && col < matrix[0].length; row += dir[0], col += dir[1]) {
			System.out.print( row + "" + col + "\t");
			if (matrix[row][col] == 1) {
				count++; // increment count if current item is 1
				len = Math.max(len, count); // take max of consective length and current count value
			}else {
				count = 0; // reset the count if current item is not 1
			}
		}

		return len;
	}


	/*private int[][] dir = { 
			{ -1, 0 }, //top
			{ 0, -1 }, // left
			{ -1, -1 }, //top left
			{ -1, 1 } //top right
			};

	public int longestLine(int[][] M) {
		if (M.length == 0 || M[0].length == 0)
			return 0;
		//set row and col
		int m = M.length, n = M[0].length;
		int max = 0;
		// create a dp array with 1 extra row, 2 extra cols and 4 directions to scan
		int[][][] dp = new int[m + 1][n + 2][4];
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (M[i - 1][j - 1] != 0) {
					for (int k = 0; k < 4; k++) {
						int i1 = dir[k][0];
						int j1 = dir[k][1];
						System.out.println("(dp[i][j][k]=>dp[i+i1][j+j1][k]+1) ==> " + "dp["+i+"][" + j + "]["+k + "]=" +  "dp["+(i+i1)+"][" + (j+j1) + "]["+k + "]");
						//System.out.println("j + j1=> " + (j + j1));
						dp[i][j][k] = dp[i+i1][j+j1][k] + 1;

						max = Math.max(max, dp[i][j][k]);
					}
				}
			}
		}
		return max;
	}*/
}
