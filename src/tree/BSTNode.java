/**
 * @ author Pierre Tobgui
 */

package tree;

public class BSTNode<E extends Comparable<E>> {

	protected E data;
	protected BSTNode<E> parent;
	protected BSTNode<E> left;
	protected BSTNode<E> right;


	
	/**
	 * Creates a node with that value in side the node being the data.
	 * @param data is the value that is going to be set as the node's data.
	 */
	
	public BSTNode(E data) {
		this.data = data;
	}
	
	/**
	 * A setter for the node.
	 * @param data is the value that will be set into the node.
	 */
	public void setData(E data) {
		this.data=data;
	}
	/**
	 * A getter for the value inside the node.
	 * @return the data in the node.
	 */
	public E getData() {
		return this.data;
	}

}
