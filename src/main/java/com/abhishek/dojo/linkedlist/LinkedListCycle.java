package com.abhishek.dojo.linkedlist;

import com.abhishek.data.structure.ListNode;

public class LinkedListCycle {
	public static void main(String[] args) {
		LinkedListCycle l = new LinkedListCycle();

		ListNode l1 = new ListNode(3), l1next = new ListNode(2), l1nextnext = new ListNode(0), l1nextnextnext = new ListNode(-4);
		l1.next = l1next; l1next.next = l1nextnext; l1nextnext.next = l1nextnextnext; l1nextnextnext.next = l1next;

		System.out.println(l.hasCycle(l1));
	}

	public boolean hasCycle(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		while (slow != null && fast != null) {
			slow = slow.next;
			fast = fast.next;
			if (fast != null) fast = fast.next;
			else return false;
			if (slow == fast) return true;
		}
		return false;
	}

}
