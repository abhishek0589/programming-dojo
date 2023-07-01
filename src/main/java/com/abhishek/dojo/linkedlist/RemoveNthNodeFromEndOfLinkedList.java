package com.abhishek.dojo.linkedlist;

import com.abhishek.data.structure.ListNode;

public class RemoveNthNodeFromEndOfLinkedList {
	public static void main(String[] args) {
		RemoveNthNodeFromEndOfLinkedList r = new RemoveNthNodeFromEndOfLinkedList();
		ListNode l1 = new ListNode(1), l1next = new ListNode(2), l1nextnext = new ListNode(3), l1nextnextnext = new ListNode(4);
		l1.next = l1next; l1next.next = l1nextnext; l1nextnext.next = l1nextnextnext; l1nextnextnext.next = null;
		r.removeNthFromEnd(l1, 2);
	}

	public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null && n == 1) return null;
        ListNode slow = head, fast = head;
		int i = 0;
		while (i < n) {
			fast = fast.next;
			i++;
		} 
		ListNode prev = null;
		while (fast != null) {
			prev = slow;
			slow = slow.next;
			fast = fast.next;
		}
		// dont use prev if its null
		// for cases such as [3,4] and n = 2. prev=null. slow=3.fast=4. prev.next will be NPE and hence the else part.
		if (prev != null) prev.next = slow.next;  
        else head = slow.next;
        return head;
	}
}
