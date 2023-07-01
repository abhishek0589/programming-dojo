package com.abhishek.dojo.tree;

import java.util.ArrayList;
import java.util.List;

import com.abhishek.data.structure.BinaryTreeNode;

// perform inorder traversal and return k-1 element
public class KthSmallestElementInBST {
	
	public static int kthSmallest(BinaryTreeNode root, int k) {
		List<Integer> nums = inorder(root, new ArrayList<Integer>());
		return nums.get(k - 1);
	}
	
	public static List<Integer> inorder(BinaryTreeNode root, List<Integer> list) {
		if (root == null) 
			return list;//note this- in case of null, return list
		inorder(root.left, list);
		list.add(root.val);
		inorder(root.right, list);
		return list; //return list again
	}
	
}
