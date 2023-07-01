package com.abhishek.dojo.tree;

import com.abhishek.data.structure.BinaryTreeNode;
import com.abhishek.data.structure.TreeNode;

public class MaxDepth {

	public static int maxDepth(BinaryTreeNode root) {
		if (root == null) return 0;
		int left = maxDepth(root.left);
		int right = maxDepth(root.right);
		return Math.max(left, right) + 1;
	}
	
	public static int maxDepth(TreeNode root) {
		if (root == null)
			return 0;
		int maxDepth = 0;
		if (root.getChildren() != null) {
			for (TreeNode child : root.getChildren()) {
				maxDepth = Math.max(maxDepth, maxDepth(child));
			}
		}
		return maxDepth + 1;
	}
}
