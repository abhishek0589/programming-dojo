package com.abhishek.dojo.array;

import java.util.PriorityQueue;

import com.abhishek.data.structure.ListNode;

public class MergeKSortedArrays {
	
	public ListNode mergeKLists(ListNode[] lists) {
		if (lists == null || lists.length == 0) return null;
		PriorityQueue<ListNode> q = new PriorityQueue<>((a, b) -> (a.val - b.val));
		ListNode dummy = new ListNode(0), result = dummy;
		for (ListNode item : lists) {
			if (item != null) q.offer(item);
		}
		while (!q.isEmpty()) {
			ListNode current = q.poll();
			result.next = current;
			result = result.next;
			if (current.next != null) q.offer(current.next);
		}
		return dummy.next;
	}

}
