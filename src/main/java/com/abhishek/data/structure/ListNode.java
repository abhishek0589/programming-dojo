package com.abhishek.data.structure;

public class ListNode {

	public int val;
	public ListNode next;

	public ListNode() {
	}
	
	public ListNode(int d) {
		this.val = d;
	}
	
	public ListNode(int d, ListNode n) {
		this.val = d;
		this.next = n;
	}

	public void print(ListNode l) {
		while (l.next != null) {
			System.out.print(l.val + "\t");
			l = l.next;
		}
		System.out.print(l.val + "\t");
	}
}
