//https://www.techiedelight.com/reach-bottom-right-corner-matrix-exactly-k-turns/
package com.abhishek.dojo.dp;
//Ways to reach the bottom-right corner of a matrix with exactly k turns allowed
// please note- its *********exactly********* k turns 
public class UniquePathsWithMaxKSteps {

	// M x N matrix
	private static final int M = 3;
	private static final int N = 3; 

	// main function
	public static void main(String[] args) {
		int k = 2;//2
		System.out.print("Total number of ways is " + totalWays(0, 0, k) + "\n");
//		k = 3;//2
//		System.out.print("Total number of ways is " + totalWays(0, 0, k)+ "\n");
//		k = 1;//2
//		System.out.print("Total number of ways is " + totalWays(0, 0, k)+ "\n");
//		k = 0;//0
//		System.out.print("Total number of ways is " + totalWays(0, 0, k)+ "\n");
	}

	// Function to count number of different ways to reach the bottom-right corner
	// of a matrix from its top-left corner with exactly k turns allowed.
	public static int totalWays(int i, int j, int k)
	{
		return totalWays(i + 1, j, k, true) +   // Recur by moving down, i changes
				totalWays(i, j + 1, k, false);  // Recur by moving right, j changes
	}

	// Recursive function to count number of different ways to reach the last
	// cell (M-1,N-1) of a matrix from the given cell (i,j) with k turns left.
	// isCol flag is true when current direction is along column; false otherwise

	public static int totalWays(int i, int j, int k, boolean moveDown)
	{	
		System.out.println("i=>" + i + ", j=>" + j + ", k=>" + k + ", movedown=>" + moveDown + ", k=>" + (k == 0 && i == M - 1 && j == N - 1 ? "1": "continue"));
		if (k == -1 || !(i >= 0 && i < M && j >= 0 && j < N)) {// if number of turns are exhausted or if the cell is invalid
			return 0;
		}

		if (k == 0 && i == M - 1 && j == N - 1) { // if destination is reached with exactly k turns
			return 1;
		}

		if (moveDown) { // if the current direction is along column
			return totalWays(i + 1, j, k, moveDown) + // 1. continue moving down. while moving down, value of k wont change as direction is same 
					totalWays(i, j + 1, k - 1, !moveDown);// 2. turn right and decrement number of turns by 1
		} else {
			return totalWays(i, j + 1, k, moveDown) + // if the current direction is along row, continue moving right
					totalWays(i + 1, j, k - 1, !moveDown); // 2. turn down and decrement number of turns by 1
		}
	}

}


