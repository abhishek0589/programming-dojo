package com.abhishek.dojo.graph;

import com.abhishek.data.util.DisjointSets;

// https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/

public class ConnectedComponentsInUndirectedGraph {
	public static void main(String[] args) {
		ConnectedComponentsInUndirectedGraph n = new ConnectedComponentsInUndirectedGraph();
		n.countComponents(5, new int[][]{{0,1},{1,2},{2,3},{3,4}});
	}

	public int countComponents(int n, int[][] edges) {
		DisjointSets uf = new DisjointSets(n);
		for (int[] edge : edges) uf.union(edge[0], edge[1]);
		return uf.getDisjointSets();
	}


}
