class Main {
	public static void main (String[] args)
	{
		BoxStall boxstall = new BoxStall();

		BoxerIn a = new BoxerIn("Juan", "Male", 22, 90);
		BoxerIn b = new BoxerIn("Guadalupe", "Female", 19, 87);
		BoxerIn c = new BoxerIn("Felix", "Male", 28, 80);
		BoxerIn d = new BoxerIn("Tata", "Female", 24, 92);

		BoxerIn e = new BoxerIn("Pablo", "Male", 32, 76);

		boxstall.add(a);
		boxstall.add(b);
		boxstall.add(c);
		boxstall.add(d);

		boxstall.listBoxers();

		System.out.println("Searching for specific boxers...");
		System.out.println(a.toString() + ": " + (boxstall.hasBoxer(a)  ? "Found" : "Not found"));
		System.out.println(e.toString() + ": " + (boxstall.hasBoxer(e)  ? "Found" : "Not found"));


		System.out.println("\nDeleting Felix...");
		boxstall.deleteBoxer(c);
		boxstall.listBoxers();

		System.out.println("\nFinding by weight: 87kg");
		System.out.println(boxstall.findBoxerByWeight(87));
		
		System.out.println("\nDoes Miguel train here? " + (boxstall.findBoxerByName("Miguel") == null ? "No" : "Yes"));
		System.out.println("Does Tata train here? " + (boxstall.findBoxerByName("Tata") == null ? "No" : "Yes"));

		System.out.println("Does someone weighing 90kg train here? " + (boxstall.findBoxerByWeight(90) == null ? "No" : "Yes"));
		System.out.println("Does someone weighing 70kg train here? " + (boxstall.findBoxerByWeight(70) == null ? "No" : "Yes"));
	}
}