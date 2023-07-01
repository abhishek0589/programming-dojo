package com.abhishek.dojo.lru;

import java.util.Iterator;
import java.util.LinkedHashMap;

/*
 * Design and implement a data structure for Least Recently Used (LRU) cache. 
 * It should support the following operations: get and put. get(key) - Get the value (will always be positive)
 *  of the key if the key exists in the cache, otherwise return -1. put(key, value) - Set or insert the value 
 *  if the key is not already present. When the cache reached its capacity, it should invalidate the least 
 *  recently used item before inserting a new item.
 * Could you do both operations in O(1) time complexity?
 * Example:
 * LRUCache cache = new LRUCache( 2); //capacity//
 * cache.put(1, 1);
 * cache.put(2, 2);
 * cache.get(1);       // returns 1
 * cache.put(3, 3);    // evicts key 2
 * cache.get(2);       // returns -1 (not found)
 * cache.put(4, 4);    // evicts key 1
 * cache.get(1);       // returns -1 (not found)
 * cache.get(3);       // returns 3
 * cache.get(4);       // returns 4
 * 
 * */
public class BetterLRUCache {

	private int capacity;
	private LinkedHashMap<Integer, Integer> map;

	public BetterLRUCache() {
		// TODO Auto-generated constructor stub
	}

	public BetterLRUCache(int capacity, LinkedHashMap<Integer, Integer> map) {
		this.capacity = capacity;
		this.map = map;
	}
	
	public int get(int k) {
        Integer value = this.map.get(k);
		if (this.map.get(k) == null) {
			return -1;
		}else {
			this.put(k, value);
		}
		return this.map.get(k);
	}

	public void put(int k, int v) {
		if (map.containsKey(k)) {
			this.map.remove(k);
		}else if (map.size() == this.capacity){
			Iterator<Integer> iterator = this.map.keySet().iterator();
			iterator.next();
			iterator.remove();
		}
		map.put(k, v);
	}

}
