package com.abhishek.dojo.dp.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subset2 {

	public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>(); List<Integer> cur = new ArrayList<>();
        Arrays.sort(nums); // sort inputs
        backtrack(result, cur, nums, 0);
        return result;
    }
    
    public void backtrack(List<List<Integer>> result, List<Integer> cur, int[] nums, int start){
        result.add(new ArrayList<>(cur));
        for (int i = start; i < nums.length; i++){
            if(i > start && nums[i] == nums[i-1]) // skip duplicates
            	 continue;
            cur.add(nums[i]);
            backtrack(result, cur, nums, i+1);
            cur.remove(cur.size()-1);
        }
    }
}
