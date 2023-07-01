package com.abhishek.data.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class TechniqueUtils {

	public static void main(String[] args) {
		TechniqueUtils t = new TechniqueUtils();
		//1- used while reversing sentence- u need to clear up spaces
		t.trimOneOrMoreSpaces();
		//2- arrays positional indexing- group anagrams togethor
		t.createPositionalOfString("hello");
		t.createPositionalOfString("llohe");
		//3- print org chart
		t.hierarchicalStructureWithMap();
		//4- used in skyline problem
		t.sortCollection();
		//5- used in calculator
		t.charSequenceToNumber();
		//6- used in word count/similar problems
		t.getHeighestValueInMap();
		//7. binary search
		t.search();
		
	}

	public void charSequenceToNumber() {
		System.out.println("*************" + "charSequenceToNumber"  + "*************");
		String s = "341";
		int num = 0;
		char[] arr = s.toCharArray();
		for (int i = 0; i < arr.length; i++) num = num * 10 + arr[i] - '0';
		System.out.println(num);
	}

	private Map<Integer, Set<Integer>> constructHeirarchicalMap() {
		Map<Integer, Set<Integer>> map = new HashMap<>(); Set<Integer> set = new HashSet<>();
		set.add(2); set.add(3); set.add(4);
		map.put(1, set);

		set = new HashSet<>();
		set.add(5); set.add(6); set.add(7);
		map.put(3, set);

		set = new HashSet<>();
		set.add(8); set.add(9); set.add(10);
		map.put(5, set);
		return map;
	}

	public void createPositionalOfString(String word) {
		System.out.println("*************" + "createPositionalOfString"  + "*************");
		int[] positional = new int[26];
		for (int i = 0; i < word.length(); i++) {
			positional[word.charAt(i) - 'a']++;
		}
		// short for converting character array to string
		String key = Arrays.toString(positional).replaceAll(",", "").replaceAll(" +", "");
		System.out.println("postional:" + key);
	}

	//	1: 2, 3, 4
	//	3: 5, 6, 7
	//	5: 8, 9, 10
	public void hierarchicalStructureWithMap() {
		System.out.println("*************" + "hierarchicalStructureWithMap"  + "*************");
		Map<Integer, Set<Integer>> heirarchicalMap = constructHeirarchicalMap();
		List<Integer> list = new ArrayList<>();
		getHelper(heirarchicalMap, 3, list);
		list.forEach( x-> System.out.println(x));
	}
	
	public List<Integer> getHelper(Map<Integer, Set<Integer>> map, int target, List<Integer> result){
		for (Entry<Integer, Set<Integer>> entry: map.entrySet()) {
			if (entry.getKey() == target) {
				for (int reportee : entry.getValue()) {
					result.add(reportee);
					getHelper(map, reportee, result);
				}
			}
		}
		return result;
	}

	public void sortCollection() {
		System.out.println("*************" + "sortCollection"  + "*************");
		/** comparator returns a negative integer, zero, or a positive integer if the first argument is less than, equal to, or greater than the second.**/
		System.out.println("sorting collections");
		List<Integer> l1 = Arrays.asList(5,2,8,1,10);
		Collections.sort(l1);
		l1.forEach(x -> System.out.println(x));

		System.out.println("**************0 comparator**************");
		l1 = Arrays.asList(5,2,8,1,10);
		Collections.sort(l1, (a,b) -> 0);
		l1.forEach(x -> System.out.println(x));

		System.out.println("**************-1 comparator**************");
		l1 = Arrays.asList(5,2,8,1,10);
		Collections.sort(l1, (a,b) -> -1);
		l1.forEach(x -> System.out.println(x));

		System.out.println("**************1 comparator**************");
		l1 = Arrays.asList(5,2,8,1,10);
		Collections.sort(l1, (a,b) -> 1);
		l1.forEach(x -> System.out.println(x));
	}

	public void trimOneOrMoreSpaces(){
		String s = "string   with multiple     spaces in  between";
		System.out.println(s.replaceAll(" +", " ")); // notice we use replaceAll and + after a single space
	}

	public void getHeighestValueInMap() {
		System.out.println("**************getHeighestValueInMap**************");
		Map<Integer, Integer> map = new HashMap<>();
		map.put(1, 5); map.put(2, 7);map.put(3, 0);map.put(4, 5);map.put(5, -1);
		List<Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet()); // convert map to entry set and put that in array list
		Collections.sort(list, (a,b) -> b.getValue()-a.getValue());
		System.out.println("highest value in map: " + list.get(0).getValue());
 	} 
	
	public void search() {
		int[] nums = {3,5,6,7,8,10}; int target = 5;
		binarySearch(nums, target);
	}

	public static int binarySearch(int[] nums, int target) {
		int left = 0, right = nums.length-1;
		while (left <= right) { // in case of odd number of elements left and right would become equal 
			// int m = (l + r) / 2; // this will cause integer overflow. Integer supports roughly 2 billion+ values.
			int m = left + (right-left)/2; // this wont cause integer overflow 
			if (target == nums[m]) {
				return m;
			} else if (target < nums[m]) {
				right = m - 1;
			} else {
				left = m + 1;
			}
		}
		return -1;
	}

}
