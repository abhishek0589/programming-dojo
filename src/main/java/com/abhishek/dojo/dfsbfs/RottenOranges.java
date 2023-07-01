package com.abhishek.dojo.dfsbfs;

/**
994. Rotting Oranges- https://leetcode.com/problems/rotting-oranges/

In a given grid, each cell can have one of three values:
	-the value 0 representing an empty cell;
	-the value 1 representing a fresh orange;
	-the value 2 representing a rotten orange.
Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.
Return the minimum number of minutes that must elapse until no cell has a fresh orange.  
If this is impossible, return -1 instead.

**/

import java.util.LinkedList;
import java.util.Queue;

// minute 1 scan- all points having rotten eggs
// minute 2 scan- all points which got added in above step
public class RottenOranges {
	public static void main(String[] args) {
		RottenOranges r = new RottenOranges();
		int[][] grid = new int[][] {{1,2,2,1,2}, {1,2,1,2,1}, {1,1,1,1,2}, {1,2,1,1,1}};
		System.out.println(r.orangesRotting(grid));
	}
	public int orangesRotting(int[][] grid) {
		Queue<int[]> queue = new LinkedList<>();
		int rows = grid.length, cols = grid[0].length;
		int count_fresh = 0;

		if(grid == null || grid.length == 0) 
			return 0;

		//Put the position of all rotten oranges in queue, count the number of fresh oranges
		for(int i = 0 ; i < rows ; i++) {
			for(int j = 0 ; j < cols ; j++) {
				if(grid[i][j] == 2) {
					queue.offer(new int[]{i , j});
				}
				else if(grid[i][j] == 1) {
					count_fresh++;
				}
			}
		}

		//if count of fresh oranges is zero --> return 0 
		if(count_fresh == 0) return 0;

		int minutes = 0;
		int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
		while(!queue.isEmpty()) {//bfs starting from initially rotten oranges
			int size = queue.size();
			++minutes;
			for(int i = 0 ; i < size ; i++) {
				int[] point = queue.poll();
				for(int dir[] : dirs) {
					int x = point[0] + dir[0], y = point[1] + dir[1];
					//if x or y is out of bound || or the orange at (x , y) is already rotten || or the cell at (x , y) is empty
					if(x < 0 || y < 0 || x >= rows || y >= cols || grid[x][y] == 0 || grid[x][y] == 2) continue;
					grid[x][y] = 2; //mark the orange at (x , y) as rotten
					queue.offer(new int[]{x , y}); //put the new rotten orange at (x , y) in queue
					count_fresh--; //decrease the count of fresh oranges by 1
				}
			}
		}
		return count_fresh == 0 ? minutes-1 : -1;
	}
}
