package com.abhishek.dojo.design;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

	Map<Integer, Node> map;
	DList dlist;
	int capacity;

	class DList {
		Node head, tail;
		DList() {
			head = new Node(-1, -1);
			tail = new Node(-1, -1);
			head.link(tail);
		}
	}

	class Node {
		int key, value;
		Node prev, next;

		Node(int key, int value) {
			this.key = key;
			this.value = value;
			this.next = this.prev = null;
		}

		public void link(Node node) {
			this.next = node;
			node.prev = this;
		}
	}

	LRUCache(int cap) {
		this.capacity = cap;
		dlist = new DList();
		map = new HashMap<>();
	}

	public int get(int key) {
		if (!map.containsKey(key)) return -1;
		put(key, map.get(key).value);
		return map.get(key).value;
	}

	public void put(int key, int value) {
		if (map.containsKey(key)) remove(map.get(key));
		if (map.size() == capacity) remove(dlist.tail.prev);
		add(key, value);
	}

	public void remove(Node node) {
		node.prev.link(node.next);
		map.remove(node.key);
	}

	public void add(int key, int value) {
		Node node = new Node(key, value);
		node.link(dlist.head.next);
		dlist.head.link(node);
		map.put(key, node);
	}

	public static void main(String[] args) {
		LRUCache c = new LRUCache(2);
		c.put(1, 1);
		c.put(2, 2);
		System.out.println(c.get(1));
		c.put(3, 3);
		System.out.println(c.get(2));
		c.put(4, 4);
		System.out.println(c.get(1));
		System.out.println(c.get(3));
		System.out.println(c.get(4));
	}
}
