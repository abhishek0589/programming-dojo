package com.abhishek.dojo;

public class TwoDArray {
	public static void main(String[] args) {
		int[][] matrix = { { 1, 0, 1, 0, 1 }, { 1, 1, 0, 0, 0 }, { 0, 1, 0, 1, 1 }, };
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.println(matrix[i][j]);
			}
		}

	}
}
