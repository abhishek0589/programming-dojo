package com.abhishek.dojo.collections;

import java.util.Iterator;
import java.util.Set;


public class LinkedHashSetImpl {

	public static void main(String[] args) {
		linkedHashset();
	}
	
	/**
	 * Duplicates are not allowed
	 * Insertion order is preserved
	 * Underlying DS is Hash table and linked list, thus it is kind of hybrid data structure
	 * Introduced in 1.4 version
	 * Where to use- Cache based applications
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static void linkedHashset() {
		Set linkedHashSet = new java.util.LinkedHashSet<>();
		linkedHashSet.add("D");
		linkedHashSet.add("C");
		linkedHashSet.add(null);
		linkedHashSet.add("B");
		linkedHashSet.add("A");
		linkedHashSet.add(1);

		for (Iterator iterator = linkedHashSet.iterator(); iterator.hasNext();) {
			System.out.println(iterator.next());
		}

		CollectionUtility.printInterfaceChecks(linkedHashSet);

	}


	
}
