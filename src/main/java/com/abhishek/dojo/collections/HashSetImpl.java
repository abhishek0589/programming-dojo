package com.abhishek.dojo.collections;

import java.util.HashSet;
import java.util.Iterator;


public class HashSetImpl {

	public static void main(String[] args) {
		hashset();
	}
	
	/**
	 * Underlying DS is hashtable
	 * Introduced in 1.2 version
	 */
	@SuppressWarnings({"unchecked", "rawtypes", "unused"})
	private static void hashset() {
		//Default initial capacity = 16
		//Default load factor/fill ratio = .75
		//If hash set reaches load factor * current size (12 in this case) a new object is created with double size
		HashSet<Integer> hashset = new HashSet<Integer>();

		//Initial capacity set to 1000
		HashSet _hashset = new HashSet();
		_hashset.add("A");
		_hashset.add("B");
		_hashset.add("C");
		_hashset.add(1); //Heterogeneous elements allowed
		_hashset.add(null);//null

		for (Iterator iterator = _hashset.iterator(); iterator.hasNext();){
			System.out.println(iterator.next());iterator.remove();

		}
		System.out.println("Removed version from iterator-----------" + _hashset);

		//Initial capacity and fill ratio
		HashSet<Integer> __hashset = new HashSet<Integer>(1000, (float) 0.9);
		CollectionUtility.printInterfaceChecks(hashset);
	}
}
