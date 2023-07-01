package com.abhishek.dojo.dp;

import java.util.TreeSet;

public class LongestConsecutiveSubsequence {

	public static void main(String[] args) {
		LongestConsecutiveSubsequence l = new LongestConsecutiveSubsequence();
		System.out.println(
				l.longestConsecutive(new int[] {100, 4, 200, 1, 3, 2})
				);
	}
	
	public int longestConsecutive(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int num : nums){
            set.add(num);
        }
        int max = Integer.MIN_VALUE, subsequence = 0, i = 0, prev = 0;
        for (int item : set){
            if (i == 0){
                prev = item;
                i++;
                continue;
            }
            int diff = item - prev;
            System.out.println(diff);
            if (diff == 1) {
                max = Math.max(max, ++subsequence);
            } else {
                subsequence = 0;
            }
            prev = item;
        }
        return max + 1;
    }
}
