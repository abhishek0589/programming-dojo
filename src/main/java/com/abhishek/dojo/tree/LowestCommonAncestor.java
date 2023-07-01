package com.abhishek.dojo.tree;

import com.abhishek.data.structure.BinaryTreeNode;

// CASES to think on-
// what if two nodes lie on same branch (like both nodes one below other on right
// what if one node exists and other doesnt
public class LowestCommonAncestor {
	
	public static BinaryTreeNode balanced(BinaryTreeNode root, BinaryTreeNode item1,
			BinaryTreeNode item2) {
		if (item1.val > root.val && item2.val > root.val) {
			return balanced(root.right, item1, item2);
		} else if (item1.val < root.val && item2.val < root.val) {
			return balanced(root.left, item1, item2);
		} else {
			return root;
		}
	}

	public static BinaryTreeNode unbalanced(BinaryTreeNode root, BinaryTreeNode item1,
			BinaryTreeNode item2) {
		
		if (root == null) return null;
		
		if (root == item1 || root == item2) return root; // find desired element
		
		BinaryTreeNode left = unbalanced(root.left, item1, item2);
		BinaryTreeNode right = unbalanced(root.right, item1, item2);
		
		// what do with left and right?
		// if both null then return null
		// if both not null then LCA
		// if one of them not null then return not null element only
		
		if (left != null && right != null) return root; // if both not null- we have found ancestor
		if (left == null && right == null) return null; // if both null- elements were not found
		return left != null ? left : right; // important- navigates node to upper levels
	}
}
