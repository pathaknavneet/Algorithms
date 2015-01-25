package com.example;

/*
 Tree Algorithms


 /*Contains Following Algorithms :
 1. Inorder traversal
 2.PreOrder traversal
 3. Postorder traversal
 4.level order traversal
 5.root to leaf paths
 6. Mirror Tree
 7.delete Tree
 8.Size of Tree
 9.Height of Tree
 10.Number of Leaves
 11.Diameter of Tree
 //12. Height balanced Tree

 // Main Program Begins 
 * 
 * */

class Node {
	int data;
	Node leftChild;
	Node rightChild;

	public static Node createNode(int data) {
		Node newNode = new Node();
		newNode.data = data;
		newNode.leftChild = null;
		newNode.rightChild = null;
		return newNode;
	}

}

public class TreeAlgos {

	public static void main(String[] args) {

		Node root = Node.createNode(20);
		root.leftChild = Node.createNode(30);
		root.rightChild = Node.createNode(40);
		root.leftChild.leftChild = Node.createNode(50);
		root.leftChild.rightChild = Node.createNode(60);
		root.rightChild.leftChild = Node.createNode(70);
		root.rightChild.rightChild = Node.createNode(80);

		TreeAlgos.printPreorder(root);
		System.out.println("----------------");
		TreeAlgos.printInorder(root);
		System.out.println("----------------");
		TreeAlgos.printPostorder(root);

		int size = TreeAlgos.sizeofTree(root);
		System.out.println("size of tree====" + size);

		int height = TreeAlgos.heightofTree(root);
		System.out.println("height of tree====" + height);

		deleteTree(root);
		// printMirrorTree(root);
		// printInorder(root);
		int pathlen = 0;
		int[] path = new int[1000];
		// printRootToLeafPaths(root,path,pathlen);
		TreeAlgos.printLevelOrder(root);

		int numberOfLeaves = numberOfLeaf(root);
		System.out.println("number of leaves=====" + numberOfLeaves);

		int diameter = getDiameter(root);
		System.out.println("diameter of the tree =====" + diameter);

		boolean isBalanced = isTreeHeightBalanced(root);

		System.out.println("is tree height balanced ??????========"
				+ isBalanced);

	}

	public static void printInorder(Node root) {
		if (root == null) {
			return;
		}
		printInorder(root.leftChild);
		System.out.println(root.data);
		printInorder(root.rightChild);

	}

	public static void printPostorder(Node root) {
		if (root == null) {
			return;
		}
		printPreorder(root.leftChild);
		printPreorder(root.rightChild);
		System.out.println(root.data);

	}

	public static void printPreorder(Node root) {

		if (root == null) {
			return;
		}
		System.out.println(root.data);
		printPreorder(root.leftChild);
		printPreorder(root.rightChild);

	}

	public static int sizeofTree(Node root) {
		int size = 0;
		if (root == null)
			return 0;
		else {
			size = size + sizeofTree(root.leftChild)
					+ sizeofTree(root.rightChild) + 1;
		}
		return size;
	}

	public static int heightofTree(Node root) {
		if (root == null) {
			return 0;
		}
		return Math.max(heightofTree(root.leftChild),
				heightofTree(root.rightChild)) + 1;
	}

	public static void deleteTree(Node root) {
		// for deleting the tree , delete the node one by one , since we have to
		// delete the parent node in the last , // so use post order traversal
		// of the tree to traverse and then delete the node
		if (root == null) {
			return;
		}
		deleteTree(root.leftChild);
		deleteTree(root.rightChild);
		System.out.println("deleting node=====" + root.data);
		root = null;
	}

	public static void printMirrorTree(Node root) {
		Node temp;
		if (root == null) {
			return;
		}
		printMirrorTree(root.leftChild);
		printMirrorTree(root.rightChild);
		temp = root.leftChild;
		root.leftChild = root.rightChild;
		root.rightChild = temp;

	}

	public static void printRootToLeafPaths(Node root, int[] path, int pathlen) {
		if (root == null)
			return;
		path[pathlen] = root.data;
		pathlen++;

		if (root.leftChild == null && root.rightChild == null) {
			for (int i = 0; i < path.length; i++) {
				System.out.println(path[i]);
			}
		} else {
			printRootToLeafPaths(root.leftChild, path, pathlen);
			printRootToLeafPaths(root.rightChild, path, pathlen);
		}
	}

