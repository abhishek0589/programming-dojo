package com.abhishek.dojo.graph;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import com.abhishek.data.util.DisjointSets;

// https://leetcode.com/problems/redundant-connection/
public class RedundantConnection {
	public static void main(String[] args) {
		RedundantConnection r = new RedundantConnection();
		int[]  redundantConnection= r.findRedundantConnection(new int[][] {{1,2},{2,3},{3,4},{1,4},{1,5}});
		System.out.println(Arrays.toString(redundantConnection));
	}

	public int[] findRedundantConnection(int[][] edges) {
		Set<Integer> nodes = new HashSet<>();
		for (int[] edge : edges) {
			nodes.add(edge[0]);
			nodes.add(edge[1]);
		}
		DisjointSets uf = new DisjointSets(nodes.size());
		// logic- at every point- if there is no redundant connection then you should be able to make union
		// in case there was no union done, it means the connection was redundant
		for (int[] edge : edges) 
			if (!uf.union(edge[0] - 1, edge[1] - 1)) return edge;
		return new int[0];
	}
}
