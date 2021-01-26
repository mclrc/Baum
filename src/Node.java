import java.util.ArrayList;
import java.util.function.*;
import java.util.Comparator;

class Node<T> implements TreeElement<T>
{
	// Data the node holds
	T data;
	// Children
	TreeElement<T> left = null;
	TreeElement<T> right = null;

	Node(T data)
	{
		super();
		this.data = data;
	}

	/**
	 * Recursively insert data into tree while keeping it sorted
	 * @param data
	 * 	Data to insert
	 * @param comparator
	 * 	Passed by the tree - Operation that returns a negative value if
	 * 	it's first argument belongs in the right subtree of the second,
	 * 	and a positive value or zero if it belongs in the left subtree
	 */
	public TreeElement<T> insert(T data, Comparator<T> comparator)
	{
		// Compare to own data and decide where to insert
		if (comparator.compare(this.data, data) < 0) right = right.insert(data, comparator);
		else left = left.insert(data, comparator);
		return this;
	}

	/**
	 * Recursively traverse the tree in 'order' order and prints elements to stdout
	 */
	public void traverse(TraversalOrder order)
	{
		if (order == TraversalOrder.PREORDER) System.out.println(data);
		left.traverse(order);
		if (order == TraversalOrder.INORDER) System.out.println(data);
		right.traverse(order);
		if (order == TraversalOrder.POSTORDER) System.out.println(data);
	}

	/**
	 * Recursively add the nodes of this tree, in the provided order, to the provided list
	 */
	public void addNodesToList(ArrayList<T> list, TraversalOrder order)
	{
		if (order == TraversalOrder.PREORDER) list.add(data);
		left.addNodesToList(list, order);
		if (order == TraversalOrder.INORDER) list.add(data);
		right.addNodesToList(list, order);
		if (order == TraversalOrder.POSTORDER) list.add(data);
	}
	/**
	 * Count the leaves of this tree recursively
	 */
	public int countLeaves()
	{
		boolean isLeaf = left instanceof TreeEnd && right instanceof TreeEnd;
		// If this node is a leaf, return one. Otherwise, return the number of leaves in the left and right subtree
		return isLeaf ? 1 : left.countLeaves() + right.countLeaves();
	}

	/**
	 * Find the element where identifier.apply(data) returns zero.
	 * @param identifier
	 * 	Should return 0 for the wanted element, a negative value if target belongs in the right subtree
	 * 	of the element and a positive value if it belongs in the left subtree
	 * @return The target element
	 */
	public T find(Function<T, Integer> identifier) {
		int result = identifier.apply(data);
		if (result == 0) return data; // This node contains the target. return it.
		else if (result > 0) return right.find(identifier); // Continue search in right subtree
		else return left.find(identifier); // Continue search in left subtree
	}

	/**
	 * Check whether or not this tree contains the target element
	 * @param target
	 * 	The element to look for
	 * @param comparator
	 * 	Passed by tree - dictates where to search next
	 */
	public boolean has(T target, Comparator<T> comparator)
	{
		if (this.data == target) return true; // This node contains the target element. Return true
		else if (comparator.compare(this.data, data) < 0) return right.has(target, comparator); // Target element would be in the right subtree
		else return left.has(target, comparator); // Target element would be in the left subtree
	}

	/**
	 * Delete the target from the tree while keeping it sorted
	 * @param target
	 * 	The element to remove
	 * @param comparator	public int size() { return 0; }
	public int height() { return 0; }
	 * 	Passed by tree - dictates where to search next
	 */
	public TreeElement<T> delete(T target, Comparator<T> comparator)
	{
		// If this node is not the target...
		if (target != data) {
			// Continue search based on how the tree was sorted
			if (comparator.compare(this.data, target) < 0) right = right.delete(target, comparator);
			else left = left.delete(target, comparator);
			// Return the current node - it was not changed
			return this;
		}

		// If this node is the target...

		// If this node has one or no children, replace it with it's child or the tree's end
		if (left instanceof TreeEnd) return right;
		else if (right instanceof TreeEnd) return left;

		// Replace this node's data with the minimum of the right subtree
		data = right.minimum();
		// Remove the minimum from the right subtree
		right = right.delete(data, comparator);
		// Return this node with it's changed content
		return this;
	}

	/**
	 * Find and returns the minimum (leftmost value) of this subtree
	 */
	public T minimum()
	{
		if (left instanceof TreeEnd) return this.data; // Minimum found. Return it
		return left.minimum(); // Continue along the left branch
	}


	/**
	 * Find and returns the maximum (rightmost value) of this subtree
	 */
	public T maximum()
	{
		if (right instanceof TreeEnd) return this.data; // Maximum found. Return it
		return right.maximum(); // Continue along the right branch
	}

	// Getters & setters
	public int size() { return 1 + left.size() + right.size(); }
	public int height() { return 1 + Math.max(left.height(), right.height());	}
	public void setLeft(TreeElement<T> el) { left = el; }
	public void setRight(TreeElement<T> el) { right = el; }
	public TreeElement<T> getLeft() { return left; }
	public TreeElement<T> getRight() { return right; }
}