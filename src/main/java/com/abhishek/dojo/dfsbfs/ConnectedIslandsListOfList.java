package com.abhishek.dojo.dfsbfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

public class ConnectedIslandsListOfList {
	public static void main(String[] args) {
		List<List<Integer>> grid = new ArrayList<>();
		List<Integer> sublist = new ArrayList<>();
		sublist = Arrays.asList(1,1,0,0,1); grid.add(sublist);
		sublist = Arrays.asList(1,1,0,0,0); grid.add(sublist);
		sublist = Arrays.asList(0,0,1,1,1); grid.add(sublist);
		sublist = Arrays.asList(0,0,0,1,1); grid.add(sublist);
		System.out.println("Number of connected islands => " + numIslands(grid));
	}

	public static int numIslands(List<List<Integer>> grid) {
		int count = 0;
		if ( grid == null || grid.size() == 0) {
			return count;
		}
		for (int i = 0; i < grid.size(); i++) {
			for (int j = 0; j < grid.get(i).size(); j++) {
				if (grid.get(i).get(j) == 1) {
					count ++;
					scanForConnectedIslands(grid, i, j);
				}
			}
		}
		return count;
	}

	public static void scanForConnectedIslands(List<List<Integer>> grid, int i, int j) {
		// 1. rejection block
		if ((i < 0 || i >= grid.size() || j < 0 || j >= grid.get(i).size()) || grid.get(i).get(j) == 0) {
			return;
		}
		// 2. update visited
		grid.get(i).set(j, 0);
		// 3. scan
		scanForConnectedIslands(grid, i, j - 1);
		scanForConnectedIslands(grid, i, j + 1);
		scanForConnectedIslands(grid, i - 1, j);
		scanForConnectedIslands(grid, i + 1, j);
	}
}
