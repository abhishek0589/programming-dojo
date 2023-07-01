package com.abhishek.data.structure;

import java.util.List;

// unbalanced binary tree
public class TreeNode {
	
	
	public int val;
	public List<TreeNode> children;

	public TreeNode(int x) {
		setVal(x);
	}

	public int getVal() {
		return val;
	}

	public void setVal(int val) {
		this.val = val;
	}

	public List<TreeNode> getChildren() {
		return children;
	}

	public void setChildren(List<TreeNode> children) {
		this.children = children;
	}
}