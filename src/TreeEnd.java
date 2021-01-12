import java.util.ArrayList;

class TreeEnd<T> implements TreeElement<T> {
	public int size() { return 0; }
	public int height() { return 0; }
	public TreeElement<T> insert(T data)
	{
		Node<T> dataNode = new Node<T>(data);
		dataNode.setLeft(this);
		dataNode.setRight(this);
		return dataNode;
	}

	public int countLeaves() { return 0; }
	public void traverse(TraversalOrder order) {}
	public void addNodesToList(ArrayList<T> list, TraversalOrder order) {}
}
