package com.abhishek.dojo.tree;

import com.abhishek.data.structure.BinaryTreeNode;

public class IdenticalTree {

	public static boolean isIdentical(BinaryTreeNode a, BinaryTreeNode b) {
		if (a == null && b == null)
			return true;
		
		return (a.val == b.val && 
				isIdentical(a.left, b.left) && 
					isIdentical(a.right, b.right));
	}
}
