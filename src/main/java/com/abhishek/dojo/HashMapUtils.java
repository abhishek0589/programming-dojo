package com.abhishek.dojo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMapUtils {
	
	public static void main(String[] args) {
		
		// Map of Ids for name
		HashMap<Integer, String> map = new HashMap<>();
		map.put(1, "Oeprations");
		map.put(2, "Research");
		map.put(3, "Traning and Development");
		map.put(4, "Administation");
		
		// Problem statement- filter the map by id without creating a new map
		// Java 7 approach
		
		Iterator<Map.Entry<Integer, String>> itr = map.entrySet().iterator();
		
		while (itr.hasNext()) {
			Map.Entry<Integer, String> entry = itr.next();
			if (entry.getKey() < 2) {
				//itr.remove();
			}
		}

		
		map.forEach((k, v) -> {System.out.println(k + "," + v);});
		System.out.println(map.toString());
		
		
		System.out.println(map.toString());
	}
}
