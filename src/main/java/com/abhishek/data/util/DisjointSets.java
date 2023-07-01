package com.abhishek.data.util;

import java.util.Arrays;
// algo to convert dis-joint data set to joint dataset
// you would be given 1. set of vertex from 0 to n 2. instructions on how to connect each vertex with another
// union operation makes set
// find operation gets representative of set
// final outcome is a tree

// dataset- 0,1,2,3,4,5
// union (0,1) (3,5) (4,3) (2,1) (2,5)
// * denotes representative
// 0* and 1 in same set
// 3* and 5 in same set
// 3 and 4 in same set but 3 in another set so merge those. 3*, 4 and 5 new set 
// 2 and 1 in same set but 1 in another set so 0* 1 and 2 form another set
// 2 and in diff sets so 0* 1 2 3 4 5 form a single set
// Union find/ Union-find
public class DisjointSets {
	public int[] connection;
	
	public DisjointSets(int n) {
		connection = new int[n];
		Arrays.fill(connection, -1);
	}

	// path compression- if 2 depends on 1 and 1 on 2 then 2 would be modified to depend on 1
	public int find(int node) {
		if (connection[node] != -1) {
			connection[node] = find(connection[node]); // path compression by halving
			node = connection[node];
		}
		// if -1 then node
		return node; 
	}
	
	// returns false if two nodes already were part of same set or if two nodes have same parent (were not in two different sets so to say)
	// returns true and joins two nodes if both of them had different parent- we could join nodes because we would be given 'union' instructions
	// OR
	// if return false then indicates that two disjoint datasets were joined and made single dataset. also indicates a redundant connection/
	// return false also indicates two vertices are NOT connected by exactly one path. Hence given graph is not an undirected tree
	// in undirected two, two vertices are connected by exactly one path
	// in union instructions, if tree is valid, then node1Parent != node2Parent as every instruction represents a different set
	public boolean union(int node1, int node2) {
		//can trigger path compression for previous done unions
		int node1Parent = find(node1); 
		// can trigger path compression for previous done unions
		int node2Parent = find(node2); 
		// debug- System.out.println("parent of " + node1 + " is " + node1Parent + " and " + "parent of " + node2 + " is " + node2Parent);
		// no union needed. two nodes were already connected
		// [1,2-no cycle and diff parents] [2,3- no cycle and diff parents] [3,1-cycle as 1 and 3 were connected already]
		if (node1Parent == node2Parent) 
			return false;
		// union- meaning join two dis-joint data sets, making them as same set. 
		// node 1 becomes parent and node2 becomes child
		// path compression needs to be triggered (call to find method)
		connection[node2Parent] = node1Parent; 
		return true;
	}
	
	// example-
	// three disjoint set- 1,2, 0,1, 0,2
	// 0->-1, 1->-1 2->-1
	// 1,2. Union made- true. Array: 0->-1, 1->-1 2->1
	// 0,1. Union made- true. Array: 0->-1, 1->0 2->1
	// 0,2. Union made- false.Array: 0->-1, 1->0 2->0
	
	public int getDisjointSets() {
		int disJoint = 0;
		for (int node : connection) if (connection[node] == -1) disJoint++;
		return disJoint;
		
	}
}
