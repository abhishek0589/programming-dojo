package com.abhishek.dojo.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.abhishek.data.structure.BinaryTreeNode;

public class MinDifferenceInBST {

	// approach 1- add all to collection using preorder dfs and then use greedy approach to get minimum
	List<Integer> vals;
    public int minDiffInBST(BinaryTreeNode root) {
        vals = new ArrayList<>();
        dfs(root);
        Collections.sort(vals);

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < vals.size() - 1; ++i)
            ans = Math.min(ans, vals.get(i+1) - vals.get(i));

        return ans;
    }

    public void dfs(BinaryTreeNode node) {
        if (node == null) return;
        vals.add(node.val);
        dfs(node.left);
        dfs(node.right);
    }

	// approach 2- use in order traversal
	Integer prev, ans;
	public int minDiffInBST1(BinaryTreeNode root) {
		prev = null;
		ans = Integer.MAX_VALUE;
		dfs(root);
		return ans;
	}

	public void dfs1(BinaryTreeNode node) {
		if (node == null) return;
		dfs(node.left);
		if (prev != null)
			ans = Math.min(ans, node.val - prev);
		prev = node.val;
		dfs(node.right);
	}
}
