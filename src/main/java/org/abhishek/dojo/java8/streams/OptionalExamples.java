package org.abhishek.dojo.java8.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class OptionalExamples {
	public static void main(String[] args) {

		
		List<Integer> nums = Arrays.asList(1, 3, 5, 7, 8, 9,9);
		Integer num = 
				nums.stream().
				filter(item -> item % 2 == 0)
				.max((i1, i2) -> i1.compareTo(i2)).orElseThrow(IllegalArgumentException::new);
		
		System.out.println("num = " + num + "\n");
		
		
		num = nums.stream().
				filter(item -> item % 2 == 0)
				.max((i1, i2) -> i1.compareTo(i2))
				.orElse(0);
		
		System.out.println("num = " + num + "\n");

		// java 8 APIs
//		numbers.stream().collect(Collectors.maxBy(Comparator.naturalOrder()));
//		numbers.stream().collect(Collectors.maxBy(Comparator.reverseOrder()));
//		new HashMap<>().keySet().stream().collect(Collectors.maxBy(Map.Entry.comparingByKey()));
//		new HashMap<>().keySet().stream().collect(Collectors.maxBy(Map.Entry.comparingByValue()));
		
		System.out.println(Boolean.toString(nums.stream().allMatch(x -> x%9 == 0)) + "\n");
		System.out.println(Boolean.toString(nums.stream().anyMatch(x -> x%9 == 0)) + "\n");
		
		
		Map<Integer, Long> numMap = nums.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(numMap.toString());
		
		String sentence = "this is a long string but it isnt supposed to be so long string, isnt it. Even if it is wrong then we can try to compress and descompress it ?";
		
		Map<String, Long> wordCount = Arrays.asList(sentence.split(" ")).stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting())); 
		
		System.out.println(wordCount.toString());
		
		// find top repeating word in the sentence
		// sort above map by value and get first
		System.out.println(wordCount.entrySet().stream()
				.collect(Collectors.maxBy(Comparator.comparing(entry -> entry.getValue()))).get());
		System.out.println(wordCount.entrySet().stream().collect(Collectors.maxBy(Map.Entry.comparingByValue())).get());
		System.out.println(wordCount.entrySet().stream().max(Comparator.comparing(entry -> entry.getValue())).get());		
		System.out.println(wordCount.entrySet().stream().max(Map.Entry.comparingByValue()).get());	
		
		nums = Arrays.asList(1, 3, 5, 7, 9);
		num = nums.stream().filter(item -> item % 2 == 0).max((i1, i2) -> i1.compareTo(i2)).orElseThrow(IllegalArgumentException::new);
		
		System.out.println("num = " + num + "\n");
	
	}
}
