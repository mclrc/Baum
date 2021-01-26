/**
 * Contains personal information of a boxer: name, gender, age and weight
 */
class BoxerIn
{
	private String name;
	private String gender;
	private int age;
	private int weight;
	
	public BoxerIn(String name, String gender, int age, int weight)
	{
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.weight = weight;
	}

	public String getName() { return name; }
	public String getGender() { return gender; }
	public int getAge() { return age; }
	public int getWeight() { return weight; }

	public String toString() 
	{
		return this.name + ", " + this.age + ", " + this.gender + ", " + this.weight + "kg";
	}
}