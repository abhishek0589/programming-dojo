package com.abhishek.dojo.dp.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
40. Combination Sum II

Given a collection of candidate numbers (candidates) and a target number (target), 
find all unique combinations in candidates where the candidate numbers sums to target.
Each number in candidates may only be used once in the combination.

Note: All numbers (including target) will be positive integers. The solution set must not contain duplicate combinations.
Example 1: Input: candidates = [10,1,2,7,6,1,5], target = 8,
A solution set is: [[1, 7], [1, 2, 5], [2, 6], [1, 1, 6]]

Example 2: Input: candidates = [2,5,2,1,2], target = 5,
A solution set is: [[1,2,2], [5]]

 */
public class CombinationSum2 {

	public static void main(String[] args) {
		CombinationSum2 c = new CombinationSum2();
		int[] candidates = new int[] { 1, -1, 0, 1, 2, 1, 4, -11, -3, 1, 3, 4 };
		int target = 0;
		c.combinationSum2(candidates, target);
	}
	
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		if (candidates == null || candidates.length == 0) return new ArrayList<List<Integer>>();
		Arrays.sort(candidates); // why are we sorting?
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> cur = new ArrayList<>();
		backtrack(result, cur, candidates, 0, target);
		return result;  
	}

	public void backtrack(List<List<Integer>> result, List<Integer> cur, int[] nums, int start, int target){
		if (target == 0 && cur.size() > 0){
			result.add(new ArrayList<>(cur)); // to avoid shallow copy
			System.out.println("\n");
			cur.forEach(x -> System.out.print(x + " "));
			return;
		}
		else if (target > 0){
			for (int i = start; i < nums.length; i++){
				if ( i > start && nums[i] == nums[i-1]) continue; // new- skip duplicates 
				cur.add(nums[i]);
				backtrack(result, cur, nums, i + 1, target-nums[i]); // new- dont pick same index hence i+1
				cur.remove(cur.size()-1);
			}
		}
	}

}
