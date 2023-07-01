package com.abhishek.dojo.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UseIterator {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			list.add(i);
		}
		System.out.println(list.toString());

		Iterator<Integer> itr = list.iterator();

		while (itr.hasNext()) {
			Integer value = itr.next();
			if (!((value % 2) == 0)) {
				itr.remove();
			}
		}
		System.out.println(list.toString());
	}
}