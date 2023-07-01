package com.abhishek.dojo.collections;

import java.util.Iterator;
import java.util.TreeSet;


public class TreeSetImpl {

	public static void main(String[] args) {
		sortedSet();
//		setWithDuplicateElements();
//		setWithStringBufferDoesntWork();
//		sortSetOfStringbuffers();
//		sortSetElementsByLength();

	}
	
	/**
	 * No duplicates
	 * Data should be stored in sorted order
	 * Underlying data structure is balanced tree
	 * Heterogeneous objects are not allowed- A runtime exception will be thrown
	 * NULL can't be added
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static void sortedSet() {
		//Default natural sorting
		// Numbers - Ascending order
		// String - Alphabetical order
		//WHILE USING DEFAULT SORT, OBJECTS SHOULD BE HOMOGENOUS AND COMPARABLE
		//IF WE TRY TO ANYTHING OTHER THAN STRING AND INTEGERS, SAY, STRINGBUFFER, WE ARE GOING TO GET EXCEPTIONS
		//STRING AND INTEGERS IMPLEMENTS COMPARABLE, BUT STRINGBUFFER DOESNT
		TreeSet treeSet = new TreeSet();

		treeSet.add(3);
		treeSet.add(1);
		treeSet.add(2);
		treeSet.add(6);
		treeSet.add(8);

		try {
			treeSet.add("A");
		} catch (Exception e) {
			System.err.println("Cannot add hetergenous elements to set");
		}
		try {
			treeSet.add(null);
		} catch (Exception e) {
			System.err.println("Cannot add null element to a set");
		}

		System.out.println(treeSet.comparator());
		System.out.println(treeSet.headSet(6));
		System.out.println(treeSet.tailSet(6));
		System.out.println(treeSet.subSet(6, 8));
		for (Iterator<Integer> iterator = treeSet.iterator(); iterator.hasNext();) {
			System.out.println(iterator.next());
		}

		//Treeset without comparator would give you run time exception.
		//Remove comparable from student and see what happens
		TreeSet<Student> _treeSetwithoutComparator = new TreeSet<Student>();
		_treeSetwithoutComparator.add(new Student(2, "Abhishek"));
		_treeSetwithoutComparator.add(new Student(3, "Ankit"));
		_treeSetwithoutComparator.add(new Student(1, "Someone"));
		
		System.out.println("Printing the order in which element got inserted");
		for (Iterator iterator = _treeSetwithoutComparator.iterator(); iterator
				.hasNext();) {
			Student student = (Student) iterator.next();
			System.out.println(student.toString());
		}
		
		System.out.println("Applying external comparator");

		TreeSet<Student> _treeSet = new TreeSet<Student>(CollectionUtility.external_comparator_asc);//Custom Sorting
		_treeSet.add(new Student(3, "Ankit"));
		_treeSet.add(new Student(2, "Abhishek"));
		_treeSet.add(new Student(1, "Someone"));

		for (Iterator<Student> iterator = _treeSet.iterator(); iterator.hasNext();) {
			Student student = iterator.next();
			System.out.println(student.toString());
		}
	}
	
	
	
	
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static void setWithDuplicateElements() {
		//Add duplicate elements to a set
		//Comparator doesn't do anything and simply returns a positive 1
		TreeSet setWithDuplicate= new TreeSet<>(CollectionUtility.external_comparator_dup);
		setWithDuplicate.add(5);
		setWithDuplicate.add(4);
		setWithDuplicate.add(2);
		setWithDuplicate.add(1);
		setWithDuplicate.add(1);
		for (Iterator iterator = setWithDuplicate.iterator(); iterator.hasNext();) {
			System.out.println(iterator.next());
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static void setWithStringBufferDoesntWork() {
		//EXCEPTION: java.lang.StringBuffer cannot be cast to java.lang.Comparable
		try {
			TreeSet comparable_treeset = new TreeSet<>();
			comparable_treeset.add(new StringBuffer("A"));
			comparable_treeset.add(new StringBuffer("B"));
			comparable_treeset.add(new StringBuffer("C"));
			comparable_treeset.add(new StringBuffer("D"));
		} catch (ClassCastException e) {
			System.err.println("Cannot make tree set using a non comparable class");
		}
	}

	@SuppressWarnings("unused")
	private static void sortSetOfStringbuffers() {
		TreeSet<StringBuffer> treeset = new TreeSet<StringBuffer>(CollectionUtility.external_comparator_string_buffer);
		treeset.add(new StringBuffer("B"));
		treeset.add(new StringBuffer("A"));
		treeset.add(new StringBuffer("E"));
		treeset.add(new StringBuffer("C"));
		treeset.add(new StringBuffer("Z"));
		for (Iterator<StringBuffer> iterator = treeset.iterator(); iterator.hasNext();) {
			System.out.println(iterator.next());
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static void sortSetElementsByLength() {
		TreeSet treeset = new TreeSet(CollectionUtility.external_comparator_length);
		treeset.add(new StringBuffer("AVA"));
		treeset.add(new StringBuffer("BBBCC"));
		treeset.add(new StringBuffer("XXWWWW"));
		treeset.add(new StringBuffer("A"));
		treeset.add("P");
		treeset.add("Q");
		treeset.add("P");
		for (Iterator iterator = treeset.iterator(); iterator.hasNext();) {
			System.out.println(iterator.next());

		}

	}
}
