package com.abhishek.dojo.greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
// think- what if we have more types of tasks than cooling interval. If cooling is 2 and if you have 4 types A, B, C, D
public class TaskScheduler {
	public static void main(String[] args) {
		TaskScheduler t = new TaskScheduler();
		char[] tasks = new char[] { 'A', 'A', 'A', 'B', 'B', 'B', 'C' , 'D'};
		System.out.println(t.leastInterval(tasks, 2));
	}

	public int leastInterval(char[] tasks, int n) {
		// map of tasks and their occurrence
		HashMap<Character, Integer> map = new HashMap<>();
		int tasksInCoolDownPeriod = n + 1; //tasks started to 0th minute, another two tasks can be done in 1st and 2nd so total 3 tasks
		for (char c : tasks)
			map.put(c, map.getOrDefault(c, 0) + 1);
		// One of the key aspect here is, don schedule tasks with same type one after
		// other
		// else you will always keep waiting.
		// tasks which are repeating very frequently are needed to be executed first
		// hence we can use a priority queue here so that we have constant time access
		// to most frequent tasks
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> (b - a));
		maxHeap.addAll(map.values());
		int cycles = 0;
		while (!maxHeap.isEmpty()) {
			List<Integer> tasksExecuted = new ArrayList<>();
			// we need inclusive check here as we need to wait for cool-down
			// for every cool-down period, add all tasks (highest priority first) to be
			// executed
			for (int i = 0; i < tasksInCoolDownPeriod && !maxHeap.isEmpty(); i++) {
					tasksExecuted.add(maxHeap.remove());
			}
			// for every task that got executed, check if there is anything pending, if so,
			// refill queue
			for (int task : tasksExecuted) {
				task--;
				if (task > 0) maxHeap.add(task);
			}
			// if q is not empty it means certain tasks are waiting to be executed, hence wait for cooldown
			// else all tasks are done, just return count of tasks added in last cycle
			cycles += !maxHeap.isEmpty() ? n+1: tasksExecuted.size(); 
		}
		return cycles;
	}
}
