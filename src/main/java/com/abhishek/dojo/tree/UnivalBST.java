package com.abhishek.dojo.tree;

import java.util.HashSet;

import com.abhishek.data.structure.BinaryTreeNode;

/*
  
  
                         20                       
            ┌───────────┴───────────┐           
           20                      20           
      ┌─────┴─────┐           ┌─────┴─────┐     
     20          20          20          20     
                                       ┌──┴──┐  
                                      20    20  
  
 */
public class UnivalBST {

	public static boolean isUnival(BinaryTreeNode root) {
		HashSet<Integer> set = new HashSet<Integer>();
		isUnival(root, set);
		return set.size() == 1;
	}

	public static void isUnival(BinaryTreeNode root, HashSet<Integer> set) {
		if (root == null) {
			return;
		}
		isUnival(root.left, set);
		set.add(root.val);
		isUnival(root.right, set);
	}
}
