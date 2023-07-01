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
 * 			695- https://leetcode.com/problems/max-area-of-island/	
 * 			726 / 726 test cases passed as of Sept 7, 2019
 * 
*/
public class MaxAreaOfIslandDFSBFS {
	
	public static void main(String[] args) {
		int[][] grid = {
				{ 1, 1, 0, 0, 1 }, 
				{ 1, 1, 0, 0, 0 }, 
				{ 0, 0, 1, 1, 1 }, 
				{ 0, 0, 0, 1, 1 }};
		
		System.out.println("Number of connected islands => " + numIslands(grid));
	}

	public static int numIslands(int[][] grid) {
		int count = 0;
		if (grid.length == 0) {
			return count;
		}
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == 1) {
					count = Math.max(scanForConnectedIslands(grid, i, j), count);
				}
			}
		}
		return count;
	}

	public static int scanForConnectedIslands(int[][] grid, int i, int j) {
		// boundary validations. Use ORs
		if ((i < 0 || i >= grid.length || j < 0 || j >= grid[i].length) || grid[i][j] == 0) {
			return 0;
		}
		// if control enters here, it means item is '1' and we can just mark it visited
		grid[i][j] = 0;
		
		// Note- These are not just 4 scans- its recursion. Each method will scan further inside 4 times unless control is returned
		// Note how count is managed here. You cannot do count+=1 on line below. 
		// You need to initialize count=1 and collect count value with every traversal
		
		int count = 1;
		count+= scanForConnectedIslands(grid, i, j - 1);
		count+= scanForConnectedIslands(grid, i, j + 1);
		count+= scanForConnectedIslands(grid, i - 1, j);
		count+= scanForConnectedIslands(grid, i + 1, j);
		
		return count;
	}
	
	public int numIslandsBFS(int[][] grid) {
        int maxArea = 0;
        if (grid.length == 0) return maxArea;
        Queue<int[]> island = new LinkedList<>();
        for (int i = 0 ; i < grid.length; i++){
            for (int j = 0; j < grid[i].length; j++){
                if (grid[i][j] == 1){
                	island.offer(new int[]{i, j});
                    maxArea = Math.max(maxArea, bfs(grid, i, j, island));
                }
            }
        }
        return maxArea;
    }
    
    private int bfs(int[][] grid, int i, int j, Queue<int[]> island){
    	// NOTE- 0,0 is also added to count the island itself
		int[][] dirs = new int[][] { { 0, 0 }, { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        int count = 0;
        while (!island.isEmpty()){
            int size = island.size();
            for (int p = 0; p < size; p++){ // level tracking shouldnt be needed here
                int[] island_coord = island.poll();
                for (int[] dir : dirs){
                    int x = island_coord[0] + dir[0];
                    int y = island_coord[1] + dir[1];
                    if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == 0) continue;
                    grid[x][y] = 0;
                    count++;
                    island.offer(new int[]{x,y});
                }
            }
        }
        return count;
    }
	
	
}
