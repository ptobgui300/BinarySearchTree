package tree;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		//BSTUnitTester bstTest = new BSTUnitTester(true);
	//	bstTest.runUnitTests();

		myTest();
	}

	public static void myTest() {
		Integer[] myArray = { 3, 5, 1, 6, 2, 0 };
		ArrayList<BSTNode<Integer>> myList = new ArrayList<>();// used for transverals

		BinarySearchTree<Integer> two = new BinarySearchTree<>();
		// two.printTree();
		BinarySearchTree<Integer> one = new BinarySearchTree<>(myArray);

		System.out.println("Tree one : ");
		System.out.println();
		one.printTree();

		System.out.println();
		System.out.println("Testing insert ===== ");
		System.out.println();

		one.insert(-3);
		one.insert(-3);
		one.insert(7);
		one.insert(7);
		one.insert(4);
		one.printTree();

		System.out.println();
		System.out.println("Testing find ===== ");
		System.out.println();

		System.out.println("find 7 " + one.find(7));
		System.out.println("find 1000 " + one.find(1000));
		System.out.println("find 99 " + one.find(99));
		System.out.println("find -3 " + one.find(-3));
		System.out.println("find 3 " + one.find(3));

		System.out.println();
		System.out.println("Testing isEmpty ===== ");
		System.out.println();

		System.out.println("Tree one : ");
		one.printTree();
		System.out.println();
		System.out.println("Is tree one empty : " + one.isEmpty());
		System.out.println();

		System.out.println("Tree two : ");
		System.out.println();
		System.out.println("Is tree two empty : " + two.isEmpty());

		System.out.println();

		System.out.println("Testing isLeftChild ===== ");
		System.out.println();
		BSTNode<Integer> checkNode = one.nodeToDelete(6);
		System.out.println("is a left child  : " + one.isLeftChild(checkNode));
		checkNode = one.nodeToDelete(4);
		System.out.println("is a left child  : " + one.isLeftChild(checkNode));
		checkNode = one.nodeToDelete(2);
		System.out.println("is the root a left child  : " + one.isLeftChild(checkNode));
		System.out.println();

		System.out.println("Testing isRightChild ===== ");
		System.out.println();
		checkNode = one.nodeToDelete(6);
		System.out.println("is a Right child  : " + one.isRightChild(checkNode));
		checkNode = one.nodeToDelete(4);
		System.out.println("is a right child  : " + one.isRightChild(checkNode));
		checkNode = one.nodeToDelete(2);
		System.out.println("is the root a right child  : " + one.isRightChild(checkNode));
		System.out.println();

		System.out.println();
		System.out.println("Testing isleaf ===== ");

		System.out.println();
		checkNode = one.nodeToDelete(6);
		System.out.println("is a leaf ?  : " + one.isLeaf(checkNode));
		checkNode = one.nodeToDelete(4);
		System.out.println("is a leaf ?  : " + one.isLeaf(checkNode));
		checkNode = one.nodeToDelete(2);
		System.out.println("is a leaf ?  : " + one.isLeaf(checkNode));
		checkNode = one.nodeToDelete(0);
		System.out.println("is a leaf ?  : " + one.isLeaf(checkNode));
		System.out.println();

		System.out.println();
		System.out.println("Testing uncle ===== ");
		System.out.println();

		checkNode = one.nodeToDelete(6);

		if (one.uncle(checkNode) == null) {
			System.out.println("uncle : " + one.uncle(checkNode));
		} else {
			System.out.println("uncle : " + one.uncle(checkNode).getData());
		}

		checkNode = one.nodeToDelete(0);

		if (one.uncle(checkNode) == null) {
			System.out.println("uncle : " + one.uncle(checkNode));
		} else {
			System.out.println("uncle : " + one.uncle(checkNode).getData());
		}

		checkNode = one.nodeToDelete(3);

		if (one.uncle(checkNode) == null) {
			System.out.println("uncle : " + one.uncle(checkNode));
		} else {
			System.out.println("uncle : " + one.uncle(checkNode).getData());
		}

		checkNode = one.nodeToDelete(1);

		if (one.uncle(checkNode) == null) {
			System.out.println("uncle : " + one.uncle(checkNode));
		} else {
			System.out.println("uncle : " + one.uncle(checkNode).getData());
		}

		System.out.println("Testing sibling ===== ");
		System.out.println();

		one.printTree();
		checkNode = one.nodeToDelete(5);

		if (one.sibling(checkNode) == null) {
			System.out.println("Sibling : " + one.sibling(checkNode));
		} else {
			System.out.println("Sibling : " + one.sibling(checkNode).getData());
		}

		checkNode = one.nodeToDelete(6);

		if (one.sibling(checkNode) == null) {
			System.out.println("Sibling : " + one.sibling(checkNode));
		} else {
			System.out.println("Sibling : " + one.sibling(checkNode).getData());
		}

		checkNode = one.nodeToDelete(4);

		if (one.sibling(checkNode) == null) {
			System.out.println("Sibling : " + one.sibling(checkNode));
		} else {
			System.out.println("Sibling : " + one.sibling(checkNode).getData());
		}

		checkNode = one.nodeToDelete(2);

		if (one.sibling(checkNode) == null) {
			System.out.println("Sibling : " + one.sibling(checkNode));
		} else {
			System.out.println("Sibling : " + one.sibling(checkNode).getData());
		}

		checkNode = one.nodeToDelete(-3);

		if (one.sibling(checkNode) == null) {
			System.out.println("Sibling : " + one.sibling(checkNode));
		} else {
			System.out.println("Sibling : " + one.sibling(checkNode).getData());
		}

		checkNode = one.nodeToDelete(3);

		if (one.sibling(checkNode) == null) {
			System.out.println("Sibling : " + one.sibling(checkNode));
		} else {
			System.out.println("Sibling : " + one.sibling(checkNode).getData());
		}

		System.out.println();
		System.out.println("Testing grandparent ===== ");
		System.out.println();

		checkNode = one.nodeToDelete(3);

		if (one.grandparent(checkNode) == null) {
			System.out.println("Grandparent : " + one.grandparent(checkNode));
		} else {
			System.out.println("Grandparent : " + one.grandparent(checkNode).getData());
		}

		checkNode = one.nodeToDelete(1);

		if (one.grandparent(checkNode) == null) {
			System.out.println("Grandparent : " + one.grandparent(checkNode));
		} else {
			System.out.println("Grandparent : " + one.grandparent(checkNode).getData());
		}

		checkNode = one.nodeToDelete(5);

		if (one.grandparent(checkNode) == null) {
			System.out.println("Grandparent : " + one.grandparent(checkNode));
		} else {
			System.out.println("Grandparent : " + one.grandparent(checkNode).getData());
		}

		checkNode = one.nodeToDelete(6);

		if (one.grandparent(checkNode) == null) {
			System.out.println("Grandparent : " + one.grandparent(checkNode));
		} else {
			System.out.println("Grandparent : " + one.grandparent(checkNode).getData());
		}

		checkNode = one.nodeToDelete(7);

		if (one.grandparent(checkNode) == null) {
			System.out.println("Grandparent : " + one.grandparent(checkNode));
		} else {
			System.out.println("Grandparent : " + one.grandparent(checkNode).getData());
		}

		checkNode = one.nodeToDelete(-3);

		if (one.grandparent(checkNode) == null) {
			System.out.println("Grandparent : " + one.grandparent(checkNode));
		} else {
			System.out.println("Grandparent : " + one.grandparent(checkNode).getData());
		}

		System.out.println();
		System.out.println("Pre order traversal : ");
		System.out.println();
		myList = one.preorder();
		one.printList(myList);
		System.out.println();

		System.out.println();
		System.out.println("Post order traversal : ");
		System.out.println();
		myList = one.postorder();
		one.printList(myList);
		System.out.println();
	
		System.out.println();
		System.out.println("In order traversal : ");
		System.out.println();
		myList = one.inorder();
		one.printList(myList);
		System.out.println();

		System.out.println();
		System.out.println("Breadth First traversal : ");
		System.out.println();
		myList = one.breadthfirst();
		one.printList(myList);
		System.out.println();

		System.out.println();
		System.out.println("Testing delete ===== ");
		System.out.println();

		System.out.println("delete 3 : ");
		one.delete(3);
		one.printTree();
		System.out.println();

		System.out.println("delete 1 : ");
		one.delete(1);
		one.printTree();
		System.out.println();

		System.out.println("delete 7 : ");
		one.delete(7);
		one.printTree();
		System.out.println();

	}
}