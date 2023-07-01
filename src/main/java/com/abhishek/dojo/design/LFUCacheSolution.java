package com.abhishek.dojo.design;

import java.util.HashMap;
import java.util.LinkedHashSet;

public class LFUCacheSolution {

	public static void main(String[] args) {
		LFUCache cache = new LFUCacheSolution().new LFUCache( 2 /* capacity */ );

		cache.put(1, 1);
		cache.put(2, 2);
		cache.get(1);       // returns 1
		cache.put(3, 3);    // evicts key 2
		cache.get(2);       // returns -1 (not found)
		cache.get(3);       // returns 3.
		cache.put(4, 4);    // evicts key 1.
		cache.get(1);       // returns -1 (not found)
		cache.get(3);       // returns 3
		cache.get(4);       // returns 4

	}
	
	class LFUCache{
		
		HashMap<Integer, Integer> vals;
		HashMap<Integer, Integer> counts;
		HashMap<Integer, LinkedHashSet<Integer>> cache;
		int cap;
		int min = -1;

		public LFUCache(int capacity) {
			cap = capacity;
			vals = new HashMap<>();
			counts = new HashMap<>();
			cache = new HashMap<>();
			cache.put(1, new LinkedHashSet<>());
		}

		public int get(int key) {
			// if not found return -1
			if(!vals.containsKey(key))
				return -1;
			// increase count by 1 
			int count = counts.get(key);
			counts.put(key, count+1);
			
			cache.get(count).remove(key);
			if(count==min && cache.get(count).size()==0)
				min++;
			if(!cache.containsKey(count+1))
				cache.put(count+1, new LinkedHashSet<>());
			cache.get(count+1).add(key);
			return vals.get(key);
		}

		public void put(int key, int value) {
			if(cap<=0)
				return;
			if(vals.containsKey(key)) {
				vals.put(key, value);
				get(key);
				return;
			} 
			if(vals.size() >= cap) {
				int evit = cache.get(min).iterator().next();
				cache.get(min).remove(evit);
				vals.remove(evit);
			}
			vals.put(key, value);
			counts.put(key, 1);
			min = 1;
			cache.get(1).add(key);
		}
	}
}