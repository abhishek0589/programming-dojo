package com.abhishek.dojo.graph;

import java.util.LinkedList;
import java.util.List;

/*
1.Naive solution:
    Standard dfs, which means for each point, we check if it can reach both pacific and atlantic, 
    for each point, we can possibly check all the rest of points, O(m*n * m*n)

2.A little improvement:
    What about we 4 hash tables, they keep track of all the points we know so far that 
        can reach atlantic
        cannot reach atlantic
        can reach pacific
        cannot reach pacific
    It's doable, still hit TLE, although I didn't hit TLE when not submitting the code, but running it using the provided testing environment

3.On the other hand, we can consider the flip side
    We can let the pacific and atlantic ocean "flow into" the matrix as much as possible,
    using 2 boolean arrays, one for each ocean. 
    The result are the points that are true in both boolean table
 */

public class PacificAtlanticWaterFlow {

	public static void main(String[] args) {
		PacificAtlanticWaterFlow c = new PacificAtlanticWaterFlow();
		c.pacificAtlantic(new int[][] {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}}).forEach(x -> System.out.println(x[0] + "" + x[1]));
	}

	public List<int[]> pacificAtlantic(int[][] matrix) {
		List<int[]> res = new LinkedList<>();
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
			return res;
		}
		int n = matrix.length, m = matrix[0].length;
		boolean[][]pacific = new boolean[n][m];
		boolean[][]atlantic = new boolean[n][m];

		// start dfs from border cells. First row, first col. Last row, Last col
		for(int i=0; i<n; i++){
			// dfs from cell 00, 10, 20, 30, 40 (first column- first cell of every row)
			dfs(matrix, pacific, Integer.MIN_VALUE, i, 0);
			// dfs from cell 04, 14, 24, 34, 44 (last column- last cell of every row)
			dfs(matrix, atlantic, Integer.MIN_VALUE, i, m-1);
		}
		for(int i=0; i<m; i++){
			// dfs from cell 00, 01, 02, 03, 04 (first row)
			dfs(matrix, pacific, Integer.MIN_VALUE, 0, i);
			// dfs from cell 40, 41, 42, 43, 44 (last row)
			dfs(matrix, atlantic, Integer.MIN_VALUE, n-1, i);
		}

		// common wet areas form result
		for (int i = 0; i < n; i++) 
			for (int j = 0; j < m; j++) 
				if (pacific[i][j] && atlantic[i][j]) 
					res.add(new int[] {i, j});
		return res;
	}

	public void dfs(int[][] matrix, boolean[][] visited, int height, int x, int y) {
		int n = matrix.length, m = matrix[0].length;
		if (x < 0 || x >= n || y < 0 || y >= m || visited[x][y] || matrix[x][y] < height)
			return;
		visited[x][y] = true;
		dfs(matrix, visited, matrix[x][y], x, y + 1);//move right
		dfs(matrix, visited, matrix[x][y], x, y - 1);//move left
		dfs(matrix, visited, matrix[x][y], x - 1, y);// move top
		dfs(matrix, visited, matrix[x][y], x + 1, y);//move bottom
	}

}
