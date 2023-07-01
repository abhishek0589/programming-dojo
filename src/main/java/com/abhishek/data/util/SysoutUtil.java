package com.abhishek.data.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.abhishek.data.structure.BinaryTreeNode;
import com.abhishek.data.structure.ListNode;
import com.abhishek.dojo.misc.BuildingPoint;

public class SysoutUtil
{
	public static void array(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "\t");
		}
		System.out.println();
	}

	public static void array2d(int[][] arr) {
		for (int[] row : arr){
			System.out.println(Arrays.toString(row));
		}
	}

	public static void array2d(BuildingPoint[] arr) {
		for (BuildingPoint p : arr) {
			System.out.println(p.toString());
		}
	}

	public static void array2dChar(char[][] arr) {
		for (char[] row : arr){
			System.out.println(Arrays.toString(row));
		}
	}

	public static void arrayWithIndex(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(i + "\t");
		}
		System.out.println();
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "\t");
		}
		System.out.println();
	}

	public static void linkedlist(ListNode head){
		String str = "";
		ListNode current = head;
		while(current != null){
			str += current.val + (current.next != null  ? " -> " : "");
			current = current.next;
		}
		System.out.println(str);
	}

	public static void tree(BinaryTreeNode root) {
		System.out.println("\n");
		List<List<String>> lines = new ArrayList<>();
		ArrayList<BinaryTreeNode> level = new ArrayList<BinaryTreeNode>();
		ArrayList<BinaryTreeNode> next = new ArrayList<BinaryTreeNode>();
		level.add(root);
		int nn = 1;
		int widest = 0;
		while (nn != 0) {
			ArrayList<String> line = new ArrayList<String>();
			nn = 0;
			for (BinaryTreeNode n : level) {
				if (n == null) {
					line.add(null);
					next.add(null);
					next.add(null);
				} else {
					String aa = "" + n.val;
					line.add(aa);
					if (aa.length() > widest) widest = aa.length();
					next.add(n.left);
					next.add(n.right);
					if (n.left != null) nn++;
					if (n.right != null) nn++;
				}
			}
			if (widest % 2 == 1) widest++;
			lines.add(line);
			ArrayList<BinaryTreeNode> tmp = level;
			level = next;
			next = tmp;
			next.clear();
		}
		int perpiece = lines.get(lines.size() - 1).size() * (widest + 4);
		for (int i = 0; i < lines.size(); i++) {
			ArrayList<String> line = (ArrayList<String>) lines.get(i);
			int hpw = (int) Math.floor(perpiece / 2f) - 1;
			if (i > 0) {
				for (int j = 0; j < line.size(); j++) {
					// split node
					char c = ' ';
					if (j % 2 == 1) {
						if (line.get(j - 1) != null) {
							c = (line.get(j) != null) ? '┴' : '┘';
						} else {
							if (j < line.size() && line.get(j) != null) c = '└';
						}
					}
					System.out.print(c);
					// lines and spaces
					if (line.get(j) == null) {
						for (int k = 0; k < perpiece - 1; k++)  System.out.print(" ");
					} else {
						for (int k = 0; k < hpw; k++) System.out.print(j % 2 == 0 ? " " : "─");
						System.out.print(j % 2 == 0 ? "┌" : "┐");
						for (int k = 0; k < hpw; k++) System.out.print(j % 2 == 0 ? "─" : " ");
					}
				}
				System.out.println();
			}
			// print line of numbers
			for (int j = 0; j < line.size(); j++) {
				String f = line.get(j);
				if (f == null) f = "";
				int gap1 = (int) Math.ceil(perpiece / 2f - f.length() / 2f);
				int gap2 = (int) Math.floor(perpiece / 2f - f.length() / 2f);
				// a number
				for (int k = 0; k < gap1; k++) System.out.print(" ");
				System.out.print(f);
				for (int k = 0; k < gap2; k++) System.out.print(" ");
			}
			System.out.println();
			perpiece /= 2;
		}
	}

}
