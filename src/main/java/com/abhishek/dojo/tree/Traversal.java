// https://leetcode.com/problems/binary-tree-preorder-traversal/discuss/185866/JavaScript-Simple-iterative-solution
/*
 * 
 * var preorderTraversal = function(root) {
  const result = [];
  const stack = [];
  let node = root;

  while (node) {
    node.val && result.push(node.val);  
    node.right && stack.push(node.right);      
    node = node.left || stack.pop(); 
  }

  return result;
};

 * 
 * 
 * 
 */
package com.abhishek.dojo.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import com.abhishek.data.structure.BinaryTreeNode;
import com.abhishek.data.structure.TreeNode;

//@TODO: Modify iterative traversal techniques to add output to a list

public class Traversal {
	/*==========     RECURSIVE   =================*/
	// INORDER- Left, Root, Right
	public static void inOrder(BinaryTreeNode root) {
		if (root == null) return;	
		inOrder(root.left);
		System.out.print(root.val + "\t");
		inOrder(root.right);
	}

	// PREORDER- Root, left, Right
	public static void preOrder(BinaryTreeNode root) {
		if (root == null) return;
		System.out.print(root.val + "\t");
		preOrder(root.left);
		preOrder(root.right);
	}

	// POST-ORDER Left, Right, Root
	public static void postOrder(BinaryTreeNode root) {
		if (root == null) return;
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.val + "\t");
	}

	/*==========     ITERATIVE   =================*/
	// Left, Root, Right
	// 				  2
	// 				 /\
	//				3  4
	//			   /\
	//			  7  8			
	// stack
	// 7
	// 3
	// 2
	// in order traversal- 
	// push -> pop -> print-> move right
	// important- item below left node is root node
	// move leftmost subtree ->left of leftmost (null)-> pop from stack (7) -> move right (null) -> pop next item (**this is root**) (3) -> move right (8)-> Push to stack
	// 7-> 3-> 8
	public static void inOrderItr(BinaryTreeNode root) {
		Deque<BinaryTreeNode> stack = new ArrayDeque<>();
		BinaryTreeNode p = root;
		while(!stack.isEmpty() || p != null) {
			if(p != null) {
				stack.push(p);
				p = p.left;
			} else {
				BinaryTreeNode node = stack.pop();
				System.out.print(node.val + "\t");  // Add after all left children
				p = node.right;   
			}
		}
	}

	// Root, left, Right
	public static void preOrderItr(BinaryTreeNode root) {
		Deque<BinaryTreeNode> stack = new ArrayDeque<>();
		BinaryTreeNode p = root;
		while(!stack.isEmpty() || p != null) {
			if(p != null) {
				stack.push(p);
				System.out.print(p.val + "\t");  // Add before going to children
				p = p.left;
			} else {
				BinaryTreeNode node = stack.pop();
				p = node.right;   
			}
		}
	}

	// Left, Right, Root
	public static void postOrderItr(BinaryTreeNode root) {
		System.out.println("INCORRECT-NEEDS TO BE FIXED");
		Deque<BinaryTreeNode> stack = new ArrayDeque<>();
		BinaryTreeNode p = root;
		while(!stack.isEmpty() || p != null) {
			if(p != null) {
				stack.push(p);
				p = p.left; // Reverse the process of preorder
			} else {
				BinaryTreeNode node = stack.pop();
				p = node.right; // Reverse the process of preorder
				System.out.print(node.val + "\t");  // Reverse the process of preorder
			}
		}
	}

	// level order traversal, also known as bread first search
	public static void levelorderTraversalBinaryTree(BinaryTreeNode root) {
		Queue<BinaryTreeNode> q = new LinkedList<>();
		List<Integer> result = new ArrayList<>();
		q.offer(root);
		while (!q.isEmpty()) {
			//int size = q.size(); -- LEVEL TRACKING IS NOT NEEDED HERE
			List<Integer> intermediate = new ArrayList<>();
			//for (int i = 0; i < size; i++) {
			BinaryTreeNode current = q.remove();
			intermediate.add(current.val);
			if(current.left != null) {
				q.offer(current.left);
			}
			if(current.right != null) {
				q.offer(current.right);
			}
			//}
			result.addAll(intermediate);
		}
		result.forEach(item -> System.out.println(item));
	}
	
	public List<Integer> rightSideView(BinaryTreeNode root) {
        // reverse level traversal
        List<Integer> result = new ArrayList<>();
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        if (root == null) return result;
        queue.offer(root);
        while (queue.size() != 0) {
            int size = queue.size();
            for (int i=0; i<size; i++) {
            	BinaryTreeNode cur = queue.poll();
                if (i == 0) result.add(cur.val);
                if (cur.right != null) queue.offer(cur.right);
                if (cur.left != null) queue.offer(cur.left);
            }
            
        }
        return result;
    }


	public List<List<Integer>> levelOrderNaryTree(TreeNode root) {
		List<List<Integer>> r = new ArrayList<>();
		Queue<TreeNode> q = new LinkedList<>();
		if (root == null) return r;
		q.add(root);
		while(!q.isEmpty()){
			int size = q.size();
			List<Integer> levelList = new ArrayList<>();
			for (int i = 0; i < size; i++){
				TreeNode item = q.poll();
				levelList.add(item.val);
				if (item.children != null){
					for (TreeNode child : item.children) q.add(child);
				}
			}
			r.add(levelList);
		}
		return r;
	}

	// three approaches (below method discusses stack approach only
	// 1. two stacks 2. Double ended queue with null as first entry. 3. double ended queue with 1 as first entry

	// left stack algo (read carefully)
	// while iterating on left stack, throw children from left to right in right stack. (leftmost to go down and rightmost to come up)
	// when you would iterate on right stack, values would be processed from right to left

	// right stack algo
	// while iterating on right stack, throw children from right to left (rightmost to go down and leftmost to come up)
	// when you would iterate on left stack, values would be processed from left to right

	public static List<List<Integer>> zigZagTraversal(BinaryTreeNode root) {
		List<List<Integer>> ls = new ArrayList<>();
		if (root == null)
			return ls;
		Stack<BinaryTreeNode> left = new Stack<>();
		Stack<BinaryTreeNode> right = new Stack<>();
		left.add(root);
		while (!left.isEmpty() || !right.isEmpty()) {
			List<Integer> temp = new ArrayList<>();
			while (!left.isEmpty()) {
				BinaryTreeNode current = left.pop();
				temp.add(current.val);
				// for right stack- print order should be from right to left, hence push left
				// element first so that its at bottom
				if (current.left != null)
					right.push(current.left);
				if (current.right != null)
					right.push(current.right);
			}
			if (temp.size() > 0)
				ls.add(temp);
			temp = new ArrayList<>();
			while (!right.isEmpty()) {
				BinaryTreeNode current = right.pop();
				temp.add(current.val);
				// for left stack- print order should be left to right hence push right element
				// first
				if (current.right != null)
					left.push(current.right);
				if (current.left != null)
					left.push(current.left);
			}
			if (temp.size() > 0)
				ls.add(temp);
		}
		return ls;
	}

	// root -> left boundary -> left leaves -> right leaves -> right boundary
	public static List<Integer> boundaryTraversal(BinaryTreeNode root) {
		List<Integer> nodes = new ArrayList<>();
		if(root == null) return nodes;
		nodes.add(root.val); 
		boundaryLeft(root.left, nodes);
		leaves(root, nodes); 
		boundaryRight(root.right, nodes);
		return nodes;
	}

	// if root is null or current item is leaf element then return
	private static void boundaryLeft(BinaryTreeNode root, List<Integer> nodes) {
		if(root == null || (root.left == null && root.right == null)) return;
		nodes.add(root.val);
		boundaryLeft(root.left != null ? root.left : root.right, nodes);	
	}

	// Add after child visit as we need to go in anticlockwise direction (reverse)
	private static void boundaryRight(BinaryTreeNode root, List<Integer> nodes) {
		if(root == null || (root.left == null && root.right == null)) return;
		boundaryRight(root.right != null ? root.right : root.left, nodes);
		nodes.add(root.val); 
	}

	private static void leaves(BinaryTreeNode root, List<Integer> nodes) {
		if(root == null) 
			return;
		if(root.left == null && root.right == null) { //node is leaf node
			nodes.add(root.val);
			return;
		}
		leaves(root.left, nodes); 
		leaves(root.right, nodes);
	}


}
