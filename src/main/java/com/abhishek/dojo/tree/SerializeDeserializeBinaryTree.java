package com.abhishek.dojo.tree;
/*
  Serialize and Deserialize Binary Tree - LeetCode:
  https://leetcode.com/problems/serialize-and-deserialize-binary-tree/

  This code passes all Leetcode test cases as of April 26 2019
  Runtime: 12 ms, faster than 62.25% of Java online submissions for Serialize and Deserialize Binary Tree.
  Memory Usage: 39.4 MB, less than 71.37% of Java online submissions for Serialize and Deserialize Binary Tree.

  The video to explain this code is here: https://www.youtube.com/watch?v=suj1ro8TIVY
 */

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import com.abhishek.data.structure.BinaryTreeNode;
public class SerializeDeserializeBinaryTree {
	
	private static final String NULL_SYMBOL = "X";
	private static final String DELIMITER = ",";

	// PRE ORDER SERIALIZATION
	// Encodes a tree into a single string.
	public static String serialize(BinaryTreeNode root) {
		// If we have a null symbol...we encode a null symbol
		if (root == null) {
			return NULL_SYMBOL + DELIMITER;
		}
		// the key to tree problems is TO HAND OFF RESPONSIBILITY. Here
		String leftSerialized = serialize(root.left);
		String rightSerialized = serialize(root.right);
		// Here we append the node we hold ('root') to the other serializations
		//notice sequence here (similar to pre-order traversal)
		return root.val + DELIMITER + leftSerialized + rightSerialized; 
	}
	/*
    Here we take the string and simply split it on the delimiter. We then
    have a list of values we can materialize into nodes
	 */
	public static BinaryTreeNode deserialize(String data) {
		Queue<String> nodesLeftToMaterialize = new LinkedList<>();
		// split -> add all to list -> create queue from list
		nodesLeftToMaterialize.addAll(Arrays.asList(data.split(DELIMITER)));
		return deserializeHelper(nodesLeftToMaterialize);
	}
	
	/*
    We use a queue here so we don't have to keep overarching state (since
    the question description bars us from doing so). At any point in time when 
    this function is called we will know the next node to materialize. 
    We materialize a node, set its left and right subtrees respectively, and 
    then return the node itself
	 */

	// similar to- create binary tree from pre-order traversal
	public static BinaryTreeNode deserializeHelper(Queue<String> nodesLeftToMaterialize) {
		// note the sequence here- as string was originally created from preorder traversal
		// preorder traversal - root, left, right
		// below order- create root, deserialize left, desrialize right
		String valueForNode = nodesLeftToMaterialize.poll();
		if (valueForNode.equals(NULL_SYMBOL)) {
			return null;
		}
		// root, left, right -> preorder traversal
		BinaryTreeNode newNode = new BinaryTreeNode(Integer.valueOf(valueForNode));
		newNode.left = deserializeHelper(nodesLeftToMaterialize);
		newNode.right = deserializeHelper(nodesLeftToMaterialize);
		/*
	      I know what you are thinking..."how does the call to 'right' know
	      where to pick up where the 'left' call left off?
	      Well, the queue ensures that whatever is at the front is the next
	      node to process, we don't need to carry state between calls because
	      the queue enforces that ordering itself 
	     */
		return newNode;
	}
}
