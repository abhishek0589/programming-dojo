package com.abhishek.dojo.array;

import java.util.PriorityQueue;

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */

public class MedianOfDataStream {

	PriorityQueue<Integer> maxHeap, minHeap;

	public MedianOfDataStream() {
		maxHeap = new PriorityQueue<>((a,b)->b-a);
		minHeap = new PriorityQueue<>();
	}

	public void addNum(int num) {
		if (maxHeap.size() == 0 || num < maxHeap.peek()){
			maxHeap.offer(num);
		} else{
			minHeap.offer(num);
		}
		balanceHeaps();
	}

	public void balanceHeaps(){
		if (Math.abs(maxHeap.size() - minHeap.size()) > 1){
			if (maxHeap.size()  > minHeap.size()){
				minHeap.offer(maxHeap.poll());
			} else {
				maxHeap.offer(minHeap.poll());
			}
		}
	}

	public double findMedian() {
		if (Math.abs(maxHeap.size() - minHeap.size()) > 0){
			if (maxHeap.size()  > minHeap.size()){
				return maxHeap.peek();
			} else {
				return minHeap.peek();
			}
		} else {
			return (maxHeap.peek() + minHeap.peek())/2.0;
		}
	}
}


