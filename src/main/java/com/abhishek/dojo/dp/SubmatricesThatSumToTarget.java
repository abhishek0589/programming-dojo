package com.abhishek.dojo.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SubmatricesThatSumToTarget {

	public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int rows = matrix.length, cols = matrix[0].length, count = 0;
        int[] runningSum = new int[rows];// why rows and why not cols?
        for (int i = 0; i < cols; i++){ // Begin column
            Arrays.fill(runningSum, 0);
            for (int j = i; j < cols; j++){ // end column
                for (int k =0; k < rows; k++){
                    runningSum[k] += matrix[k][j]; // get prefix sum of each column
                }
                System.out.println(runningSum[0] + " " + runningSum[1]);
                count += subarraySum(runningSum, target);
            }
        }
        return count;
    }
    
    // get prefix sum of each row
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
		int count = 0, sum = 0;
		map.put(0, 1);
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			count += map.get(sum - k) != null ? map.get(sum - k) : 0;
			map.compute(sum, (key, val) -> val == null ? 1 : val + 1);
		}
		return count;
    }
}
