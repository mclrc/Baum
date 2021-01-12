import java.util.ArrayList;

interface TreeElement<T> {
	int size();
	int height();
	TreeElement<T> insert(T data);
	void traverse(TraversalOrder order);
	int countLeaves();
	void addNodesToList(ArrayList<T> list, TraversalOrder order);
}
