package com.abhishek.dojo.tree;

import com.abhishek.data.structure.BinaryTreeNode;

public class SymmetricBST {
	public static boolean isSymmetric(BinaryTreeNode root) {
		if (root == null) {
			return false;
		}
		return isSymmetric(root.left, root.right);
	}

	public static boolean isSymmetric(BinaryTreeNode a, BinaryTreeNode b) {
		if (a != null && b != null) {
			return a.val == b.val && isSymmetric(a.left, b.right) && isSymmetric(a.right, b.left);
		} else if (a == null && b == null) {
			return true;
		} else {
			return false;
		}
	}
}
