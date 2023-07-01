package com.abhishek.dojo.tree;

import com.abhishek.data.structure.BinaryTreeNode;

/* Case 1- Binary tree rightmost element not having any subtree- 2nd largest would be root of rightmost subtree    
                       50                       
            ┌───────────┴───────────┐           
           30                      70           
      ┌─────┴─────┐           ┌─────┴─────┐     
     10          40          60          [80] <---- Second largest    
                                       ┌──┴──┐  
                                      75    90  
  Case 1- Binary tree with rightmost element having left subtree- 2nd largest would be largest of leftmost subtree
                                              	50                                              
                        ┌───────────────────────┴───────────────────────┐                       
                       30                                              70                       
            ┌───────────┴───────────┐                       ┌───────────┴───────────┐           
           10                      40                      60                      80           
                                                                              ┌─────┘           
                                                                             75<---Second largest                 
                                                                           ┌──┴──┐              
                                                                          74    [76] (rightmost has no left or right)
 */
public class FindSecondLargest {
	
	public static int findLargest(BinaryTreeNode root) {
		int largest = 0;
		while (root != null) {
			largest = root.val;
			root = root.right;
		}
		return largest;
	}
	
	public static int findLargestRecursive(BinaryTreeNode root) {
		if (root == null ) return 0;
		if (root.right != null) return findLargest(root.right);
		return root.val;
	}


	public static int secondLargestRecursive(BinaryTreeNode root) {
		if (root == null) return 0;
		if (root.right != null && root.right.right == null && root.right.left == null) {
			return root.val;
		}
		if (root.right == null && root.left != null) {
			return findLargestRecursive(root.left);
		}
		return secondLargestIterative(root.right);
	}

	// logic for finding second largest element in binary tree
	public static int secondLargestIterative(BinaryTreeNode root) {
		if (root == null) return 0;
		while (root != null) {
			// 1- current is parent of of largest and largest doesnt has left or right subtree
			// largest is parent of rightmost element
			if (root.right != null && root.right.right == null && root.right.left == null) {
				return root.val;
			}
			// 2- current is largest and current has a left subtree- // largest is rightmost element of left subtree
			if (root.right == null && root.left != null) {
				return findLargest(root.left);
			}
			//traverse only in right direction as left direction is not having larger values 
			root = root.right;
		}
		return 0;
	}
}