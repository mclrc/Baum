import java.util.ArrayList;
import java.util.function.*;
import java.util.Comparator;

public class Tree<T> {
	// Root of the tree
	public TreeElement<T> root = new TreeEnd<T>();
	// Comparator - Dictates which elements are 'less' or 'more' than others in the context of sorting and searching
	Comparator<T> comparator;

	Tree(Comparator<T> comparator) { this.comparator = comparator; }
	Tree() { this((T a, T b) -> a.toString().compareTo(b.toString())); } // Constructor with standard comparator - lexicographical comparison

	// Getters - simply perform operation on the root and return result
	public int size() { return root.size(); }
	public int height() { return root.height(); }
	public int countLeaves() { return root.countLeaves(); }

	/**
	 * Insert data into the tree
	 * @param data
	 * 	Data to be inserted
	 */
	public void insert(T data) { root = root.insert(data, comparator); }

	/**
	 * Traverse the tree in the provided order, logging node contents to stdout
	 * @param order
	 * 	The order in which the tree should be traversed
	 */
	public void traverse(TraversalOrder order) { root.traverse(order); }

	/**
	 * Traverse the tree inorder, logging node contents to stdout
	 */
	public void traverse() { traverse(TraversalOrder.INORDER); }

	/**
	 * Check if the tree contains the target
	 * @param target
	 * 	Element to search for
	 */
	public boolean has(T target) { return root.has(target, comparator); }
	
	/**
	 * Find element where identifier.apply(data) == 0
	 * @param identifier
	 * 	Should return 0 on target element, a negative integer if target is 'lesser' than candidate
	 * 	and a postive value if it is 'more'
	 */
	public T find(Function<T, Integer> identifier) { return root.find(identifier); }

	/**
	 * Delete target from tree
	 * @param target
	 * 	Element to be removed
	 */
	public void delete(T target) { root = root.delete(target, comparator); }

	/**
	 * Create ArrayList containing the elements of the tree in the provided order
	 * @param order
	 * 	Order in which to add elements to the array
	 */
	public ArrayList<T> toArrayList(TraversalOrder order)
	{
		ArrayList<T> list = new ArrayList<T>();
		root.addNodesToList(list, order);
		return list;
	}
	/**
	 * Create ArrayList containing the elements of the tree in inorder
	 */
	public ArrayList<T> toArrayList() { return toArrayList(TraversalOrder.INORDER); }
}
