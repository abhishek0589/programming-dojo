
package com.abhishek.dojo.tree;

import com.abhishek.data.structure.BinaryTreeNode;

public class ValidBinarySearchTree {

	public static boolean isValidBinarySearchTree(BinaryTreeNode root) {
		// first invocation to start with min and max bounds
		
		// use lower bound and upper bound approach for left and right half of the subtree separately
		// left subtree (all element should be lesser than root)
		// -> lower bound => no restriction  |  upper bound =>  value of root
		// right subtree (all elements should be greater than root) 
		// -> lower bound =>  value of root | upper bound =>  no restriction
		
		return rangeVerify(root, Long.MAX_VALUE, Long.MIN_VALUE);
	}

    public static boolean rangeVerify(BinaryTreeNode root, long upper, long lower){
        if (root == null) return true;
        if (root.val > lower && root.val < upper){
            return rangeVerify(root.right, upper, root.val) && rangeVerify(root.left, root.val, lower);
        }
        return false;
    }
}
