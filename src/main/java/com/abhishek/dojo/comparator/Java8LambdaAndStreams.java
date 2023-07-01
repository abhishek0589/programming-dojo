package com.abhishek.dojo.comparator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Java8LambdaAndStreams {

	public static void main(String[] args) {
		// convert a list of strings to all upper case, get only strings starting with letter B
		List<String> list = new ArrayList<String>(Arrays.asList("Bob", "Builder", "Alice", "Wonderland"));
		
		List<String> target = list.
				stream().
				filter(item -> item.toLowerCase().startsWith("b")).
				map(String::toUpperCase).
				collect(Collectors.toList());
		
		target.forEach(System.out::println);
				
	}
}
