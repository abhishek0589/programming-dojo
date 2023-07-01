package com.abhishek.dojo.graph;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class CourseScheduleII {
	public static void main(String[] args) {
		CourseScheduleII s = new CourseScheduleII();
		
		int[][] test0 = { { 1,0 } };
		int[] findOrder = s.findOrder(2, test0);
		for (int i = 0; i < findOrder.length; i++) {
			System.out.println(findOrder[i]);
		}
		
		int[][] test1 = { { 0, 1 }, { 1, 2 } };
		 findOrder = s.findOrder(3, test1);
		for (int i = 0; i < findOrder.length; i++) {
			System.out.println(findOrder[i]);
		}
		System.out.println(">>>");
		int[][] test2 = { { 0, 1 }, { 1, 0 } };
		findOrder = s.findOrder(2, test2);
		for (int i = 0; i < findOrder.length; i++) {
			System.out.println(findOrder[i]);
		}
		System.out.println(">>>");
		int[][] test3 = {{1,0},{2,0},{3,1},{3,2}};
		findOrder = s.findOrder(4, test3);
		for (int i = 0; i < findOrder.length; i++) {
			System.out.println(findOrder[i]);
		}
	}

	public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] order = new int[numCourses];
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < numCourses; i++){
            graph.put(i, new HashSet<Integer>());
        }
        for (int i = 0; i < prerequisites.length; i++){
            graph.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        Queue<Integer> q = new LinkedList<>();
        int orderIndex = 0;
        for (Map.Entry<Integer, Set<Integer>> entry : graph.entrySet()){
            if (entry.getValue().size() == 0){ // course with no deps
                q.offer(entry.getKey());
                order[orderIndex++] = entry.getKey();
                if (orderIndex == numCourses) break;
            }
        }
        while(!q.isEmpty()){
            int course = q.poll();
            for (Map.Entry<Integer, Set<Integer>> entry : graph.entrySet()){
                if (entry.getValue().contains(course)){
                    entry.getValue().remove(course);
                    if (entry.getValue().size() == 0){
                        q.offer(entry.getKey());
                        order[orderIndex++] = entry.getKey();
                        if (orderIndex == numCourses) break;
                    }
                }
            }
        }
        return orderIndex == numCourses ? order : new int[]{};
    }
}
