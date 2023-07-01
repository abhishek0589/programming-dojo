package com.abhishek.dojo.misc;
/*
 * https://leetcode.com/discuss/interview-question/344677
https://leetcode.com/problems/minimum-cost-to-connect-sticks (premium)

Given n ropes of different lengths, we need to connect these ropes into one rope. 
We can connect only 2 ropes at a time. 
The cost required to connect 2 ropes is equal to sum of their lengths. 
The length of this connected rope is also equal to the sum of their lengths. 
This process is repeated until n ropes are connected into a single rope. 
Find the min possible cost required to connect all ropes.

Input: ropes = [8, 4, 6, 12]
Output: 58
Explanation: The optimal way to connect ropes is as follows
1. Connect the ropes of length 4 and 6 (cost is 10). Ropes after connecting: [8, 10, 12]
2. Connect the ropes of length 8 and 10 (cost is 18). Ropes after connecting: [18, 12]
3. Connect the ropes of length 18 and 12 (cost is 30).
Total cost to connect the ropes is 10 + 18 + 30 = 58


*/

import java.util.PriorityQueue;

public class MinCostToConnectRopes {
	public static void main(String[] args) {
		MinCostToConnectRopes m = new MinCostToConnectRopes();
		m.getMinCost(new int[] {20, 4, 8, 2});
	}
	
	public int getMinCost(int[] nums) {
		PriorityQueue<Integer> q = new PriorityQueue<>();
		for (int num : nums) {
			q.add(num);
		}
		// 2 4 8
		int cost = 0, totalCost = 0;
		while (q.size() > 1) {
			Integer item1 = q.poll();
			Integer item2 = q.poll();
			cost = item1 + item2;
			q.add(cost); // put the result back in queue
			totalCost += cost;
			System.out.println(totalCost);
		}
		return totalCost;
	}
}
