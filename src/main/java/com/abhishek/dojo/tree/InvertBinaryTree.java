package com.abhishek.dojo.tree;

import com.abhishek.data.structure.BinaryTreeNode;

public class InvertBinaryTree {
	public static BinaryTreeNode invert(BinaryTreeNode root) {
		if (root == null) return null;
		BinaryTreeNode left = invert(root.left);
		BinaryTreeNode right = invert(root.right);
		root.left = right;
		root.right = left;
		return root;
	}
}