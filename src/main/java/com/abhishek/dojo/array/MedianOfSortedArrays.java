package com.abhishek.dojo.array;
// https://leetcode.com/problems/median-of-two-sorted-arrays/
public class MedianOfSortedArrays {
	
	public static void main(String[] args) {
		MedianOfSortedArrays m = new MedianOfSortedArrays();
		System.out.println(m.findMedianSortedArrays(new int[]{1,1}, new int[]{3,4}));
	}
	
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] merged = new int[nums1.length + nums2.length];
        int aid = 0, bid = 0;
        // merge two sorted arrays
        for (int i = 0; i < merged.length; i++){
            boolean amerged = aid == nums1.length, bmerged = bid == nums2.length;
            if (!amerged && (bmerged || nums1[aid] < nums2[bid])){
                merged[i] = nums1[aid];
                aid++;
            } else{
                merged[i] = nums2[bid];
                bid++;
            }
        }
        // get center element(s) in case of odd/ even number of elements and average them as needed
        return merged.length %2 != 0 ? merged[merged.length/2] * 1.0 :  (merged[merged.length/2 - 1] + merged[merged.length/2]) / 2.0;
    }

}
