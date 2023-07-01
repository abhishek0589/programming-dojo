package com.abhishek.dojo.linkedlist;

import com.abhishek.data.structure.ListNode;

public class ReverseLinkedList {

	public static void main(String[] args) {
		ReverseLinkedList rll = new ReverseLinkedList();
		ListNode head = constructMockData();
		System.out.println("LinkedList before: ");
		head.print(head);
		ListNode reverse = rll.reverse(head);
		System.out.println("\nLinkedList after: ");
		reverse.print(reverse);
	}

	private static ListNode constructMockData() {
		ListNode head = new ListNode(10);
		ListNode first = new ListNode(5);
		ListNode second = new ListNode(7);
		ListNode third = new ListNode(6);
		head.next = first;
		first.next = second;
		second.next = third;
		third.next = null;
		return head;
	}

	public ListNode reverse(ListNode head) {
		ListNode current = head;
		// KEY to understand- current needs to march forward and transition everything to previous
		// change current's next first and then current itself
		// current's next should have previous and then previous should have current
		// at th end previous will become the head and same needs to be returned
		
		ListNode previous = null;
		ListNode next = null;
		// Step 1 and 4 are keeping the show on
		// Step 2 and 3 are doing reverse
		while (current != null) {
			// step 1- backup next. 
			next = current.next;
			// step 2- assign next to previous. REMEMBER- Override pointer location first and not current
			current.next = previous;
			// step 3- reverse current and previous
			previous = current;
			// step 4- move on to next and repeat same
			current = next;
		}
		// note that we are returning previous and NOT head
		return previous;
	}
}


