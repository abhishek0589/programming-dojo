package com.abhishek.dojo.intervals;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 502657147
 *         {@link} https://leetcode.com/problems/interval-list-intersections/
 *         refer to the diagram for more clarity on different use cases
 *
 */
public class IntervalListIntersection {
	public static void main(String[] args) {
		IntervalListIntersection i = new IntervalListIntersection();
		i.intervalIntersection(new int[][] { { 0, 2 }, { 5, 10 }, { 13, 23 }, { 24, 25 } },
				new int[][] { { 1, 5 }, { 8, 12 }, { 15, 24 }, { 25, 26 } });
	}

	public int[][] intervalIntersection(int[][] A, int[][] B) {
		List<Interval> ans = new ArrayList<>();
		int i = 0, j = 0;
		// note while termination
		while (i < A.length && j < B.length) { 
			// intersect. note equals sign. a single point can also be intersection
			if (Math.max(A[i][0], B[j][0]) <= Math.min(A[i][1], B[j][1])) { 
				ans.add(new Interval(Math.max(A[i][0], B[j][0]), Math.min(A[i][1], B[j][1])));
			}
			if (A[i][1] < B[j][1]) {
				i++;
			} else {
				j++;
			}
		}
		int[][] result = new int[ans.size()][2];
		for (int k = 0; k < ans.size(); k++) {
			result[k] = new int[] {ans.get(k).start, ans.get(k).end};
		}
		return result;
	}

	class Interval {
		int start;
		int end;

		Interval(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}
}
