package com.abhishek.dojo.dp.backtrack;

import java.util.ArrayList;
import java.util.List;
/*

39. Combination Sum
Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), 
find all unique combinations in candidates where the candidate numbers sums to target.
The same repeated number may be chosen from candidates unlimited number of times.

Note:All numbers (including target) will be positive integers. The solution set must not contain duplicate combinations.

Example 1: Input: candidates = [2,3,6,7], target = 7,
A solution set is: [[7], [2,2,3]]

Example 2: Input: candidates = [2,3,5], target = 8,
A solution set is: [[2,2,2,2], [2,3,3], [3,5]]

 */
public class CombinationSum1 {

	public static void main(String[] args) {
		CombinationSum1 c = new CombinationSum1();
		c.combinationSum(new int[] {2,3,5}, 9);
	}

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		if (candidates == null || candidates.length == 0) return new ArrayList<List<Integer>>();
		// Arrays.sort(candidates); // no sort needed as array elements gonna be sorted
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> cur = new ArrayList<>();
		backtrack(result, cur, candidates, 0, target);
		return result;   
	}

	public void backtrack(List<List<Integer>> result, List<Integer> cur, int[] nums, int start, int target){
		if (target == 0){
			List<Integer> temp = new ArrayList<>(cur);
			result.add(temp);
			return;
		}
		else if (target > 0){
			for (int i = start; i < nums.length; i++){
				cur.add(nums[i]);
				// print decision space tree
				// System.out.println("num is : " + nums[i] + " target is " + (target-nums[i]));
				backtrack(result, cur, nums, i, target-nums[i]);
				cur.remove(cur.size()-1);
			}
		}
	}
}
