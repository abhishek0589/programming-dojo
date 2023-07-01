package com.abhishek.dojo.tree;

import java.util.ArrayList;
import java.util.Arrays;

import com.abhishek.data.structure.BinaryTreeNode;
import com.abhishek.data.structure.TreeNode;
import com.abhishek.data.util.SysoutUtil;

public class CodeRunner {

	public static void main(String[] args) {
		CodeRunner cr = new CodeRunner();
		int key = 14;
		switch (key) {
		case 1: 
			cr.findInBST();
			cr.findInBinaryTree();
			break;
		case 2:
			cr.findMaxDepth();
			break;
		case 3:
			cr.isIdentical();
			break;
		case 4:
			cr.isValidBST();
			break;
		case 5:
			cr.printInorder();
			cr.printPreorder();
			cr.printPostorder();
			cr.printLevelOrder();
			cr.printZigZaglOrder();
			cr.boundaryTraversal();
			break;
		case 6:
			cr.isUnival();
			break;
		case 7:
			cr.secondLargest();
			break;
		case 8:
			cr.serializeDeserialize();
		case 9:
			cr.isSymmetricBST();
			break;
		case 10:
			cr.findLargestBSTInUnbalancedBT();
			break;
		case 11:
			cr.invertBinarySearchTree();
			break;
		case 12:
			cr.isSubset();
			break;
		case 13:
			cr.getLowestCommonAncestor();
			break;
		case 14:
			cr.getMaxPathSum();
			break;
		case 15:
			cr.getExactPathSum();
			break;
		case 16:
			cr.getAllPathSums();
			break;
		case 17: 
			cr.boundaryTraversal();
			break;
		default:
			break;
		}
	}

	private void getAllPathSums() {
		PathSumFromRootAll.pathSum(constructMultipleMaxPathSumTree(), 28);
	}

	private void getExactPathSum() {
		System.out.println(PathSumFromRootAny.hasPathSum(constructMaxPathSumTree(), 82));
	}

	private void getMaxPathSum() {
		int val = PathSumMax.maxPathSum(constructMaxPathSumTree());
		System.out.println("max path: " + val);
	}

	private void boundaryTraversal() {
		Traversal.boundaryTraversal(constructBST());
	}

	private TreeNode constructBinaryTreeToGetMaxDepth() {
		TreeNode t = new TreeNode(3);
		t.setChildren(new ArrayList<>());
		t.getChildren().addAll(Arrays.asList(new TreeNode(4), new TreeNode(5), new TreeNode(6)));
		TreeNode node4 = t.getChildren().get(0);
		node4.setChildren(new ArrayList<>());
		node4.getChildren().addAll(Arrays.asList(new TreeNode(7), new TreeNode(8), new TreeNode(8)));
		return t;
	}

	private BinaryTreeNode constructBST() {
		BinaryTreeNode root = new BinaryTreeNode(50);
		Arrays.asList(30,10,40,70,60,80,75,90).forEach(x -> root.addNode(x));
		SysoutUtil.tree(root);
		return root;
	}

	private BinaryTreeNode constructBSTRightmostWithLeftSubtree() {
		final BinaryTreeNode root = new BinaryTreeNode(50);
		Arrays.asList(30,10,40,70,60,80,75,74,76).forEach(x-> root.addNode(x));
		SysoutUtil.tree(root);
		return root;
	}

	private BinaryTreeNode constructBTWithSubBST() {
		BinaryTreeNode root = new BinaryTreeNode(10);
		root.left = new BinaryTreeNode(15);
		root.right = new BinaryTreeNode(8);
		root.left.left = new BinaryTreeNode(12);
		root.left.right = new BinaryTreeNode(20);
		root.right.left = new BinaryTreeNode(5);
		root.right.right = new BinaryTreeNode(9);
		root.left.left.left = new BinaryTreeNode(2);
		root.left.left.right = new BinaryTreeNode(14);
		root.right.left.left = new BinaryTreeNode(4);
		root.right.left.right = new BinaryTreeNode(7);
		root.right.right.right = new BinaryTreeNode(10);
		SysoutUtil.tree(root);
		return root;
	}

	private BinaryTreeNode constructSubsetBST() {
		final BinaryTreeNode root = new BinaryTreeNode(70);
		Arrays.asList(60, 80, 75, 90).forEach(x -> root.addNode(x));
		SysoutUtil.tree(root);
		return root;
	}

	private BinaryTreeNode constructSymmetricBST() {
		final BinaryTreeNode root = new BinaryTreeNode(1);
		final BinaryTreeNode a = root.insertLeft(2);
		a.insertLeft(3);
		a.insertRight(4);
		final BinaryTreeNode b = root.insertRight(2);
		b.insertLeft(4);
		b.insertRight(3);
		SysoutUtil.tree(root);
		return root;
	}

	private TreeNode constructUnbalancedBinaryTree() {
		/*
							3
				  4,		5,			6
			8,	  9,	7
		 */
		TreeNode t = new TreeNode(3); 
		t.setChildren(new ArrayList<>());
		t.getChildren().addAll(Arrays.asList(new TreeNode(4), new TreeNode(5), new TreeNode(6)));
		TreeNode node4 = t.getChildren().get(0);
		node4.setChildren(new ArrayList<>());
		node4.getChildren().addAll(Arrays.asList(new TreeNode(8), new TreeNode(9), new TreeNode(7)));
		return t;
	}

	private BinaryTreeNode constructUnivalBST() {
		final BinaryTreeNode root = new BinaryTreeNode(20);
		final BinaryTreeNode a = root.insertLeft(20);
		a.insertLeft(20);
		a.insertRight(20);
		final BinaryTreeNode b = root.insertRight(20);
		b.insertLeft(20);
		BinaryTreeNode c = b.insertRight(20);
		c.insertLeft(20);
		c.insertRight(20);
		SysoutUtil.tree(root);
		return root;
	}

