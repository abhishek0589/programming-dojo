package com.abhishek.dojo.binarysearch;

import java.util.Arrays;

public class SearchIntegerIn2DMatrix {

	public boolean searchMatrix(int[][] matrix, int target) {
		int targetRow = 0;
		if (matrix == null || matrix.length == 0) return false;
        for (int i = 0 ; i < matrix.length && matrix[i].length != 0; i++) if (target >= matrix[i][0]) targetRow = i;
		return Arrays.binarySearch(matrix[targetRow], target) > -1;
    }
	
	public static void main(String[] args) {
		SearchIntegerIn2DMatrix s = new SearchIntegerIn2DMatrix();
		
		int[][] matrix = {
		          {1,3,5,7},
		          {10,11,16,20},
		          {23,30,34,50}
		          };
		System.out.println(s.searchMatrix(matrix, 13));
	}
}
