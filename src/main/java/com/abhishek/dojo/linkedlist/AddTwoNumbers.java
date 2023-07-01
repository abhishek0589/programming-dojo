package com.abhishek.dojo.linkedlist;

import com.abhishek.data.structure.ListNode;
import com.abhishek.data.util.SysoutUtil;

public class AddTwoNumbers {

	public static void main(String[] args) {
		AddTwoNumbers add = new AddTwoNumbers();
		add.addTwoNumbers();
	}

	public void addTwoNumbers() {
		Solution s = new Solution();
		ListNode l1 = new ListNode(5), l1next = new ListNode(4), l1nextnext = new ListNode(3);
		l1.next = l1next; l1next.next = l1nextnext;
		SysoutUtil.linkedlist(l1);
		ListNode l2 = new ListNode(5),  l2next = new ListNode(6), l2nextnext = new ListNode(4);
		l2.next = l2next; l2next.next = l2nextnext;
		SysoutUtil.linkedlist(l2);
		SysoutUtil.linkedlist(s.addTwoNumbers(l1, l2));
	}

	public class Solution {
		public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
			if ( l1 == null && l2 == null )  return null; 
			if (l1  == null ) return l2;
			if (l2 == null ) return l2;

			// keep track of head of linkedlist while you are moving result to next pointer
			// important- initialize dummy with zero value. not going to be used. we are going to return dummy.next
			// NOTHING is added to dummy head. Elements added from next of dummy head (including carry)
			ListNode dummy = new ListNode(0); 
			ListNode result = dummy;
			int sum = 0, carry = 0;
			
			while (l1 != null || l2 != null) {
				sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + carry;
				if(l1 != null) l1 = l1.next;
				if(l2 != null) l2 = l2.next;
				result.next = new ListNode(sum % 10);
				result = result.next;
				carry = sum/10;
			}
			// handle last carry once everything is summed up
			if (carry > 0) result.next = new ListNode(carry);
			return dummy.next;
		}
	}

}