	public static void printLevelOrder(Node root) {
		int height = TreeAlgos.heightofTree(root);
		for (int i = 1; i <= height; i++) {
			printGivenLevel(root, i);
		}
	}

	public static void printGivenLevel(Node root, int level) {

		if (root == null)
			return;
		if (level == 1) {
			System.out.println(root.data);
		} else if (level > 1) {
			printGivenLevel(root.leftChild, level - 1);
			printGivenLevel(root.rightChild, level - 1);
		}
	}

	public static int numberOfLeaf(Node root) {
		if (root == null)
			return 0;
		if (root.leftChild == null && root.rightChild == null) {
			return 1;
		} else {
			return numberOfLeaf(root.leftChild) + numberOfLeaf(root.rightChild);
		}
	}

	public static int getDiameter(Node root) {
		// diameter is the maximum of the following quantites
		// 1.diameter of left subtree
		// 2.diameter of right subtree
		// 3. longest path from a leave to another leave passing through root
		// (we get it from the height of the tree)
		if (root == null)
			return 0;
		int lHeight = heightofTree(root.leftChild);
		int rHeight = heightofTree(root.rightChild);
		int lDiameter = getDiameter(root.leftChild);
		int rDiameter = getDiameter(root.rightChild);
		return Math.max(lHeight + rHeight + 1, Math.max(lDiameter, rDiameter));

	}

	public static boolean isTreeHeightBalanced(Node root) {
		if (root == null)
			return true;
		int lHeight = heightofTree(root.leftChild);
		int rHeight = heightofTree(root.rightChild);
		int diffHeight = Math.abs(rHeight - lHeight);
		if (isTreeHeightBalanced(root.leftChild)
				&& isTreeHeightBalanced(root.rightChild) && diffHeight <= 1) {
			return true;
		}
		return false;

	}

	public static void printBoundary(Node root) {

		if (root != null) {
			System.out.println(root.data);
			printBoundaryLeft(root.leftChild);
			printLeaves(root.leftChild);
			printLeaves(root.rightChild);
			printBoundaryRight(root.rightChild);
		}
	}

	public static void printLeaves(Node root) {
		if (root != null) {
			printLeaves(root.leftChild);
			if (root.leftChild == null && root.rightChild == null)
				System.out.println(root.data);
			printLeaves(root.rightChild);
		}
	}

	public static void printBoundaryLeft(Node root) {

		if (root.leftChild != null) {
			System.out.println(root.data);
			printBoundaryLeft(root.leftChild);
		} else {
			System.out.println(root.data);
			printBoundaryLeft(root.rightChild);
		}
	}

	public static void printBoundaryRight(Node root) {
		if (root.rightChild != null) {
			System.out.println(root.data);
			printBoundaryRight(root.rightChild);
		} else {
			System.out.println(root.data);
			printBoundaryRight(root.leftChild);
		}

	}

	public static boolean isTreeIdentical(Node root1, Node root2) {
		// trees are identical if all the node are having same data in both the
		// trees and
		// left and right subtree are also identical .
		if (root1 == null && root2 == null)
			return true;
		else
			return (isTreeIdentical(root1.leftChild, root2.leftChild)
					&& isTreeIdentical(root1.rightChild, root2.rightChild) && root1.data == root2.data);

	}

	public static void printSpiralOrder(Node root) {
		if (root == null)
			System.out.println("ttree is empty");
		int height = heightofTree(root);
		boolean ltr = false;
		for (int i = 0; i < height; i++) {
			printGivenLevel(root, i, ltr);
			ltr = !ltr;
		}

	}

	public static void printGivenLevel(Node root, int level, boolean ltr) {

		if (root == null)
			return;
		if (level == 1)
			System.out.println(root.data);
		else {
			if (level > 1 && ltr) {
				printGivenLevel(root.leftChild, level - 1, ltr);
				printGivenLevel(root.rightChild, level - 1, ltr);
			} else {

				printGivenLevel(root.rightChild, level - 1, ltr);
				printGivenLevel(root.leftChild, level - 1, ltr);
			}
		}

	}

	public static int findLevel(Node root, int data) {
		return printLevelUtil(root, data, 1);
	}

	public static int printLevelUtil(Node root, int data, int level) {
		if (root == null)
			return 0;
		else if (root.data == data)
			return level;
		else {
			int downLevel = printLevelUtil(root.leftChild, data, level + 1);
			if (downLevel != 0)
				return downLevel;

			downLevel = printLevelUtil(root.rightChild, data, level + 1);
			return downLevel;
		}

	}
}
