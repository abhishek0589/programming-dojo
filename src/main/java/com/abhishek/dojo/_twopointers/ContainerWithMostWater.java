package com.abhishek.dojo._twopointers;

public class ContainerWithMostWater {
	
	// algo
	// find shorter sticks between left and right and multiply diff of height 
	// with diff of left and right position to get respective area
	public int maxArea(int[] height) {
		int left = 0, right = height.length -1, maxArea = 0;
		while (left < right) {
 			int minStickHeight = Math.min(left,  right);
 			int area = minStickHeight * (right-left);
 			maxArea = Math.max(maxArea, area);
 			// question- why are we moving in below order only?
 			
 			// Explanation- move the pointer with shorter line inwards 
 			// this is because, if we instead move longer line inwards, then we are still limited by shorter line
 			// and there may not be significant increase in area
 			// However, if we move shorter line inwards, there is possibility that line after shorter line is 
 			// may be bigger (and still would be lowest between left and right). This would result into 
 			// significant increase in the area
 			
 			// refer leetcode explanation for more details
 			// https://leetcode.com/problems/container-with-most-water/solution/
 			if (height[left] < height[right]) {
 				left++;
 			} else {
 				right--;
 			}
		}
		return maxArea;
	}

		
}
