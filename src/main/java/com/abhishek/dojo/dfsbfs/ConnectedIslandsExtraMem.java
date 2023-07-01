package com.abhishek.dojo.dfsbfs;

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
*/
public class ConnectedIslandsExtraMem {
	
	public static void main(String[] args) {
		char[][] grid = {{ '1', '1', '0', '0', '1' }, { '1', '1', '0', '0', '0' }, { '0', '0', '1', '1', '1' }, { '0', '0', '0', '1', '1' }};
		System.out.println("Number of connected islands => " + numIslands(grid));
	}

	public static int numIslands(char[][] grid) {
		int count = 0;
		if (grid.length == 0) {
			return count;
		}
		boolean[][] visited = new boolean[grid.length][grid[0].length];
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == '1' && !visited[i][j]) {
					count += scanForConnectedIslands(grid, i, j, visited);
				}
			}
		}
		return count;
	}

	public static int scanForConnectedIslands(char[][] grid, int i, int j, boolean[][] visited) {
		// boundary validations. Use ORs
		if ((i < 0 || i >= grid.length || j < 0 || j >= grid[i].length) || visited[i][j] || grid[i][j] == '0') {
			return 0;
		}
		// if control enters here, it means item is '1' and we can just mark it visited
		visited[i][j] = true;
		// Note- These are not just 4 scans- its recursion. Each method will scan further inside 4 times unless control is returned
		scanForConnectedIslands(grid, i, j - 1, visited);
		scanForConnectedIslands(grid, i, j + 1, visited);
		scanForConnectedIslands(grid, i - 1, j, visited);
		scanForConnectedIslands(grid, i + 1, j, visited);
		return 1;
	}
	
	
}
