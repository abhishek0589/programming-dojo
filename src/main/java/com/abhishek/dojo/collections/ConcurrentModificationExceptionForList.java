package com.abhishek.dojo.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ConcurrentModificationExceptionForList {

	public static void main(String[] args) {
		
		List<String> list = new ArrayList<>(Arrays.asList("a", "b", "c"));
		
		try {
			System.out.println("Starting concurrent modification without iterator");
			for (int i = 0; i < list.size(); i++) {
				System.out.println("Remvoing " + list.get(i));
				list.remove(i);
				i--;
			}
			System.out.println("SUCCESS");
		} catch (Exception e) {
			System.out.println("Concurrent mod exception using simple loop");
			e.printStackTrace();
		}
		
		list = new ArrayList<>(Arrays.asList("a", "b", "c"));
		try {
			for (Iterator<String> iterator = list.iterator(); iterator.hasNext();) {
				String string = iterator.next();
				list.remove(string);
			}
			System.out.println("SUCCESS");

		} catch (Exception e) {
			System.out.println("FAILURE: Concurrent mod exception using iterator");
			e.printStackTrace();
		}
	}

}
