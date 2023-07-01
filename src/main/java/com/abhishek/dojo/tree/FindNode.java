package com.abhishek.dojo.tree;

import java.util.List;

import com.abhishek.data.structure.BinaryTreeNode;
import com.abhishek.data.structure.TreeNode;

public class FindNode {
	
	// part 1- find in BST
	public static boolean findInBST(BinaryTreeNode root, int target) {
		if (root == null)
			return false;
		if (root.val == target) {
			return true;
		} else if (target < root.val) { // element must be in right
			return findInBST(root.left, target);
		} else if (target > root.val) {
			return findInBST(root.right, target); // element must be in left
		}
		return false;
	}

	// part 2- in unbalanced tree- find and return boolean- duplicates doesnt matter
	public static boolean findInBT(TreeNode root, int element) {
		if (root == null) {
			return false;
		}
		if (root.getVal() == element) {
			return true;
		}
		if (root.getChildren() != null) {
			for (TreeNode node : root.getChildren()) {
				return findInBT(node, element);
			}
		}
		return false;
	}

	// part 3- in unbalanced tree- find- duplicate MATTERS
	public static List<Integer> findAllInBT(TreeNode root, int element, List<Integer> result) {
		if (root == null) {
			return null;
		}
		if (root.getVal() == element) {
			result.add(root.getVal());
		}
		if (root.getChildren() != null) {
			for (TreeNode node : root.getChildren()) {
				findAllInBT(node, element, result);
			}
		}
		return result;
	}
}
