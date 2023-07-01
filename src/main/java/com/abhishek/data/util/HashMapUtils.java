package com.abhishek.data.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashMapUtils {

	public static void main(String[] args) {
		HashMapUtils h = new HashMapUtils();
		h.computeWithIntegers();
		// 1. computeIfAbsent
		h.withoutComputeIfAbsent();
		h.computeIfAbsent();
		// 2. putIfAbsent
		h.putIfAbset();
		// 3. compute
		h.compute();
		// 4. mapOrGetDefault
		h.getOrDefault();
	}

	// compute if similar to computeIfAbsent except, using compute, you can compute using both key and values
	// if compute function returns null, key is 'automatically' remmoved from map

	// compute accepts a key and bi-function as it provides support to compute value using key as well as value
	// a regular function (not a bi-function) accepts single input 
	// computeIfAbsent computes only on basis of value, hence can work with just a function, no bi-function is needed
	private void compute() {
		System.out.println("**********compute*********");
		String[][] inputs = new String[][]{{"JFK","SFO"},{"JFK","ATL"},{"SFO","ATL"},{"ATL","JFK"},{"ATL","SFO"}};

		// increment
		Map<String, Integer> map = new HashMap<>();
		for (String[] input : inputs) {
			map.compute(input[0], (k, v) -> {
				if (v == null) {
					return 1;
				}
				return v + 1;
			});
		}

		System.out.println(map.toString());

		//decrement
		for (String[] input : inputs) {
			map.compute(input[0], (k, v) -> {
				if (v == 1) {
					return null;
				}
				return v-1;
			});
		}


		// increment
		Map<String, List<String>> testmap = new HashMap<>();
		for (String[] input : inputs) {
			testmap.compute(input[0], (k, v) -> {
				if (v == null) {
					return new ArrayList<>();
				}
				return v;
			}).add(input[1]);
		}

		System.out.println(testmap.toString());


		testmap = new HashMap<>();
		for (String[] input : inputs) {
			testmap.compute(input[0], (k, v) -> v == null ? new ArrayList<>() : v).add(input[1]);
		}

		System.out.println(testmap.toString());


	}

	// if key is not present, then returns value according to compute function
	// if key is present, then returns existing value

	// computeIfAbsent computes only on basis of value, hence can work with just a function, no bi-function is needed
	// compute accepts a key and bi-function as it provides support to compute value using key as well as value
	// a regular function (not a bi-function) accepts single input 
	private void computeIfAbsent() {
		System.out.println("**********computeIfAbsent*********");
		String[][] inputs = new String[][]{{"JFK","SFO"},{"JFK","ATL"},{"SFO","ATL"},{"ATL","JFK"},{"ATL","SFO"}};
		Map<String, List<String>> map = new HashMap<>();
		// add is not part of computeIfAbsent :)
		for (String[] input : inputs)
			map.computeIfAbsent(input[0], k -> new ArrayList<>()).add(input[1]);

		System.out.println(map.toString());
	}

	private void getOrDefault() {
		System.out.println("**********getOrDefault*********");
		// increase occurance count of source by 1
		String[][] inputs = new String[][]{{"JFK","SFO"},{"JFK","ATL"},{"SFO","ATL"},{"ATL","JFK"},{"ATL","SFO"}};

		// increment - similar to compute function
		Map<String, Integer> map = new HashMap<>();
		for (String[] input : inputs) {
			map.put(input[0], map.getOrDefault(input[0], 0) + 1);
		}
		System.out.println(map.toString());
	}


	private void putIfAbset() {
		System.out.println("**********putIfAbset*********");
		String[][] inputs = new String[][]{{"JFK","SFO"},{"JFK","ATL"},{"SFO","ATL"},{"ATL","JFK"},{"ATL","SFO"}};
		Map<String, List<String>> map = new HashMap<>();
		// add is not part of computeIfAbsent :)
		for (String[] input : inputs) {
			map.putIfAbsent(input[0], new ArrayList<>());
			map.get(input[0]).add(input[1]);
		}
		System.out.println(map.toString());
	}

	// putIfAbsent adds an element with the specified Value 
	// whereas 
	// computeIfAbsent adds an element with the value "computed using the Key or compute function"

	private void withoutComputeIfAbsent() {
		System.out.println("**********withoutComputeIfAbsent*********");
		String[][] inputs = new String[][]{{"JFK","SFO"},{"JFK","ATL"},{"SFO","ATL"},{"ATL","JFK"},{"ATL","SFO"}};
		Map<String, List<String>> map = new HashMap<>();
		// add is not part of computeIfAbsent :)
		for (String[] input : inputs) {
			if (map.containsKey(input[0])) {
				List<String> list = map.get(input[0]);
				list.add(input[1]);
				map.put(input[0], list);
			} else {
				List<String> list = new ArrayList<>();
				list.add(input[1]);
				map.put(input[0], list);
			}
		}
		System.out.println(map.toString());
	}
	
	
	public void computeWithIntegers() {
		Map<Integer, Integer> map = new HashMap<>();
		List<List<Integer>> list = new ArrayList<>();
		List<Integer> test = new ArrayList<>();
		test = Arrays.asList(3,4,5);
		list.add(test);
		test = Arrays.asList(4,5,6);
		list.add(test);
		test = Arrays.asList(1,2,5);
		list.add(test);
		
		// frequency counting-
		// expected: {1=1, 2=1, 3=2, 4=2, 5=3, 6=1}
		
		// post increment option in compute function
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < list.get(i).size(); j++) {
				 map.compute(list.get(i).get(j), (k,v) -> v == null ? 1 : v++);
			}
		}
		System.out.println(map);
		// result (invalid) : {1=1, 2=1, 3=1, 4=1, 5=1, 6=1}
		
		map = new HashMap<>();
		// pre increment option in compute function
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < list.get(i).size(); j++) {
				map.compute(list.get(i).get(j), (k,v) -> v == null ? 1 : ++v);
			}
		}
		System.out.println(map);
	 	// result- with pre increment (matches with expected): {1=1, 2=1, 3=1, 4=2, 5=3, 6=1}
	}
}
