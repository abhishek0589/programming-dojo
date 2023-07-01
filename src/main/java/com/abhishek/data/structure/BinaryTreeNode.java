package com.abhishek.data.structure;

import java.util.ArrayList;
import java.util.List;

// balanced binary tree- left less than root. Right greater than root.
public class BinaryTreeNode implements BinarySearchTree {
	
	public int val;
	public BinaryTreeNode left;
	public BinaryTreeNode right;

	public BinaryTreeNode(int value) {
		this.val = value;
	}

	public BinaryTreeNode insertLeft(int leftValue) {
		this.left = new BinaryTreeNode(leftValue);
		return this.left;
	}

	public BinaryTreeNode insertRight(int rightValue) {
		this.right = new BinaryTreeNode(rightValue);
		return this.right;
	}

	@Override
	public BinaryTreeNode addNode(int item) {
		add(this, item);
		return this;
	}

	@Override
	public BinaryTreeNode deleteNode(int key) {
		return delete(this, key);
	}

	@Override
	public boolean hasNode(int item) {
		return findInBST(this, item);
	}

	private BinaryTreeNode add(BinaryTreeNode root, int item) {
		if (root == null)
			root = new BinaryTreeNode(item);
		if (item < root.val)
			root.left = add(root.left, item);
		if (item > root.val)
			root.right = add(root.right, item);
		return root;
	}

	public BinaryTreeNode delete(BinaryTreeNode root, int key) {
		if (root == null)
			return root;
		List<Integer> list = new ArrayList<>();
		deleteHelper(root, list, key);
		root = null;
		if (list.size() > 0) {
			root = new BinaryTreeNode(list.get(0));
			for (int i = 1; i < list.size(); i++) {
				add(root, list.get(i));
			}
		}
		return root;
	}

	public void deleteHelper(BinaryTreeNode root, List<Integer> list, int key) {
		if (root == null)
			return;
		if (key != root.val)
			list.add(root.val);
		deleteHelper(root.left, list, key);
		deleteHelper(root.right, list, key);
	}

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

}
