package com.abhishek.dojo.graph;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

// problem- find free course and see from a free course, any other course can be completed or not
// if there are 3 course and all of them are there in pre-req array- there is an indirect cycle
// hence nothing can be completed
// example of indirect cycle.
//3 -> [[1,0], [2,1], [0,2]]
public class CourseSchedule {
	public static void main(String[] args) {
		CourseSchedule s = new CourseSchedule();
		int[][] test1 = { { 0, 1 }, { 1, 2 } };
		System.out.println(s.canFinish(3, test1));
		int[][] test2 = { { 0, 1 }, { 1, 0 } };
		System.out.println(s.canFinish(2, test2));
	}

	public boolean canFinish(int numCourses, int[][] prerequisites) {
		if (numCourses <= 1 || prerequisites.length == 0) {
			return true;
		}
		// add a graph also known as adjacency list
		// Brainstorm on why only this data structure was used
		Map<Integer, Set<Integer>> graph = new HashMap<>();
		// initialize graph with keys
		for (int i = 0; i < numCourses; i++) {
			graph.put(i, new HashSet<Integer>());
		}
		// add dependency list in graph
		for (int[] prerequisite : prerequisites) {
			graph.get(prerequisite[0]).add(prerequisite[1]);
		}
		Queue<Integer> queue = new LinkedList<>();
		int courseCount = numCourses;
		// scan courses with no deps and put them first in queue
		// once done, scan next level of courses dependent on ones already added on queue
		// remove such courses from queue and add them back to queue
		for (Map.Entry<Integer, Set<Integer>> entry : graph.entrySet()) {
			if (entry.getValue().size() == 0) {
				queue.offer(entry.getKey());
				courseCount--;
				if (courseCount == 0) {
					return true;
				}
			}
		}


		while (!queue.isEmpty()) {
			int key = queue.poll();
			for (Map.Entry<Integer, Set<Integer>> entry : graph.entrySet()) {
				if (entry.getValue().contains(key)) {
					entry.getValue().remove(key);
					if (entry.getValue().size() == 0) {
						queue.offer(entry.getKey());
						courseCount--;
						if (courseCount == 0) {
							return true;
						}
					}
				}
			}
		}
		return courseCount == 0;
	}
}
