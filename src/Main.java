class Main {
	public static void main (String[] args)
	{
		Tree<String> testTree = new Tree<String>();
		for (int i = 1; i < 8; i++) testTree.insert("" + i);

		for (TraversalOrder order : TraversalOrder.values())
		{
			System.out.println("\n");
			System.out.println(order);
			testTree.traverse(order);
			System.out.println("");
			for (String s : testTree.toArrayList(order)) System.out.println(s);
		}
	}
}