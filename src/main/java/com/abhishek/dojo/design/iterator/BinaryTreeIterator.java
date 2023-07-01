package com.abhishek.dojo.design.iterator;

import java.util.ArrayList;
import java.util.List;

import com.abhishek.data.structure.BinaryTreeNode;

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */

// https://leetcode.com/problems/binary-search-tree-iterator/submissions/
public class BinaryTreeIterator {

	List<Integer> flat;
	int cursor = 0;

	public BinaryTreeIterator(BinaryTreeNode root) {
		flat = new ArrayList<Integer>();
		flatten(root);
	}

	public void flatten(BinaryTreeNode root){
		if (root == null) return;
		flatten(root.left);
		flat.add(root.val);
		flatten(root.right);
	}

	/** @return the next smallest number */
	public int next() {
		return cursor < flat.size() ? flat.get(cursor++) : -1;
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		return cursor < flat.size();
	}
}
