package com.abhishek.dojo.array;

public class MergeTwoSortedArrays {

	
	// combine the sorted arrays into one large sorted array
	public static int[] mergeArrays(int[] firstArr, int[] secondArr) {
		int[] mergedArr = new int[firstArr.length + secondArr.length];
		int currMergedArrIdx = 0;
		int a1Idx = 0;
		int a2Idx = 0;

		while (currMergedArrIdx < mergedArr.length) {
			boolean a1Exhausted = a1Idx >= firstArr.length;
			boolean a2Exhausted = a2Idx >= secondArr.length;

			// first array is not exhausted AND
			// second array is either exhausted OR firstArrayElement is less than or equal
			// to second array element

			if (!a1Exhausted
					&& (a2Exhausted || firstArr[a1Idx] <= secondArr[a2Idx])) {
				mergedArr[currMergedArrIdx] = firstArr[a1Idx];
				a1Idx++;
			} else {
				mergedArr[currMergedArrIdx] = secondArr[a2Idx];
				a2Idx++;
			}
			currMergedArrIdx++;
		}
		return mergedArr;
	}

	public static void main(String[] args) {
		MergeTwoSortedArrays m = new MergeTwoSortedArrays();
		m.merge(new int[] {1,2,3,0,0,0}, 3, new int[] {2,5,6},  2);
	}
	
	public int[] merge(int[] nums1, int m, int[] nums2, int n) {
		int n1i = 0, n2i = 0, n1Counter = 1;
		int[] r = new int[nums1.length];
		for (int i = 0; i < r.length; i++){
			boolean n1f = n1i == nums1.length || n1Counter > m;
			boolean n2f = n2i == nums2.length;
			if (!n1f && (n2f || nums1[n1i] < nums2[n2i])){
				r[i] =  nums1[n1i++];
				n1Counter++;
				System.out.println("merged from arr1: " + r[i]);
			}
			else{
				r[i] = nums2[n2i++];
				System.out.println("merged from arr2:" + r[i] + ", n2i-" + n2i+ ", n1i-" + n1i);
			}
		}
		return r;
	}


}
