package com.abhishek.dojo.tree;

import com.abhishek.data.structure.BinaryTreeNode;

public class SubTreeInTree {
	public static boolean isSubset(BinaryTreeNode n1, BinaryTreeNode n2) {
		String s1= SerializeDeserializeBinaryTree.serialize(n1);
		String s2= SerializeDeserializeBinaryTree.serialize(n2);
		return s1.contains(s2);
	}
}