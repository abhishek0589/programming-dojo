package com.abhishek.dojo.graph;

import com.abhishek.data.util.DisjointSets;

// https://leetcode.com/problems/graph-valid-tree/
// verify graph doesnt has cycle
// total number of edges are same as total number of nodes meaning their should not be any stale/lying in the air vertices
// there should not be any cycles

// lets validate example { 0, 1 }, { 1, 2 }, { 2, 3 }, { 1, 3 }, { 1, 4 }
// parent of all nodes to start with -1
// 0 and 1- parent of 0 is -1 and parent of 1 is 0
// 1 and 2- parent of 1 is 0 and parent of 2 is -1
// 2 and 3- parent of 1 is 0 and parent of 2 is -1

public class ValidUndirectedGraph {
	public boolean validTree(int n, int[][] edges) {
		// condition 1- if two vertices happen to be in the same set then there's a cycle
		DisjointSets uf = new DisjointSets(n);
		for (int[] edge : edges) 
			if (!uf.union(edge[0], edge[1])) 
				return false;
		// condition 2- number of edges should 1 less than total vertex
		return edges.length == n - 1; 
	}
	
	public static void main(String[] args) {
		ValidUndirectedGraph v = new ValidUndirectedGraph();
		//System.out.println(v.validTree(5, new int[][] { { 0, 1 }, { 0, 2 }, { 0, 3 }, { 1, 4 } })); // true
		System.out.println(v.validTree(5, new int[][] { { 0, 1 }, { 1, 2 }, { 2, 3 }, { 1, 3 }, { 1, 4 } })); // false
		//System.out.println(v.validTree(5, new int[][] { { 0, 1 }, { 1, 2 }, { 2, 3 }, { 1, 4 } })); // true
		//System.out.println(v.validTree(5, new int[][] {{0,3},{2,3},{0,2},{0,1},{3,4}}));
	}

}