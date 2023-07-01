package com.abhishek.concepts;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeHeirarchyFinder {

	public static void main(String[] args) {
		Map<Integer, List<Integer>> org = new HashMap<>();
		org = Map.of(1, List.of(2,3,4),3, List.of(5, 6, 7), 5, List.of(8, 9, 10));
		// find reportees
		List<Integer> findReportees = findReportees(org, 1);
		findReportees.forEach(System.out::println);
	}

	private static List<Integer> findReportees(Map<Integer, List<Integer>> org, int i) {
		List<Integer> results = new ArrayList<>();
		for (Map.Entry<Integer, List<Integer>> entry : org.entrySet()) {
			if (entry.getKey() == i) {
				results.addAll(entry.getValue());
				for (Integer emp : entry.getValue()) {
					results.addAll(findReportees(org, emp));
				}
			}
		}
		return results;
	}
}
