package com.abhishek.dojo.design;

import java.util.HashMap;
import java.util.Map;

public class LFUCache {
	class Node {
		int key, val, cnt;
		Node prev, next;
		Node(int key, int val) {
			this.key = key;
			this.val = val;
			cnt = 1;
		}
	}

	class DLList {
		Node head, tail;
		int size;
		DLList() {
			head = new Node(0, 0);
			tail = new Node(0, 0);
			head.next = tail;
			tail.prev = head;
		}

		void add(Node node) {
			head.next.prev = node;
			node.next = head.next;
			node.prev = head;
			head.next = node;
			size++;
		}

		void remove(Node node) {
			node.prev.next = node.next;
			node.next.prev = node.prev;
			size--;
		}

		Node removeLast() {
			if (size > 0) {
				Node node = tail.prev;
				remove(node);
				return node;
			}
			else return null;
		}
	}

	int capacity, leastFrequenyCount;
	// consists of keys vs nodes [with keys and values]
	Map<Integer, Node> nodeMap;
	// consists of frequency vs doubly linked list of items
	// if key 1, key 2 and key 3 are occuring only once then,  map would like below
	// 1 -> head -> node key1 -> node key2 -> node key3

	// lets say with key 1 was updated again, then map would update as below
	// 1 -> head -> node key1 -> node key3
	// 2 -> head -> node key1
	Map<Integer, DLList> countMap;

	public LFUCache(int capacity) {
		this.capacity = capacity;
		nodeMap = new HashMap<>();
		countMap = new HashMap<>();
	}

	public int get(int key) {
		Node node = nodeMap.get(key);
		if (node == null) return -1;
		update(node);
		return node.val;
	}

	public void put(int key, int value) {
		if (capacity == 0) return;
		Node node;
		// possibility 1
		if (nodeMap.containsKey(key)) {
			// get current node status- use same node in count map doubly linkedlist
			node = nodeMap.get(key);
			node.val = value;
			// if exists already then there will direct impact on frequency aka count map
			// update count map. Move the node from old frequency key and associate it with new frequency key 
			// new frequency key may or may not exists already
			update(node);
		}
		else {
			// possibility 2
			if (nodeMap.size() == capacity) {
				DLList lastList = countMap.get(leastFrequenyCount);
				nodeMap.remove(lastList.removeLast().key);
			}
			// possibility 3
			node = new Node(key, value);
			nodeMap.put(key, node);
			leastFrequenyCount = 1;
			DLList newList = countMap.getOrDefault(node.cnt, new DLList());
			newList.add(node);
			countMap.put(node.cnt, newList);
		}
	}

	// consists of frequency vs doubly linked list of items
	// if key 1, key 2 and key 3 are occurring only once then,  map would like below
	// 1 -> head -> node key1 -> node key2 -> node key3

	// lets say with key 1 was updated again, then map would update as below
	// 1 -> head -> node key1 -> node key3
	// 2 -> head -> node key1

	private void update(Node node) {
		DLList oldList = countMap.get(node.cnt);
		oldList.remove(node);
		// keep track of lowest frequency. One of the indicators of lowest frequency is, oldList size becoming zero
		// it indicates that one count level has gone completely empty and lowest frequency count needs to be updated 
		if (node.cnt == leastFrequenyCount /* <---why this condition*/ 
				&& oldList.size == 0 /*understood this cond ---> */) {
			leastFrequenyCount++;
		}
		node.cnt++;
		DLList newList = countMap.getOrDefault(node.cnt, new DLList());
		newList.add(node);
		countMap.put(node.cnt, newList);
	}

	public static void main(String[] args) {
		LFUCache c = new LFUCache(3);
		c.put(3, 4);
		c.put(1, 2); 
		c.put(2, 2); 
		c.put(3, 2); 
		c.put(2, 2); 
		c.put(1, 2); 
		c.put(4, 6); 
		c.put(5, 6); // 4 need to be evicted

	}
}
