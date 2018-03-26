
public class person {
	public String name = new String(new char[100]);
	public String image = new String(new char[10000]);
	public String status = new String(new char[100]);
	public int age;
	public int numOfConnections = 0;
	public person(String name, String image, String status)
	{
		this(name, image, status, 20);
	}

	public person(String name, String image, String status, int age)
	{
		this.name = name;
		this.image = image;
		this.status = status;
		this.age = age;
	}
}
