package org.abhishek.dojo.java8.streams;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StringToMapParser {

	public static void main(String[] args) {
		List<String> input = Arrays.asList("1:2,3,4", "3:4,5,6");
		Map<Integer, List<Integer>> map = new HashMap<>();
		Map<Integer, List<Integer>> collect = input.stream()
				.collect(Collectors.toMap(e -> Integer.valueOf(e.split(":")[0]), mapper()));
		System.out.println("hello");

	}

	private static Function<String, List<Integer>> mapper() {
		return e -> {
			String reportees = e.split(":")[1].trim();
			List<Integer> directReportees = Arrays.stream(reportees.split(",")) // stream of String
					.map(Integer::valueOf) // stream of Integer
					.collect(Collectors.toList());
			return directReportees;
		};
	}

}
