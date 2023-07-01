package com.abhishek.dojo.linkedlist;

import java.util.HashMap;
import java.util.Map;

import com.abhishek.data.structure.ListNodeRandom;

public class CopyWithRandomPointer {
	public static void main(String[] args) {
		CopyWithRandomPointer c = new CopyWithRandomPointer();
	}

	public ListNodeRandom copyRandomList(ListNodeRandom head) {
		ListNodeRandom current = head; Map<ListNodeRandom, ListNodeRandom> map = new HashMap<>();
		while (current!= null) {
			map.put(current, new ListNodeRandom(current.val));
			current = current.next;
		}
		// reset current again
		current = head; 
		while (current!=null){
			map.get(current).next = map.get(current.next);
			map.get(current).random = map.get(current.random);
			current = current.next;
		}
		return map.get(head);
	}
}
