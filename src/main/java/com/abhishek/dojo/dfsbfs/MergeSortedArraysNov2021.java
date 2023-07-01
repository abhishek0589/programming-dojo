package com.abhishek.dojo.dfsbfs;

import java.util.Arrays;

public class MergeSortedArraysNov2021 {

	public static void main(String[] args) {
		int[] a = new int[] {-2,3,7};
		int[] b = new int[] {-4,5,9,10};
		int[] m = new int[a.length + b.length];
		int ai = 0; int bi = 0;		
		int count = 0;
		while (count < m.length) {
			if (bi >= b.length || (ai < a.length && a[ai] < b[bi])) {
				m[count] = a[ai];
				ai++;
				count++;
			}
			else if (ai >= a.length || (bi < b.length && b[bi] < a[ai])) {
				m[count] = b[bi];
				bi++;
				count++;
			}
		}
		Arrays.stream(m).forEach(System.out::println);
	}
}
