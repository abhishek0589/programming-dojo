package com.abhishek.dojo.intervals;

/*
REFER leetcode rectangular picture to refer what ABCDEFG indicates

223. Rectangle Area- https://leetcode.com/problems/rectangle-area/

Find the total area covered by two rectilinear rectangles in a 2D plane.
Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.
Rectangle Area
Example: Input: A = -3, B = 0, C = 3, D = 4, E = 0, F = -1, G = 9, H = 2
Output: 45
Note: Assume that the total area is never beyond the maximum possible value of int.

*/
public class RectangularOverlapArea {
	
	public static void main(String[] args) {
		RectangularOverlapArea ra = new RectangularOverlapArea();
		System.out.println(
				ra.computeArea(-3,0,3,4,0,-1,9,2)
				);
	}
	
	public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int common_area = 0;
        if (Math.max(A,E) < Math.min(C,G) && Math.max(B,F) < Math.min(D,H)){
            int xoverlap = Math.min(C,G)- Math.max(A,E);
            int yoverlap = Math.min(H, D)- Math.max(B,F);
            common_area =  xoverlap * yoverlap;    
        }
        return (C - A) * (D - B) + (G - E) * (H - F) - common_area;
    }
}