	public BinaryTreeNode constructMaxPathSumTree() {
		BinaryTreeNode root = new BinaryTreeNode(0);
		//Arrays.asList(5,20,1,8,18,25,22,30).forEach(x-> root.addNode(x));
		// Arrays.asList(0).forEach(x-> root.addNode(x));
		SysoutUtil.tree(root);
		return root;
	}

	public BinaryTreeNode constructMultipleMaxPathSumTree() {
		BinaryTreeNode root = new BinaryTreeNode(15);
		Arrays.asList(5,20,1,7,8,18,25,22,30).forEach(x-> root.addNode(x));
		SysoutUtil.tree(root);
		return root;
	}

	private void findInBinaryTree() {
		System.out.println(FindNode.findInBT(constructUnbalancedBinaryTree(), 1));
		System.out.println(FindNode.findInBT(constructUnbalancedBinaryTree(), 8));
		System.out.println(FindNode.findAllInBT(constructUnbalancedBinaryTree(), 8, new ArrayList<Integer>()).size());
	}

	private void findInBST() {
		System.out.println("element 10 found: " + FindNode.findInBST(constructBST(), 10));
		System.out.println("element 90 found: " + FindNode.findInBST(constructBST(), 90));
		System.out.println("element 70 found: " + FindNode.findInBST(constructBST(), 70));
		System.out.println("element 1000 found: " + FindNode.findInBST(constructBST(), 1000));
	}

	private void findLargestBSTInUnbalancedBT() {
		System.out.print("The size of the largest BST is " + FindLargestBSTinBinaryTree.findLargestBST(constructBTWithSubBST()).size);
	}

	public void findMaxDepth() {
		// binary search tree
		final BinaryTreeNode root = constructBST();
		int maxDepth = MaxDepth.maxDepth(root);
		System.out.println("Max depth of BST is: " + maxDepth);

		// binary tree
		TreeNode t = constructBinaryTreeToGetMaxDepth();
		maxDepth = MaxDepth.maxDepth(t);
		System.out.println("Max depth of BT is: " + maxDepth);
	}

	private void getLowestCommonAncestor() {
		System.out
		.println(LowestCommonAncestor.balanced(constructBST(), constructBST().left.left, constructBST().left));
	}

	private void invertBinarySearchTree() {
		BinaryTreeNode root = constructBST();
		System.out.println("inverted tree");
		SysoutUtil.tree(InvertBinaryTree.invert(root));
	}

	public void isIdentical() {
		final BinaryTreeNode root = constructBST();
		final BinaryTreeNode root1 = constructBST();
		System.out.println(IdenticalTree.isIdentical(root, root1));
	}

	private void isSubset() {
		BinaryTreeNode n1 = constructBST();
		BinaryTreeNode n2 = constructSubsetBST();
		System.out.println(SubTreeInTree.isSubset(n1, n2));
	}

	private void isSymmetricBST() {
		final BinaryTreeNode root = constructSymmetricBST();
		System.out.println(SymmetricBST.isSymmetric(root));		
	}

	public void isUnival() {
		final BinaryTreeNode root = constructUnivalBST();
		System.out.println(UnivalBST.isUnival(root));
	}

	public void isValidBST() {
		final BinaryTreeNode root = constructBST();
		System.out.println("is valid binary search tree ? \n " + ValidBinarySearchTree.isValidBinarySearchTree(root));
	}

	public void printInorder() {
		System.out.println("===INRODER===");
		final BinaryTreeNode root = constructBST();
		System.out.println("Inorder recursive .. ");
		Traversal.inOrder(root);
		System.out.println("\nInorder iterative .. ");
		Traversal.inOrderItr(root);
	}

	public void printLevelOrder() {
		System.out.println("===LEVEL-RODER===");
		final BinaryTreeNode root = constructBST();
		Traversal.levelorderTraversalBinaryTree(root);
	}

	public void printPostorder() {
		System.out.println("===POST-RODER===");
		final BinaryTreeNode root = constructBST();
		System.out.println("postorder recursive .. ");
		Traversal.postOrder(root);
		System.out.println("\npostorder iterative .. ");
		Traversal.postOrderItr(root);
	}

	public void printPreorder() {
		System.out.println("===PRE-RODER===");
		final BinaryTreeNode root = constructBST();
		System.out.println("preoroder recursive .. ");
		Traversal.preOrder(root);
		System.out.println("\npreoroder iterative .. ");
		Traversal.preOrderItr(root);
	}

	public void printZigZaglOrder() {
		System.out.println("===Zig zag/ spiral-RODER===");
		final BinaryTreeNode root = constructBST();
		Traversal.zigZagTraversal(root);
	}

	public void secondLargest() {
		System.out.println("secondLargest is: " + FindSecondLargest.secondLargestIterative(constructBST()));
		System.out.println("secondLargest is: " + FindSecondLargest.secondLargestIterative(constructBSTRightmostWithLeftSubtree()));
		
		System.out.println("secondLargest is: " + FindSecondLargest.secondLargestRecursive(constructBST()));
		System.out.println("secondLargest is: " + FindSecondLargest.secondLargestRecursive(constructBSTRightmostWithLeftSubtree()));
	}

	public void serializeDeserialize() {
		final BinaryTreeNode root = new BinaryTreeNode(50);
		Arrays.asList(50, 30,10,40,70,60,80,75,90).forEach(x-> root.addNode(x));
		SysoutUtil.tree(root);
		System.out.println("serialized => " + SerializeDeserializeBinaryTree.serialize(root));
	}
}
