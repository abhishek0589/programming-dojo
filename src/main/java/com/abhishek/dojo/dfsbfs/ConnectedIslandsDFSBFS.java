package com.abhishek.dojo.dfsbfs;

import java.util.LinkedList;
import java.util.Queue;

/** 
 * key things to remember-
 * 
 * 1. Data structure- 
 * 		1. 2D array
 * 
 * 2. Logic-
 * 		1. Iterate through 2D array and find an island (1)
 * 		2. Once found an island, scan for connected islands
 * 		3. Scan connected islands
 * 			1. Return execution if 
 * 				a. corners are outside indices or 
 * 				b. if current cell value is 0- water and not island
 * 			2. Update cell position to be zero so that you dont keep recount
 * 			3. Scan around
 * 			4. Return one
 *  
 * 3. Runtime complexity-
 * 		1. As we are iterating through all the elements, run complexity is O(M X N)
 * 
 * 4. Space complexity-
 * 		1. No extra space hence constant
 * 
 * 5. Leetcode-
 * 			200. https://leetcode.com/problems/number-of-islands 
 * 			47 / 47 test cases passed as of Sept 7, 2019
 * 
 */

public class ConnectedIslandsDFSBFS {
	public static void main(String[] args) {
		char[][] grid = {
				{ '1', '1', '0', '0', '1' }, 
				{ '1', '1', '0', '0', '0' }, 
				{ '0', '0', '1', '1', '1' }, 
				{ '0', '0', '0', '1', '1' }};
		System.out.println("Number of connected islands => " + numIslands(grid));
		grid = new char[][] {{ '1', '1', '0', '0', '1' }, { '1', '1', '0', '0', '0' }, 
			{ '0', '0', '1', '1', '1' }, { '0', '0', '0', '1', '1' }};
			System.out.println("Number of connected islands => " + numIslandsBFS(grid));
	}

	public static int numIslands(char[][] grid) {
		int count = 0;
		if (grid.length == 0)
			return count;

		for (int i = 0; i < grid.length; i++) 
			for (int j = 0; j < grid[i].length; j++) 
				if (grid[i][j] == '1') {
					count ++; 
					dfs(grid, i, j);
				}

		return count;
	}

	public static void dfs(char[][] grid, int i, int j) {
		if ((i < 0 || i >= grid.length || j < 0 || j >= grid[i].length) || grid[i][j] == '0') return;
		grid[i][j] = '0';
		dfs(grid, i, j - 1);
		dfs(grid, i, j + 1);
		dfs(grid, i - 1, j);
		dfs(grid, i + 1, j);
	}

	public static int numIslandsBFS(char[][] grid) {
		int count = 0;
		for (int i = 0 ; i < grid.length; i++)
			for (int j = 0; j < grid[i].length; j++)
				if (grid[i][j] == '1'){
					count++; 
					bfs(grid, i, j);
				}
		return count;
	}

	// BFS with no level tracking
	private static void bfs(char[][] grid, int i, int j){
		Queue<int[]> island = new LinkedList<>();
		island.offer(new int[]{i, j});
		int[][] dirs = new int[][] {{1,0}, {-1,0}, {0,1}, {0,-1}};
		while (!island.isEmpty()){
			int[] island_coord = island.poll();
			for (int[] dir : dirs){
				int x = island_coord[0] + dir[0];
				int y = island_coord[1] + dir[1];
				if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == '0') continue;
				grid[x][y] = '0';
				island.offer(new int[]{x,y});
			}
		}
	}

}
