package com.abhishek.dojo.collections;

import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.RandomAccess;


public class CollectionUtility {

	public static Comparator<Student> external_comparator_asc = ((o1,o2) -> o1.getId() - o2.getId());

	public static Comparator<Student> external_comparator_desc = new Comparator<Student>() {
		@Override
		public int compare(Student o1, Student o2) {
			Integer i1 = o1.getId();
			Integer i2 = o2.getId();
			return i2.compareTo(i1);
			//return o2.getId() - o1.getId();//The other way
		}
	};

	//This type of comparator will always return ascending order and will allow duplicates as well
	public static Comparator<Integer> external_comparator_dup = new Comparator<Integer>() {
		@Override
		public int compare(Integer o1, Integer o2) {
			return +1;
		}
	};

	//Write a comparator so that strings are arranged in ascending order of length.
	//If two strings are having same length, consider alphabetical order

	public static Comparator external_comparator_length = new Comparator() {
		@Override
		public int compare(Object o1, Object o2) {
			String s1 = o1.toString();
			String s2 = o2.toString();
			Integer l1 = s1.length();
			Integer  l2 = s2.length();
			if (l1 != l2)
				return l1.compareTo(l2);
			else
				return s1.compareTo(s2);
		};
	};

	public static Comparator<StringBuffer> external_comparator_string_buffer = new Comparator<StringBuffer>() {
		@Override
		public int compare(StringBuffer o1, StringBuffer o2) {
			String s1 = o1.toString();
			String s2 = o2.toString();
			return s1.compareTo(s2);
		}
	};

	@SuppressWarnings("rawtypes")
	public static void printInterfaceChecks(Collection c){
		System.out.println(c.getClass().getName() + "  Implememnts RandomAccess?  " + (c instanceof RandomAccess));
		System.out.println(c.getClass().getName() + "  Implememnts Serializable?  " + (c instanceof Serializable));
		System.out.println(c.getClass().getName() + "  Implememnts cloneable?  " + (c instanceof Cloneable));
	}

}
