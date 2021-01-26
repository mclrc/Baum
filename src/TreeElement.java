import java.util.ArrayList;
import java.util.function.*;
import java.util.Comparator;


interface TreeElement<T> {
	TreeElement<T> insert(T data, Comparator<T> comparator);
	int size();
	int height();
	int countLeaves();
	void traverse(TraversalOrder order);
	void addNodesToList(ArrayList<T> list, TraversalOrder order);
	T find(Function<T, Integer> identifier);
	boolean has(T target, Comparator<T> comparator);
	TreeElement<T> delete(T target, Comparator<T> comparator);
	T minimum();
	T maximum();
}
