package com.abhishek.dojo.design;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

//Approach 2- Slower- LinkedHashMap

//LC- 18 / 18 test cases passed
//Runtime: 69 ms, faster than 18.53% of Java online submissions for LRU Cache.
//Memory Usage: 56.3 MB, less than 65.03% of Java online submissions for LRU Cache.

public class LRUCacheLinkedHashMap {

	public int capacity;
	public LinkedHashMap<Integer, Integer> map;

	public LRUCacheLinkedHashMap(int capacity) {
		this.capacity = capacity;
		this.map = new LinkedHashMap<>();
	}

	public int get(int key) {
		boolean itemFound = this.map.containsKey(key);
		if (!itemFound) {
			return -1;
		}
		moveToTop(key);
		return this.map.get(key);

	}

	private void moveToTop(int key) {
		int value = this.map.get(key);
		this.map.remove(key);
		// note- call put in cache class, not map class
		put(key, value);
	}

	public void put(int key, int value) {
		// map- 2,6 | 1,2 | put--> 1,5
		// if we dont do containskey check then 2, 6 gets removed
		// ideal behavior is only 1,2 should be updated with 1,5
		if (this.map.containsKey(key)) {
			this.map.remove(key);
		} else if (this.map.size() == capacity) {
			removeFirstEntry();
		}
		this.map.put(key, value);
	}

	private void removeFirstEntry() {
		Iterator<Map.Entry<Integer, Integer>> itr = map.entrySet().iterator();
		while (itr.hasNext()) {
			itr.next();
			itr.remove();
			break;
		}
	}
}

class CacheRunner {

	public static void main(String[] args) {
		LRUCacheLinkedHashMap cache = new LRUCacheLinkedHashMap(2);
		cache.get(2);
		cache.put(2, 6);
		cache.get(1);
		cache.put(1, 5);
		cache.put(1, 2);
		cache.get(1);
		cache.get(2);
		System.out.println(cache.map);
	}
}
