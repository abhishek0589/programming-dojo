package com.abhishek.dojo.lru;

import java.util.LinkedHashMap;

public class LRUCache<K,V> extends LinkedHashMap<K, V>{
	
	private int size = 5;
	
	private LRUCache(int size) {
		this.size = size;
	}
	
	@Override
	protected boolean removeEldestEntry(java.util.Map.Entry<K, V> eldest) {
		return size() > size;
	}
	
	// create a singleton the method
	public static <K,V> LRUCache<K, V> getInstance(int size){
		return new LRUCache<K, V>(size);
	}
	
	@Override
	public V get(Object key) {
		 V value = super.get(key);
		 return super.get(key);
	}
	
}
