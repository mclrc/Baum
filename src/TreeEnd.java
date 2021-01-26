import java.util.ArrayList;
import java.util.function.*;
import java.util.Comparator;

class TreeEnd<T> implements TreeElement<T> {
	public TreeElement<T> insert(T data, Comparator<T> comparator)
	{
		// Create new tree node with data
		Node<T> dataNode = new Node<T>(data);
		// Point the new node's left and right branches to the tree end
		dataNode.setLeft(this);
		dataNode.setRight(this);
		// Return the new node so it's parent can save a referrence to it
		return dataNode;
	}
	// End of tree is size 0
	public int size() { return 0; }
	// End of tree is height 0
	public int height() { return 0; }
	// End of tree contains no further leaves
	public int countLeaves() { return 0; }
	// Nothing to traverse
	public void traverse(TraversalOrder order) {}
	// No nodes to add
	public void addNodesToList(ArrayList<T> list, TraversalOrder order) {}
	// If 'find' reached a tree end, the tree does not contain the target
	public T find(Function<T, Integer> identifier) { return null; }
	// If 'has' reached a tree end, the tree does not contain the target
	public boolean has(T target, Comparator<T> comparator) { return false; }
	// Nothing to delete
	public TreeElement<T> delete(T target, Comparator<T> comparator) { return this; }
	
	public T minimum() { return null; }
	
	public T maximum() { return null; }
}
