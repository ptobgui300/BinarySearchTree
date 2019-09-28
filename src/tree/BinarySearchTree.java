
/**
 * @author Pierre Tobgui
 */

package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import hw4.Stack;

public class BinarySearchTree<E extends Comparable<E>> {

	public BSTNode<E> root;

	/**
	 * Creates an empty binary tree.
	 */

	public BinarySearchTree() {

		this.root = null;

	}

	/**
	 * Creates a binary tree using values in an array.
	 * 
	 * @param myArray
	 *            is the array used to create binary tree.
	 */
	public BinarySearchTree(E[] myArray) {

		this.root = new BSTNode(myArray[0]);
		BSTNode<E> current = root;
		BSTNode<E> temp = current;

		for (int i = 0; i < myArray.length; i++) {

			if (i == 0) {
				current.data = myArray[i];
				current.parent = null;
			}

			else {
				insert(myArray[i]);
			}

		}
	}

	/**
	 * Finds the spot of the parent of the node we will be inserting into the tree.
	 * 
	 * @param key
	 *            is the data inside the node.
	 * @return the parent of the new node we are going to insert.
	 */
	public BSTNode<E> insertionPoint(E key) {

		BSTNode<E> current = root;

		BSTNode<E> parent = null;

		BSTNode<E> temp = current;

		while (current != null) {
			if (key.compareTo(current.data) == 0) { // throw
				// DuplicateItemException
			}

			else if (key.compareTo(current.data) < 0) {

				// key<current.data

				parent = current;
				current = current.left;

			}

			else if (key.compareTo(current.data) > 0) {

				// key>current.data

				parent = current;
				current = current.right;

			}

		}

		return parent;

	}

	/**
	 * Inserts a node into the binary search tree.
	 * 
	 * @param key
	 *            is the data which will be inside of the new node.
	 */

	public void insert(E key) {

		BSTNode<E> child = new BSTNode(key);

		if (root == null) {
			root = child;
		} else {

			if (!find(key)) {

				child.parent = insertionPoint(key);

				if (key.compareTo(child.parent.data) < 0) {
					child.parent.left = child;
				} else if (key.compareTo(child.parent.data) > 0) {
					child.parent.right = child;
				}

			}

		}
	}

	/**
	 * Finds if the data exists in binary tree based off of parameter.
	 * 
	 * @param key
	 *            is the data being searched in the tree.
	 * @return true if key is found, and false if it is not found.
	 */

	public boolean find(E key) {

		BSTNode<E> current = this.root;

		while (current != null) {

			if (key.compareTo(current.data) == 0) {
				return true;
			}

			else if (key.compareTo(current.data) < 0) {

				current = current.left;
			}

			else if (key.compareTo(current.data) > 0) {

				current = current.right;
			}

			// System.out.println(current);
		}

		return false;
	}

	/**
	 * Checks to see if a tree is empty or not.
	 * 
	 * @return true if tree is empty. False if tree is not empty.
	 */
	public boolean isEmpty() {
		if (root == null) {
			return true;
		}
		return false;
	}

	/**
	 * Checks to see if a node is a leaf.
	 * 
	 * @param node
	 *            is the node we are checking.
	 * @return true if the node is a leaf, and false if it is not a leaf.
	 */

	public boolean isLeaf(BSTNode<E> node) {

		if (node.right == null && node.left == null) {
			return true;
		}

		return false;
	}

	/**
	 * Prints the tree.
	 */
	public void printTree() {

		if (this.root.right != null) {
			this.printTree(this.root.right, true, "");
		}

		printNodeValue(this.root);

		if (this.root.left != null) {
			this.printTree(this.root.left, false, "");
		}
	}

	/**
	 * Prints the tree
	 * 
	 * @param node
	 *            is the current node.
	 * @param isRight
	 *            boolean for if it is right.
	 * @param indent
	 */
	private void printTree(BSTNode<E> node, boolean isRight, String indent) {
		if (node.right != null) {
			printTree(node.right, true, indent + (isRight ? "        " : " |      "));
		}

		System.out.print(indent);

		if (isRight) {
			System.out.print(" /");
		} else {
			System.out.print(" \\");
		}
		System.out.print("----- ");
		printNodeValue(node);
		if (node.left != null) {
			printTree(node.left, false, indent + (isRight ? " |      " : "        "));
		}

	}

	/**
	 * Prints the value in the node.
	 * 
	 * @param node
	 *            the current node.
	 */

	private void printNodeValue(BSTNode<E> node) {
		if (node == null) {
			System.out.print("<null>");
		} else {
			System.out.print(node.getData());
		}

		System.out.println();
	}

	/**
	 * Counts the number of children of a node in the binary search tree.
	 * 
	 * @param node
	 *            is the node we are checking.
	 * @return the count of the number of children that the node has.
	 */

