package com.abhishek.dojo._twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

// tests in SumProblemsTest
public class SumProblems {

	// time complexity- o(nlogn)
	public List<List<Integer>> getAll2SumPairsNLogN(int[] nums, int target) {
		Set<List<Integer>> set = new HashSet<>();
		Arrays.sort(nums);
		int left = 0;
		int right = nums.length - 1;
		while (left < right) {
			if (nums[left] + nums[right] == target) {
				set.add(Arrays.asList(nums[left], nums[right])); // note- count only unique pairs
				left++; right--;
			} else if (nums[left] + nums[right] < target) {
				left++;
			} else if (nums[left] + nums[right] > target) {
				right--;
			}
		}
		return new ArrayList<>(set);
	}

	// time complexity- o(n^2)
	public List<List<Integer>> getAll2SumPairsNSquare(int[] nums, int target) {
		Set<List<Integer>> set = new HashSet<>();
		// run outer loop 1 less time
		for (int i = 0; i < nums.length - 1; i++) {
			// run inner loop from i + 1 till whole length of array
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] + nums[j] == target && i != j) {
					set.add(Arrays.asList(nums[i], nums[j]));
				}
			}
		}
		return new ArrayList<>(set);
	}

	// Questions-
	// Whats size of array?
	// Does array contain duplicates?
	// Any negative numbers?

	// https://leetcode.com/problems/3sum/
	public List<List<Integer>> getAll3SumPairs(int nums[], int target){
		Set<List<Integer>> set = new HashSet<>();
		Arrays.sort(nums);
		for (int i = 0; i < nums.length -2; i++) {
			int j = i + 1, k = nums.length - 1;
			int temp_target = target - nums[i];
			while (j < k) {
				if (nums[j] + nums[k] == temp_target) {
					set.add(Arrays.asList(nums[i], nums[j], nums[k])); // note- count only unique pairs
					j++; k--;
				} else if (nums[j] + nums[k] < temp_target) {
					j++;
				} else {
					k--;
				}
			}
		}
		return new ArrayList<>(set);
	}


	// amazon online
	// approach - 2 (fast- due to hashmap search)
	// Runtime: 3 ms, faster than 51.65% of Java online submissions for Two Sum.
	// Memory Usage: 36.6 MB, less than 99.48% of Java online submissions for Two Sum.

	public List<List<Integer>> getClosestSumPairsDiffrentArrays(List<int[]> a, List<int[]> b, int target) {
		// a -> smallest -> largest, b -> smallest -> largest
		Collections.sort(a, (i, j) -> i[1] - j[1]); Collections.sort(b, (i, j) -> i[1] - j[1]);
		List<List<Integer>> result = new ArrayList<>();
		int max = Integer.MIN_VALUE;
		int i = 0, j = b.size() - 1;

		while (i < a.size() && j >= 0) {
			int sum = a.get(i)[1] + b.get(j)[1];
			if (sum < target) {
				if (max <= sum) { // if max is greater than current sum, don't process the pair scan next
					// logic to find closest sum- also discards lesser values 
					// and keeps highest closes match lesser than sum
					if (max < sum) {
						max = sum;
						result.clear();
					}// logic end.
					result.add(Arrays.asList(a.get(i)[0], b.get(j)[0]));
					int index = j-1;
					// add duplicates from 2nd array in result
					// question- why j isnt modified at same time?
					while(index >=0 && b.get(index)[1] == b.get(index+1)[1]) {
						result.add(Arrays.asList(a.get(i)[0], b.get(index)[0]));
						index--;
					}
				}
				++i; // increment i to see if there is any other pair
			} else {
				--j; // decrement j to get a lesser value from 2nd array
			}
		}
		return result;
	}

	// https://leetcode.com/problems/two-sum-less-than-k/
	public int[] getClosestSumPairsSameArray(int nums[], int target) {
		int left = 0, right = nums.length - 1, sum = 0, max = Integer.MIN_VALUE;
		int[] indices = new int[2];
		Arrays.sort(nums);
		while (left < right) {
			sum = nums[left] + nums[right];
			if (sum <= target) {
				if (max < sum) {
					max = sum;
					indices = new int[] { nums[left], nums[right] };
				}
				left++;
			} else {
				right--;
			}
		}
		return indices;
	}

	// https://leetcode.com/problems/k-diff-pairs-in-an-array/
	public int getKDiffPairs(int[] nums, int k) {
		// a - b = k. we need to check if array has a and a+k pairs
		// edge case- if difference is negative or no numbers provided, return 0
		// important questions- what if a number is repeating multiple times [1,1,1,4,5,1,1,1] and k = 0;
		if( k < 0 || nums.length < 1 ) return 0;
		Set<Integer> set1 = new HashSet <>(), set2 = new HashSet <>();
		if (k == 0){ //diff is zero just scan for duplicates
			for (int num : nums) {
				if (!set1.add(num)){ // add method returns a boolean
					set2.add(num);
				}
			}
		}
		else{// non zero diff- first set keeps all numbers, another set contains number + k entries
			for (int i : nums){
				set1.add(i);
				set2.add(i+k);
			}
			set2.retainAll(set1);
		}
		return set2.size();
	}

	// https://leetcode.com/problems/two-sum
	// approach - 1 (slow- due to list based search)
	public int[] getOne2SumPairList(int[] nums, int target) {
		if (nums.length < 2){
			return new int[]{};
		}
		// static array of length 2
		int[] indices = new int[2];
		// create a list from numbers to match against diff
		List<Integer> list = new LinkedList<>();
		for (int num : nums){
			list.add(num);
		}
		// find diff/the other number
		for (int i = 0; i < nums.length; i++){
			int index = list.indexOf(target-nums[i]);
			if (index != -1 && // element found
					i != index //double counting- array has 12 and diff provided was 24. hence single element will be counted twice
					){ 
				indices[0] = index;    
				indices[1] = i;
				break;
			}
		}
		return indices;
	}

	// https://leetcode.com/problems/two-sum/
	public int[] getOne2SumPairMap(int[] nums, int target) {
		if (nums.length < 2){
			return new int[]{};
		}
		// static array of length 2
		int[] indices = new int[2];
		Map<Integer, Integer> map = new HashMap<>();
		for (int pos = 0; pos < nums.length; pos++){
			map.put(nums[pos], pos);
		}
		// find diff/the other number
		for (int i = 0; i < nums.length; i++){ 
			if (map.containsKey(target-nums[i])){
				int index = map.get(target-nums[i]);
				if (i != index){ //avoid double counting. array has 12 and diff provided was 24. 
					indices[0] = index;    
					indices[1] = i;
					break;
				}
			}
		}
		return indices;
	} 

}
