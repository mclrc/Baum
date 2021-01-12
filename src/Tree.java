import java.util.ArrayList;

public class Tree<T> {
	public TreeElement<T> root;
	Tree()
	{
		root = new TreeEnd<T>();
	}
	public int size() { return root.size(); }
	public int height() { return root.height(); }
	public int countLeaves() { return root.countLeaves(); }

	public void insert(T data) { root = root.insert(data); }

	public void traverse(TraversalOrder order) { root.traverse(order); }
	public void traverse() { traverse(TraversalOrder.INORDER); }

	public ArrayList<T> toArrayList(TraversalOrder order)
	{
		ArrayList<T> list = new ArrayList<T>();
		root.addNodesToList(list, order);
		return list;
	}
	public ArrayList<T> toArrayList() { return toArrayList(TraversalOrder.INORDER); }
}
