package com.abhishek.dojo.collections;

import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class FailSafeIterator {
	public static void main(String[] args) {

		ConcurrentHashMap<String, String> hs = new ConcurrentHashMap<String, String>();
		String s = "Hello";
		hs.put(s, s);
		hs.put("World", s);
		hs.put("Pgm", s);
		System.out.println(hs.toString());
		for (Iterator<String> iterator = hs.keySet().iterator(); iterator.hasNext();) {
			System.out.println(hs.get(iterator.next()));
			hs.put("my", "pgm");
		}
		System.out.println("Completed ...");
		System.out.println(hs.toString());
	}
}
