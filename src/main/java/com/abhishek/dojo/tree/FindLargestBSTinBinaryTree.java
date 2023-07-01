package com.abhishek.dojo.tree;

import com.abhishek.data.structure.BinaryTreeNode;

//Data structure to store information about binary tree rooted under a node
class SubTreeInfo {
	// stores the min and the max value in the binary tree rooted under the current node
	int min, max; // min, max fields are relevant only if isBST flag is true
	int size; // stores the size of largest BST in binary tree rooted under the current node
	boolean isBST; // true if binary tree rooted under the current node is a BST

	SubTreeInfo(int min, int max, int size, boolean isBST) {
		this.min = min;
		this.max = max;
		this.size = size;
		this.isBST = isBST;
	}

	@Override
	public String toString() {
		return "SubTreeInfo [min=" + min + ", max=" + max + ", size=" + size + ", isBST=" + isBST + "]";
	}
	
};

public class FindLargestBSTinBinaryTree {
	// Recursive function to find the size of the largest BST in a given binary tree
	public static SubTreeInfo findLargestBST(BinaryTreeNode root) {
		if (root == null) {	// Base case: empty tree
			return new SubTreeInfo(Integer.MAX_VALUE, Integer.MIN_VALUE, 0, true);
		}
		
		System.out.println("current root: " + root.val);
				
		// Recur for left subtree and right subtrees
		SubTreeInfo left = findLargestBST(root.left);
		System.out.println("left: " + root.left + ", " + left.toString());
		SubTreeInfo right = findLargestBST(root.right);
		System.out.println("right: " + root.right + ", " +  right.toString());

		
		SubTreeInfo info = null;
		// Check if binary tree rooted under the current root is a BST
		// 1. Left and right subtree are also BST
		// 2. The value of the root node should be more than the largest value in the left subtree
		// 3. The value of the root node should be less than the smallest value in the right subtree
		if (left.isBST && right.isBST && (root.val > left.max && root.val < right.min)) {
			info = new SubTreeInfo( Math.min(root.val, Math.min(left.min, right.min)),
					Math.max(root.val, Math.max(left.max, right.max)), 
					left.size + 1 + right.size, 
					true);
		} else {
			// If binary tree rooted under the current root is not a BST
			// return the size of largest BST in its left and right subtree
			info = new SubTreeInfo(0, 0, Math.max(left.size, right.size), false);
		}
		System.out.println("current root: " + root.val + ", " + info.toString());
		return info;
	}

}
