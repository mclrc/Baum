class BoxStall
{
	// Indices for data retrieval and manipulation based on either name or weight
	private Tree<BoxerIn> nameIndex;
	private Tree<BoxerIn> weightIndex;

	public BoxStall()
	{
		// Create indices
		nameIndex = new Tree<BoxerIn>((BoxerIn a, BoxerIn b) -> a.getName().compareTo(b.getName()));
		weightIndex = new Tree<BoxerIn>((BoxerIn a, BoxerIn b) -> a.getWeight() - b.getWeight());
	}

	/**
	 * Check if a boxer is registered here
	 * @param boxer
	 * 	The boxer to search for
	 */
	public boolean hasBoxer(BoxerIn boxer)
	{
		return nameIndex.has(boxer);
	}
	
	/**
	 * Retrieve boxer by their name
	 * @param name
	 * 	Name of the boxer to search for
	 * @return The boxer object if it exists, otherwise null
	 */
	public BoxerIn findBoxerByName(String name)
	{
		// Search for name in nameIndex
		return nameIndex.find((BoxerIn candidate) -> name.compareTo(candidate.getName()));
	}

	/**
	 * Retrieve boxer by their weight
	 * @param weight
	 * 	Weight of the boxer to search for
	 * @return The boxer object if it exists, otherwise null
	 */
	public BoxerIn findBoxerByWeight(int weight)
	{
		return weightIndex.find((BoxerIn candidate) -> weight - candidate.getWeight());
	}

	/**
	 * Remove a boxer
	 * @param boxer
	 * 	The boxer to remove
	 */
	public void deleteBoxer(BoxerIn boxer)
	{
		// Remove from both indices
		nameIndex.delete(boxer);
		weightIndex.delete(boxer);
	}

	/**
	 * Add  a boxer
	 * @param boxer
	 * 	The boxer to add
	 */
	public void add(BoxerIn boxer)
	{ 
		nameIndex.insert(boxer);
		weightIndex.insert(boxer);
	}
	
	/**
	 * Log all boxers to stdout in alphabetic order
	 */
	public void listBoxers() { nameIndex.traverse(); }
}