	public int numChildren(BSTNode<E> node) {
		int count = 0;

		if (node.left != null) {
			count++;
		}
		if (node.right != null) {
			count++;
		}
		return count;

	}

	/**
	 * Finds the node that will be deleted.
	 * 
	 * @param key
	 *            is the data inside that node.
	 * @return the node if it exists, and null if it does not.
	 */
	public BSTNode<E> nodeToDelete(E key) {

		if (find(key)) {
			BSTNode<E> current = root;

			while (current != null) {

				if (key.compareTo(current.data) == 0) {

					return current;
				} else if (key.compareTo(current.data) < 0) {

					current = current.left;
				} else if (key.compareTo(current.data) > 0) {
					current = current.right;
				}

			}
		}
		return null;
	}

	/**
	 * A helper method to delete a node.
	 * 
	 * @param key
	 *            is the value of the node that is going to be deleted.
	 */
	public void delete(E key) {

		if (find(key)) {
			BSTNode<E> removing = nodeToDelete(key);
			delete(removing);
		}
	}

	/**
	 * Deletes the node.
	 * 
	 * @param node
	 *            is the node that is going to be deleted.
	 */

	public void delete(BSTNode<E> node) {

		BSTNode<E> child = null;

		if (isLeaf(node)) {
			if (isLeftChild(node)) {
				node.parent.left = null;

			} else if (isRightChild(node)) {
				node.parent.right = null;

			}
		} else if (numChildren(node) == 1) {

			if (node.left == null) {
				child = node.right;
			} else if (node.right == null) {
				child = node.left;
			}

			if (isLeftChild(node)) {
				node.parent.left = child;
				child.parent = node.parent;
			} else if (isRightChild(node)) {
				node.parent.right = child;
				child.parent = node.parent;
			}

		}

		else if (numChildren(node) == 2) {

			BSTNode<E> max = maxLeftSubtree(node);

			node.setData(max.getData());
			delete(max);

		}

	}

	/**
	 * Finds the max node in the left sub tree of a node.
	 * 
	 * @param node
	 *            is the node we are checking.
	 * @return the max node in the left sub tree.
	 */
	public BSTNode<E> maxLeftSubtree(BSTNode<E> node) {

		BSTNode<E> current = node.left;

		if (current != null) {
			while (current.right != null) {
				current = current.right;
			}

			return current;

		}

		return current;
	}

	/**
	 * Finds the sibling of a node.
	 * 
	 * @param node
	 *            is the node that we are trying to find the sibling of.
	 * @return the sibling of a node.
	 */
	BSTNode<E> sibling(BSTNode<E> node) {

		if (find(node.getData())) {

			if (isRightChild(node) && node.parent.left != null) {
				return node.parent.left;
			}

			else if (isLeftChild(node) && node.parent.right != null) {
				return node.parent.right;
			}
		}
		return null;
	}

	/**
	 * Finds the uncle of a node.
	 * 
	 * @param node
	 *            is the node that we are trying to find the uncle of.
	 * @return the uncle of a node.
	 */
	BSTNode<E> uncle(BSTNode<E> node) {

		if (node.parent != null) {
			return sibling(node.parent);
		}

		return null;
	}

	/**
	 * Finds the grandparent of a node.
	 * 
	 * @param node
	 *            is the node that we are trying to find the grandparent of.
	 * @return the grandparent of a node.
	 */
	BSTNode<E> grandparent(BSTNode<E> node) {

		if (node.parent != null && (isLeftChild(node.parent) || isRightChild(node.parent))) {

			return node.parent.parent;

		}

		return null;
	}

	/**
	 * Checks if a node is a left child.
	 * 
	 * @param node
	 *            is the node we are checking.
	 * @return true if the node is a left child, and false if it is not a left
	 *         child.
	 */

	public boolean isLeftChild(BSTNode<E> node) {

		if (node.parent == null) {
			return false;
		} else if (node.parent.left == null) {
			return false;
		}

		return node.parent.left.data.equals(node.data);
	}

	/**
	 * Checks if a node is a right child.
	 * 
	 * @param node
	 *            is the node we are checking.
	 * @return true if the node is a right child, and false if it is not a right
	 *         child.
	 */

	public boolean isRightChild(BSTNode<E> node) {

		if (node.parent == null) {
			return false;
		}

		else if (node.parent.right == null) {
			return false;
		}

		return node.parent.right.data.equals(node.data);
	}

