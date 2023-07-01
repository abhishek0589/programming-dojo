package com.abhishek.dojo;

public class TypeErasure <K, V> {
	
	K key;
	V value;
	
	// BELOW CODE, even it looks correct, is broken due to type erasure
	/*
	 * public void set(K key) {
		this.key = key;
	}
	
	
	public void set(V value) {
		this.value = value;
	} */
}
