package com.abhishek.dojo.tree;

import com.abhishek.data.structure.BinaryTreeNode;

/*	
 	a path sum is sum of two paths, one from left and other from right, through a route or non route node
 	 			__
 	8 -> 5 -> | 15 |-> 20 -> 25 -> 30 = 103
				__

                       15                       
            ┌───────────┴───────────┐           
            5                      20           
      ┌─────┴─────┐           ┌─────┴─────┐     
      1           8          18          25     
                                       ┌──┴──┐  
                                      22    30  

 */

public class PathSumMax {
	
	static int result = Integer.MIN_VALUE;

	public static int helper(BinaryTreeNode root) {
		if (root == null) return 0;

		// max sum on the left and right sub-trees of node
		int l = helper(root.left);
		int r = helper(root.right);
		int maxlr = Math.max(l, r);
		int maxSinglePath = Math.max(root.val, maxlr + root.val);
		// the price to start a new path where `node` is a highest node
		// update max_sum if it's better to start a new path
		int maxBothPaths = Math.max(maxSinglePath, root.val + l + r);
		result = Math.max(maxBothPaths, result);
		// for recursion return the max gain if continue the same path
		// note- we need to consider only one node so that only single path is picked
		return maxSinglePath;
	}

	public static int maxPathSum(BinaryTreeNode root) {
		helper(root);
		return result;
	}
}
