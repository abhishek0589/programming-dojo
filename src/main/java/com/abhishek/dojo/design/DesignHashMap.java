package com.abhishek.dojo.design;

class MyHashMap {
	final ListNode[] nodes = new ListNode[10000];
	class ListNode {
		int key, val;
		ListNode next;
		ListNode(int key, int val) {
			this.key = key;
			this.val = val;
		}
	}
	// while put- find function gets leading end of linkedlist, we need to get to
	// trailing end of linkedlist
	ListNode find(ListNode node, int key, boolean remove) {
		// exit in 2 conditions
		// when you reach end of the linkedlist- node.next = null
		// or when node.key is same as incoming keY
		while (node.next != null && node.key != key) {
			node = node.next;
		}
		return node;
	}

	public void put(int key, int value) {
		// get suitable index for given key
		int i = Integer.hashCode(key) % nodes.length;
		if (nodes[i] != null) {
			find(nodes[i], key, false).val = value;
		} else {
			nodes[i] = new ListNode(key, value);
		}
	}

	public int get(int key) {
		int i = Integer.hashCode(key) % nodes.length;
		if (nodes[i] == null)
			return -1;
		ListNode node = find(nodes[i], key, false);
		return node == null ? -1 : node.val;
	}

	public void remove(int key) {
		int i = Integer.hashCode(key) % nodes.length;
		if (nodes[i] == null)
			return;
		ListNode node = nodes[i];
		ListNode prev = null;
		if (node.next == null) {
			nodes[i] = null;
			return;
		}
		if (node.next != null && node.key != key) {
			prev = node;
			node = node.next;
		}
		if (node.key == key) {
			prev.next = node.next;
		} else {
			return;
		}
	}
}

public class DesignHashMap {
	public static void main(String[] args) {
		MyHashMap mhm = new MyHashMap();
		mhm.put(1, 11);
		mhm.put(5, 13);
		mhm.put(5, 14);
		mhm.remove(1);
		System.out.println(mhm.get(1));
	}
}
