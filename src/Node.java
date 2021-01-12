import java.lang.Math;
import java.util.ArrayList;

class Node<T> implements TreeElement<T>
{
	T data;
	TreeElement<T> left = null;
	TreeElement<T> right = null;

	Node(T data)
	{
		super();
		this.data = data;
	}
	
	public TreeElement<T> insert(T data)
	{
		if (left.size() <= right.size()) left = left.insert(data);
		else right = right.insert(data);
		return this;
	}

	public void traverse(TraversalOrder order)
	{
		if (order == TraversalOrder.PREORDER) System.out.println(data);
		left.traverse(order);
		if (order == TraversalOrder.INORDER) System.out.println(data);
		right.traverse(order);
		if (order == TraversalOrder.POSTORDER) System.out.println(data);
	}

	public void addNodesToList(ArrayList<T> list, TraversalOrder order)
	{
		if (order == TraversalOrder.PREORDER) list.add(data);
		left.addNodesToList(list, order);
		if (order == TraversalOrder.INORDER) list.add(data);
		right.addNodesToList(list, order);
		if (order == TraversalOrder.POSTORDER) list.add(data);
	}

	public int countLeaves()
	{
		boolean isLeaf = left instanceof TreeEnd && right instanceof TreeEnd;
		return isLeaf ? 1 : left.countLeaves() + right.countLeaves();
	}

	public int size() { return 1 + left.size() + right.size(); }
	public int height() { return 1 + Math.max(left.height(), right.height());	}
	public void setLeft(TreeElement<T> el) { left = el; }
	public void setRight(TreeElement<T> el) { right = el; }
	public TreeElement<T> getLeft() { return left; }
	public TreeElement<T> getRight() { return right; }
}