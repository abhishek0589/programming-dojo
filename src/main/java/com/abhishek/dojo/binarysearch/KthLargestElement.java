package com.abhishek.dojo.binarysearch;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthLargestElement {

	public static void main(String[] args) {
		int[] nums = {5,8,12,14,16,1,-1,0};
		int k =2;
		System.out.println(k + "th largest element is: " + kthLargest(nums, k));
		System.out.println(k + "th smallest element is: " + kthSmallest(nums, k));

	}

	public static int kthLargest(int[] nums, int k) {
		// priority queue- stores elements according to natural sorting order
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for(int num : nums) {
			pq.offer(num);
			if (pq.size() > k) {
				//First in first out- opposite to stack (remove smallest)
				pq.poll();
			}
		}
		// return kth largest item (first element in queue)
		return pq.peek();
	}

	public static int kthSmallest(int[] nums, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(nums.length, Collections.reverseOrder());
		for(int num : nums) {
			pq.offer(num);
			if (pq.size() > k) {
				pq.poll();
			}
		}
		return pq.peek();
	}
}
