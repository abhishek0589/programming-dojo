package com.abhishek.data.structure;

public class ListNodeRandom {
	
	public int val;
	public ListNodeRandom next;
	public ListNodeRandom random;

	public ListNodeRandom() {
	}
	
	public ListNodeRandom(int d) {
		this.val = d;
	}
	
	public ListNodeRandom(int d, ListNodeRandom n, ListNodeRandom r) {
		this.val = d;
		this.next = n;
		this.random = r;
	}

	public void print(ListNode l) {
		while (l.next != null) {
			System.out.print(l.val + "\t");
			l = l.next;
		}
		System.out.print(l.val + "\t");
	}
}
