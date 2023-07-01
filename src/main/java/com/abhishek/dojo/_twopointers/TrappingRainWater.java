package com.abhishek.dojo._twopointers;

// LC- 315 / 315 test cases passed.
// Runtime: 1 ms, faster than 98.27% of Java online submissions for Trapping Rain Water.
// Memory Usage: 36 MB, less than 100.00% of Java online submissions for Trapping Rain Water.

/** IMPORTANT TO GO THROUGH ALL THREE APPROACHES **/

public class TrappingRainWater {
	public static void main(String[] args) {
		TrappingRainWater t = new TrappingRainWater();
		System.out.println(t.trap_quadratic(new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, }));
		System.out.println(t.trap_linear(new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, }));
		System.out.println(t.trap_logarithmic(new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, }));
	}

	// approach 1- at each index, calculate max on left and max on right (dont include that index)
	// water that can be stored = min (leftMax, rightMax) - building height
	// o(n^2)
	public int trap_quadratic(int[] height) {
		int result = 0, leftMax = Integer.MIN_VALUE, rightMax = Integer.MIN_VALUE;
		for (int i = 0; i < height.length; i++) {
			leftMax = calculateMax(0, i, height);
			rightMax = calculateMax(i+1, height.length, height);
			int min = Math.min(leftMax, rightMax);
			if (min > height[i])
				result += min - height[i];
		}
		return result;
	}

	private int calculateMax(int begin, int end, int[] height) {
		int max = 0;
		for (int i = begin; i < end; i++) {
			max = Math.max(max, height[i]);
		}
		return max;
	}

	// o(n) avoid calculation of index in n^2 way and linearize same- comes at cost of space complexity
	public int trap_linear(int[] height) {
		int result = 0;
		int leftMaxAtEachIndex[] = new int[height.length], rightMaxAtEachIndex[] = new int[height.length];

		// we need to hard-code at 0 to enable math.max movement
		// subsequent movements- 1 to length
		leftMaxAtEachIndex[0] = height[0]; 
		for (int i = 1; i < height.length; i++) 
			leftMaxAtEachIndex[i] = Math.max(height[i], leftMaxAtEachIndex[i - 1]);
		
		// we need to hard-code last value to enable math.max movement
		// subsequent movements- array length - 2 till 0th index
		rightMaxAtEachIndex[height.length - 1] = height[height.length - 1];
		for (int i = height.length - 2; i >= 0; i--) 
			rightMaxAtEachIndex[i] = Math.max(rightMaxAtEachIndex[i+1], height[i]);

		for (int i = 0; i < height.length; i++) {
			int min = Math.min(leftMaxAtEachIndex[i], rightMaxAtEachIndex[i]);
			if (min > height[i])
				result += min - height[i];
		}
		return result;
	}

	// approach 3- fully optimized solution

	/*
	  
	  As in Approach 2, instead of computing the left and right parts separately,
	  we may think of some way to do it in one iteration. 
	  
	  From the figure in dynamic programming approach, notice that 
	  
	  1. as long as right_max[i] > left_max[i] (from element 0 to 6), the water trapped depends upon the left_max,
	   
	  2. similar is the case when left_max[i] > right_max[i] (from element 8 to 11) it depends on right_max
	  
	  3. So, we can say that if there is a larger bar at one end (say right), we are assured that the water 
	  trapped would be dependent on height of bar in current direction (from left to right). 
	  
	  4. As soon as we find the bar at other end (right) is smaller, we start iterating in opposite
	  direction (from right to left). 
	  
	  5. We must maintain left_max and right_max during the iteration, but now we can do it in one
	  iteration using 2 pointers, switching between the two.
	  
	 */
	
	public int trap_logarithmic(int[] height) {
		// edge case- no water can be trapped if there are only two consecutive or less bars
		if (height.length <= 2) { 
			return 0;
		}
		int leftMax = Integer.MIN_VALUE, rightMax = Integer.MIN_VALUE;
		int left = 0, right = height.length - 1, result = 0;
		while (left < right) {
			leftMax = Math.max(leftMax, height[left]);
			rightMax = Math.max(rightMax, height[right]);
			// always go ahead with shorter left/right max
			// question- why are we moving in below order only?
			if (leftMax < rightMax) {
				result += leftMax - height[left]; 
				left++;
			} else { // right is shorter
				result += rightMax - height[right];
				right--;
			}
		}
		return result;
	}
}
