package com.abhishek.dojo.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;

public class CourseScheduleNov2021 {

	public static void main(String[] args) {
		CourseScheduleNov2021 s = new CourseScheduleNov2021();
		int[][] test1 = { { 0, 1 }, { 1, 2 } };
		System.out.println(s.canFinish(3, test1));
		int[][] test2 = { { 0, 1 }, { 1, 0 } };
		System.out.println(s.canFinish(2, test2));
	}

	private boolean canFinish(int numCourses, int[][] courses) {

		Map<Integer, Set<Integer>> graph = new HashMap<>();

		for (int i = 0; i < courses.length; i++) {
			graph.putIfAbsent(courses[i][0], new HashSet<Integer>());
			Set<Integer> dependents = graph.get(courses[i][0]);
			dependents.add(courses[i][1]);
			graph.put(courses[i][0], dependents);
		}
		Queue<Integer> free = new LinkedList<>();

		int count = 0;
		for (int i = 0; i < numCourses; i++) {
			if (!graph.containsKey(i)) {
				free.offer(i);
				count++;
				if (count == numCourses)
					return true;
			}
		}

		while (!free.isEmpty()) {
			int current_free = free.poll();
			for (Entry<Integer, Set<Integer>> entry : graph.entrySet()) {
				if (entry.getValue().remove(current_free)) {
					if (entry.getValue().size() == 0) {
						free.offer(entry.getKey());
						count++;
						if (count == numCourses)
							return true;
					}
				}
			}
		}
		return false;
	}

}
