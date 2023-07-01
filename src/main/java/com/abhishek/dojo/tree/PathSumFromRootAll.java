package com.abhishek.dojo.tree;

import java.util.ArrayList;
import java.util.List;

import com.abhishek.data.structure.BinaryTreeNode;

public class PathSumFromRootAll {

	public static int pathSum(BinaryTreeNode root, int sum) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> current = new ArrayList<>();
		helper(result, current, root, sum);
		return result.size();
	}

	public static void helper(List<List<Integer>> result, List<Integer> current, 
			BinaryTreeNode root, int sum) {
		if (root == null) return;
		else if (root.left == null && root.right == null && sum == root.val) {
            current.add(sum);
            result.add(new ArrayList<>(current));
            return;
		} else {
			current.add(root.val);
			helper(result, new ArrayList<>(current), root.left, sum-root.val);
			helper(result, new ArrayList<>(current), root.right, sum-root.val);
		}
	}
}
