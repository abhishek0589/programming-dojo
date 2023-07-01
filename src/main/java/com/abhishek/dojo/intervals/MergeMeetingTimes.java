package com.abhishek.dojo.intervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// LC- 169 / 169 test cases passed
// Runtime: 42 ms, faster than 5.92% of Java online submissions for Merge Intervals.
// Memory Usage: 46.2 MB, less than 15.22% of Java online submissions for Merge Intervals.

public class MergeMeetingTimes {

	class Interval{
        int start;
        int end;
        Interval(int start, int end){
            this.start= start;
            this.end = end;
        }
    }
    
    public int[][] merge(int[][] intervals) {
		List<Interval> ints = new ArrayList<>();
		for (int i = 0; i < intervals.length ; i ++) {
			ints.add(new Interval(intervals[i][0], intervals[i][1]));
		}
		merge(ints);
		int[][] result = new int[ints.size()][2];
		for (int k = 0; k < ints.size(); k++) {
			result[k] = new int[] {ints.get(k).start, ints.get(k).end};
		}
		return result;
	}

	public List<Interval> merge(List<Interval> intervals) {

		if (intervals.size() < 0)
			return null;
        
        Collections.sort(intervals, (a, b) -> a.start - b.start); //sort by start
        
        // iterate the loop only till last but one element as we are doing i+1 in logic
		for (int i = 0; i < intervals.size() - 1; i++) {
			if (intervals.get(i).end >= intervals.get(i + 1).start) {
				intervals.get(i).end = Math.max(intervals.get(i).end, intervals.get(i+1).end);
                intervals.remove(i+1);
                i--;
			} 
		}
		return intervals;
	}
}