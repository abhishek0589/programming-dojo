package com.abhishek.dojo.intervals;

// https://leetcode.com/problems/largest-rectangle-in-histogram/solution/
public class LargestRectangleInHistogram {

	// this is just bruteforce, refer leetcode optimized solutions for more details
	public int largestRectangleArea(int[] heights) {
		int maxarea = 0;
		for (int i = 0; i < heights.length; i++) {
			for (int j = i; j < heights.length; j++) {
				int minheight = Integer.MAX_VALUE;
				for (int k = i; k <= j; k++)
					minheight = Math.min(minheight, heights[k]);
				maxarea = Math.max(maxarea, minheight * (j - i + 1));
			}
		}
		return maxarea;
	}

}
