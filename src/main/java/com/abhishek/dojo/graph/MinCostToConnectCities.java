package com.abhishek.dojo.graph;

import java.util.Arrays;

import com.abhishek.data.util.DisjointSets;
import com.abhishek.data.util.SysoutUtil;

public class MinCostToConnectCities {

	public int minimumCost(int N, int[][] connections) {
		// sort in ascending order of cost. this would bring cities with lowest cost of
		// connections first
		Arrays.sort(connections, (c1, c2) -> (c1[2] - c2[2]));

		int cost = 0;
		DisjointSets uf = new DisjointSets(N);
		// union not done (two different cities were already connected)
		// union done (two cities werent connected before, but through union they got
		// connected)- similar two two different sets had a common point so sets got
		// merged
		for (int[] con : connections) {
			if (uf.union(con[0] - 1, con[1] - 1))
				System.err.println("connect " + con[0] + " with " + con[1] + " cost " + con[2]);
			cost += con[2];
		}

		SysoutUtil.array(uf.connection);
		return validateConsistentGroupingAndReturnCost(N, cost, uf);
	}

	private int validateConsistentGroupingAndReturnCost(int N, int cost, DisjointSets uf) {
		// get parent of first item
		final int group = uf.find(0);
		// parent of all subsequent items should be same as parent of 1st item
		for (int i = 0; i < N; i++)
			if (uf.find(i) != group)
				return -1;
		return cost;
	}

	public static void main(String[] args) {
		MinCostToConnectCities m = new MinCostToConnectCities();
		System.out.println("min cost: " + m.minimumCost(8,
				new int[][] { { 4, 3, 11 }, { 4, 2, 8 }, { 4, 1, 10 }, { 4, 5, 5 }, { 4, 7, 11 }, { 7, 6, 1 },
						{ 4, 8, 9 }, { 3, 2, 18 }, { 2, 1, 4 }, { 1, 5, 2 }, { 5, 6, 51 }, { 6, 8, 2 }, { 8, 3, 19 },
						{ 7, 8, 23 } }));

		// 3, new int[][] {{1,2,5},{1,3,6},{2,3,1}})
	}
	// System.out.println("city1 " + city1 + " parent: " + city1Parent + ", city2 "
	// + city2 + " parent: " + city2Parent);
}
