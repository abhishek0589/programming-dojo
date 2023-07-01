package com.abhishek.dojo.design;
// quick sort gives best average time complexity for sorting with no extra memory
// merge sort also gives best average time complexity nlogn but needs extra space
public class QuickSort {
	
	public static void main(String[] args) {
		QuickSort q = new QuickSort();
		int[] arr = {3,1,4,7,6,9,8};
		q.quickSort(arr, 0, arr.length-1);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
	
	public void quickSort(int arr[], int begin, int end) {
		// repeat the process till begin < end. forms base case of recursion
	    if (begin < end) {
	        int partitionIndex = partition(arr, begin, end);
	        // notice how begin and end are changed
	        quickSort(arr, begin, partitionIndex-1);
	        quickSort(arr, partitionIndex+1, end);
	    }
	}
	
	private int partition(int arr[], int begin, int end) {
		// consider pivot as end of the array
	    int pivot = arr[end];
	    
	    // point i to the start of the array
	    int i = (begin-1);
	 
	    // move j from i till one index before pivot
	    // key objective- we need to have smaller elements at the begining of array and larger ones at end of the array
	    // we compare arr[j] with pivot. If arr[j] is less than pivot it means the item needs to be thrown at left (current positon of i)
	    // after every iteration, left half would be almost sorted and would be lesser than right half. Two halves will be almost sorted within themselves
	    // this logic can be eventually used to find kth largest or kth smallest element
	    // repeat this process till 
	    for (int j = begin; j < end; j++) {
	        if (arr[j] <= pivot) {
	            i++;
	            int swapTemp = arr[i];
	            arr[i] = arr[j];
	            arr[j] = swapTemp;
	        }
	    }
	 
	    //swap pivot with i+1
	    int swapTemp = arr[i+1];
	    arr[i+1] = arr[end];
	    arr[end] = swapTemp;
	 
	    // return i+1 and begin search again 
	    return i+1;
	}
}