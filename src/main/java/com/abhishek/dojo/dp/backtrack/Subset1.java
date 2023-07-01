package com.abhishek.dojo.dp.backtrack;

import java.util.ArrayList;
import java.util.List;

public class Subset1 {
	
	public static void main(String[] args) {
		Subset1 s = new Subset1();
		s.subsets(new int[] {1,2});
	}

	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> result = new ArrayList<>(); List<Integer> cur = new ArrayList<>();
		backtrack(result, cur, nums, 0);
		return result;
	}

	public void backtrack(List<List<Integer>> result, List<Integer> cur, int[] nums, int start){
		result.add(new ArrayList<>(cur));
		for (int i = start; i < nums.length; i++) {
			cur.add(nums[i]);
			backtrack(result, cur, nums, i+1);
			cur.remove(cur.size()-1);
		}
	}
}
