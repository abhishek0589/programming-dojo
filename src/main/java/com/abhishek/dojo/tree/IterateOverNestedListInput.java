package com.abhishek.dojo.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class IterateOverNestedListInput {

	public static void main(String[] args) {
		System.out.println("Test case 1- Two level of nesting- List<List<Integer>>");
		List<List<Integer>> testcase1 = buildSampleDataForTwoLevelNestList();
		iterateOverInput(testcase1);// set the iterator

		System.out.println("Test case 2- Three level of nesting- List<List<List<Integer>>>");
		List<List<List<Integer>>> testcase2 = buildSampleDataForThreeLevelNestList();
		iterateOverInput(testcase2);// set the iterator
	}

	private static void iterateOverInput(List<?> input) {
		Iterator<Integer> iterator = createIterator(input);
		while (iterator.hasNext()) {
			Integer item = iterator.next();
			System.out.println(item);
		}
	}

	// create an iterator that supports hasNext and next methods
	public static Iterator<Integer> createIterator(List<?> input) {
		return new IterateOverNestedListInput().new CustomIterator(input);
	}

	// custom iterator will have a constructor that would first of all flatten the input
	// first thing while using the iterator would be to create a flattened list
	class CustomIterator implements Iterator<Integer> {

		private List<Integer> flatList = new ArrayList<>();
		int currentIndex = -1;

		public CustomIterator(List<?> input) {
			this.setFlatList(input);
		}

		@Override
		public boolean hasNext() {
			++this.currentIndex;
			return currentIndex < getFlatList().size();
		}

		@Override
		public Integer next() {
			return this.getFlatList().get(currentIndex);
		}

		public List<Integer> getFlatList() {
			return flatList;
		}

		public void setFlatList(List<?> input) {
			List<Object> flattenObjectList = flatten(input);
			for (Object item : flattenObjectList) {
				Integer intItem = (Integer) item;
				flatList.add(intItem);
			}
		}

		public List<Object> flatten(List<?> list) {
			List<Object> retVal = new ArrayList<Object>();
			flatten(list, retVal);
			return retVal;
		}

		public void flatten(List<?> fromTreeList, List<Object> toFlatList) {
			for (Object item : fromTreeList) {
				if (item instanceof List<?>) {
					flatten((List<?>) item, toFlatList);
				} else {
					toFlatList.add(item);
				}
			}
		}

	}

	private static List<List<Integer>> buildSampleDataForTwoLevelNestList() {
		List<List<Integer>> input = new ArrayList<>();
		// add sublists with same or diferent sizes
		input.add(Arrays.asList(3, 5, 6));
		input.add(Arrays.asList(1));
		input.add(Arrays.asList(17, 18));
		// iterator should support traverse through null lists, if any
		ArrayList<Integer> nullList = new ArrayList<>();
		nullList.add(null);
		input.add(nullList);
		return input;
	}

	private static List<List<List<Integer>>> buildSampleDataForThreeLevelNestList() {
		List<List<List<Integer>>> input = new ArrayList<>();
		// add sublists with same or diferent sizes
		List<List<Integer>> first = new ArrayList<>();
		first.add(Arrays.asList(-1, 3, 0));
		first.add(Arrays.asList(1));
		first.add(Arrays.asList(7, 825));
		// iterator should support traverse through null lists, if any
		ArrayList<Integer> nullList = new ArrayList<>();
		nullList.add(null);
		first.add(nullList);

		input.add(first);

		// add sublists with same or diferent sizes
		List<List<Integer>> second = new ArrayList<>();
		second.add(Arrays.asList(3, 5, 6));
		second.add(Arrays.asList(1));
		second.add(Arrays.asList(17, 18));
		// iterator should support traverse through null lists, if any
		nullList = new ArrayList<>();
		nullList.add(null);
		second.add(nullList);

		input.add(second);

		return input;
	}

}
