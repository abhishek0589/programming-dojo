package com.abhishek.dojo.collections;

import java.util.ConcurrentModificationException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class FailFastIterator {

	public static void main(String[] args) {
		Set<String> hs = new HashSet<String>();
		String s = "Hello";
		hs.add(s);
		hs.add("World");
		hs.add("Pgm");

		try {
			for (Iterator<String> iterator = hs.iterator(); iterator.hasNext();) {
				hs.remove(iterator.next());
			}
		} catch (ConcurrentModificationException e) {
			System.err.println("Concurrent modification exception occured ...");
		}
		System.out.println("Completed ...");


		System.out.println(hs.toString());
	}
}
