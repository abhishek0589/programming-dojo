package com.abhishek.dojo.tree;

import com.abhishek.data.structure.BinaryTreeNode;

//https://leetcode.com/problems/path-sum/solution/
public class PathSumFromRootAny {
	// can be done in recursive as well as iterative way
	public static boolean hasPathSum(BinaryTreeNode root, int sum) {
		if (root == null)
			return false;
		if (root.left == null && root.right == null)
			return root.val == sum;
		return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
	}
}
