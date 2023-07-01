package com.abhishek.dojo.dfsbfs;

import java.util.Arrays;

/**
 * key things to remember-
 * 
 * Cell state- 0 -> gate -1-> wall infinity-> room
 * 
 * 1. Data structure- 1. 2D array
 * 
 * 2. Logic- 
 * 		1. Iterate through 2D array and find an island (1) 
 * 		2. Once found an island, scan for connected islands 
 * 		3. Scan connected islands 
 * 			1. Return execution if 
 * 				a. corners are outside indices or 
 * 				b. if current cell value is less than distance (simply means that existing identified distance is shorter) 
 * 			2. Update cell position to be 'count' so that you dont keep recount
 * 			3. Scan around 
 * 			4. Return one
 * 
 * 3. Runtime complexity- 
 * 		1. As we are iterating through all the elements, run complexity is O(m*n)
 * 
 * 4. Space complexity- 1. No extra space hence constant
 * 
 * 5. LeetCode-
 * 		286. https://leetcode.com/problems/walls-and-gates/
 * 		62 / 62 test cases passed.
 * 
 */

public class WallsAndGates {
	public static void main(String[] args) {
		int[][] rooms = new int[][] { 
			{ 2147483647, -1, 0, 2147483647 }, 
			{ 2147483647, 2147483647, 2147483647, -1 },
			{ 2147483647, -1, 2147483647, -1 }, 
			{ 0, -1, 2147483647, 2147483647 } };
			
			/**
			[[3, -1, 0, 1], 
			 [2, 2, 1, -1], 
			 [1, -1, 2, -1], 
			 [0, -1, 3, 4]]
			*/
					
		for (int i = 0; i < rooms.length; i++) {
			for (int j = 0; j < rooms[i].length; j++) {
				if (rooms[i][j] == 0) { // found a gate, now count distance
					scanForRooms(rooms, i, j, 0);
				}
			}
		}
		System.out.println(Arrays.deepToString(rooms));
	}

	private static void scanForRooms(int[][] rooms, int i, int j, int distance) {
		// 1. rejection block
		if (i < 0 || i >= rooms.length || j < 0 || j >= rooms[i].length || rooms[i][j] < distance) {
			return;
		}
		// 2. update distance
		rooms[i][j] = distance;
		// 3. scan
		// Note- These are not just 4 scans- its recursion. Each method will scan
		// further inside 4 times unless control is returned
		scanForRooms(rooms, i + 1, j, distance + 1);
		scanForRooms(rooms, i - 1, j, distance + 1);
		scanForRooms(rooms, i, j + 1, distance + 1);
		scanForRooms(rooms, i, j - 1, distance + 1);
	}
}