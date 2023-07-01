package com.abhishek.dojo.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class KClosestPointToOrigin {
	
	public int[][] kClosest(int[][] points, int K) {
		PriorityQueue<int[]> q = new PriorityQueue<>(K, (a,b)-> (a[0]*a[0] + a[1]*a[1] - b[0]*b[0] - b[1]*b[1]));
        for (int[] point : points) q.offer(new int[]{point[0], point[1]});
        int[][] result = new int[K][2];
        for (int i = 0; i < K; i++) result[i] = q.poll();
        return result;
    }
	
	class ClosestPoint {
		int[] point;
		int distance;
		public ClosestPoint(int[] point, int distance) {
			this.point = point;
			this.distance = distance;
		}
	}

	public int[][] kClosestQueue(int[][] points, int K) {
		PriorityQueue<ClosestPoint> closestPoints = new PriorityQueue<>(K, (a,b) -> (a.distance - b.distance));
		for (int[] point : points) closestPoints.offer(new ClosestPoint(point, (point[0] * point[0] + point[1] * point[1])));
		int[][] result = new int[K][2];
		for (int i = 0; i < K; i++) result[i] = closestPoints.poll().point;
		return result;
	}

	public int[][] kClosestMap(int[][] points, int K) {
		if (points == null || points.length == 0) return new int[0][0];
		Map<Integer[], Integer> map = new HashMap<>();
		for (int[] point : points) map.put(new Integer[] { point[0], point[1] }, (point[0] * point[0] + point[1] * point[1]));
		List<Entry<Integer[], Integer>> list = new ArrayList<>(map.entrySet());
		Collections.sort(list, (a, b) -> a.getValue() - b.getValue());
		int[][] result = new int[K][2];
		for (int i = 0; i < K; i++) {
			result[i] = new int[] {list.get(i).getKey()[0], list.get(i).getKey()[1]};
		}
		return result;
	}
}