	/*
	 * public ArrayList<BSTNode<E>> postOrder(BSTNode<E> node) {
	 * 
	 * ArrayList<BSTNode<E>> myList = new ArrayList<>(); Stack<BSTNode<E>> s1 =
	 * null; Stack<BSTNode<E>> s2 = null; BSTNode<E> current = null;
	 * 
	 * if (isEmpty()) { return myList; }
	 * 
	 * s1.push(node);
	 * 
	 * while (!s1.isEmpty()) { current = s1.pop(); s2.push(current);
	 * 
	 * if (current.left != null) { s1.push(current.left); }
	 * 
	 * if (current.right != null) { s1.push(current.right); }
	 * 
	 * }
	 * 
	 * while (!s2.isEmpty()) { current = s2.pop(); myList.add(current); } return
	 * myList; }
	 */

	/**
	 * A helper method for the pre order traversal method.
	 * 
	 * @return an array list with the correct traversal.
	 */

	public ArrayList<BSTNode<E>> preorder() {
		ArrayList<BSTNode<E>> myList = new ArrayList<>();

		myList = preorder(root, myList);
		return myList;
	}

	/**
	 * Traverses through the binary search tree using the pre order traversal, and
	 * puts values into an array list.
	 * 
	 * @param node
	 *            the node being sent into method.
	 * @param myList
	 *            is the array list used to store nodes.
	 * @return the array list with the nodes in the appropriate order.
	 */

	public ArrayList<BSTNode<E>> preorder(BSTNode<E> node, ArrayList<BSTNode<E>> myList) {

		if (node == null) {
			return myList;
		}

		myList.add(node);

		preorder(node.left, myList);
		preorder(node.right, myList);

		return myList;

	}

	/**
	 * A helper method for the post order traversal method.
	 * 
	 * @return an array list with the correct traversal.
	 */

	public ArrayList<BSTNode<E>> postorder() {
		ArrayList<BSTNode<E>> myList = new ArrayList<>();

		myList = postorder(root, myList);
		return myList;
	}

	/**
	 * Traverses through the binary search tree using the post order traversal, and
	 * puts values into an array list.
	 * 
	 * @param node
	 *            the node being sent into method.
	 * @param myList
	 *            is the array list used to store nodes.
	 * @return the array list with the nodes in the appropriate order.
	 */

	private ArrayList<BSTNode<E>> postorder(BSTNode<E> node, ArrayList<BSTNode<E>> myList) {

		if (node == null) {
			return myList;
		}

		postorder(node.left, myList);
		postorder(node.right, myList);
		// System.out.println(node.getData());

		myList.add(node);

		return myList;
	}

	/**
	 * A helper method for the in order traversal method.
	 * 
	 * @return an array list with the correct traversal.
	 */

	public ArrayList<BSTNode<E>> inorder() {
		ArrayList<BSTNode<E>> myList = new ArrayList<>();

		myList = inorder(this.root, myList);
		return myList;
	}

	/**
	 * Traverses through the binary search tree using the in order traversal, and
	 * puts values into an array list.
	 * 
	 * @param node
	 *            the node being sent into method.
	 * @param myList
	 *            is the array list used to store nodes.
	 * @return the array list with the nodes in the appropriate order.
	 */

	private ArrayList<BSTNode<E>> inorder(BSTNode<E> node, ArrayList<BSTNode<E>> myList) {

		if (node == null) {
			return myList;
		}

		inorder(node.left, myList);

		myList.add(node);
		// System.out.println(node.getData() + " size " + myList.size());

		inorder(node.right, myList);
		;
		return myList;
	}

	/**
	 * A helper method for the breadth first traversal method.
	 * 
	 * @return an array list with the correct traversal.
	 */

	public ArrayList<BSTNode<E>> breadthfirst() {

		ArrayList<BSTNode<E>> myList = new ArrayList<>();

		myList = breadthfirst(root);
		return myList;
	}

	/**
	 * Traverses through the binary search tree using breadth first algorithm.
	 * Inputs into an array list accordingly.
	 * 
	 * @param node
	 *            is the root of the binary search tree.
	 * @return an array list of nodes.
	 */

	public ArrayList<BSTNode<E>> breadthfirst(BSTNode<E> node) {

		ArrayList<BSTNode<E>> myList = new ArrayList<>();
		Queue<BSTNode<E>> Q = new LinkedList<BSTNode<E>>();

		Q.add(root);

		while (!Q.isEmpty()) {
			node = Q.remove();
			myList.add(node);
			System.out.println("data : " + node.getData());

			if (node.left != null) {
				Q.add(node.left);
			}
			if (node.right != null) {
				Q.add(node.right);
			}
		}

		return myList;
	}

	/**
	 * Prints an array list.
	 * 
	 * @param myList
	 *            the list of BSTNode<E> that is going to be printed.
	 */

	public void printList(ArrayList<BSTNode<E>> myList) {

		for (int i = 0; i < myList.size(); i++) {

			System.out.print(" [ " + myList.get(i).getData() + " ]");
		}

	}
}
