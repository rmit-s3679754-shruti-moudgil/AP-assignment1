import java.util.ArrayList;
import java.util.Scanner;

public class mainClass {
	public ArrayList<person> members = new ArrayList<person>();
	public ArrayList<connection> connections = new ArrayList<connection>();
	public int numOfMembers = 0;
	public int numOfConnections = 0;

	Scanner scan=new Scanner(System.in);
	public final person findMember(String a1)
	{
		for (int i = 0;i < numOfMembers;i++)
		{
			if (members.get(i).name.compareTo(a1) == 0)
			{
				return members.get(i);
			}
		}
		return null;
	}

	public final ArrayList<connection> findConnection(String a1)
	{
		ArrayList<connection> ListOfConn = new ArrayList<connection>();
		for (int i = 0;i < numOfConnections;i++)
		{
			if (connections.get(i).p1.name.compareTo(a1) == 0  )
			{
				ListOfConn.add(connections.get(i));
			}
			else if( connections.get(i).p2.name.compareTo(a1)==0) ListOfConn.add(connections.get(i));
		}
		return ListOfConn;
	}
	
	public final void addPerson(String a1, String a2, String a3, int age)
	{
	 person x = new person(a1,a2,a3,age);
		members.add(x);
		numOfMembers++;
	}
	public final void listAllPersons()
	{
		for (int i = 0;i < numOfMembers;i++)
		{
			System.out.print(members.get(i).name);
			System.out.print("\n");
		}
	}

	public final void displayProfile(String name)
	{
		person p= findMember(name);
		if (p != null)
		System.out.print("name: "+ p.name+ "\nAge: " +p.age +"\nImage Location:"+p.image+ "\nStatus: " +p.status+ "\nNumber of friends: "+ p.numOfConnections);
		else System.out.print("Name not found");
	}
	
	public final void updateProfile(String name) {
		person p= findMember(name);
		if (p!=null) {
			System.out.print("New name: ");
			p.name= scan.nextLine();
			System.out.print("New age: ");
			p.age=scan.nextInt();
			scan.nextLine();
			System.out.print("New status: ");
			p.status=scan.nextLine();
			System.out.print("New Image location: ");
			p.image=scan.nextLine();
		}
		else System.out.print("Name not found\n");
	}

	
	public final void deleteProfile(String name) {
		person p= findMember(name);
		ArrayList<connection> c=findConnection(name);
		for (int i = 0;i < numOfMembers;i++)
		{
			if (members.get(i).name.compareTo(name) == 0)
			{
				members.remove(p);
				numOfMembers--;
			}
		}
		for (int i = 0;i < numOfConnections;i++)
		{
			if (connections.get(i).p1.name.compareTo(name) == 0  )
			{	for (int j=0;j<c.size();j++) {
				 connections.remove(c.get(j));
				 numOfConnections--;
				}
			}
			else if( connections.get(i).p2.name.compareTo(name)==0) {
				for (int j=0;j<c.size();j++) {
					 connections.remove(c.get(j));
					 numOfConnections--;
					}
			}
		}
		if (p!=null) {
			
			if (c!=null) c=null;
			p=null;
		}
		
		else System.out.print("Name not found\n");
	}

	public final void connect(String a1, String arr, String string)
	{
		person person1 = findMember(a1);
		person person2 = findMember(arr);
		if(person1==null || person2==null)
		{
			System.out.println("Invalid names entered. Please enter the correct name.");
		}
		else if (person1 != null && person2 != null && (person1.age > 16 && person2.age > 16))
		{
			connection x = new connection(person1,person2,string);
			connections.add(x);
			numOfConnections++;
		}
		else if (person1 != null && person2 != null && (person1.age < 16 && person2.age < 16) && Math.abs(person1.age - person2.age) <= 3)
		{
			connection x = new connection(person1,person2,"under16friends");
			connections.add(x);
			numOfConnections++;
		}
		else if (person1 != null && person2 != null && ((person1.age < 16 && person2.age > 16) || (person1.age > 16 && person2.age < 16)) && (string.compareTo("child")!=0))
			System.out.print("Such friendship is not possible\n");
		
		else if((person1.age<2 || person2.age<2) &&  (string.compareTo("Parent")!=0)) System.out.print("Such friendship is not possible\n");
		
		else
		{
			connection x = new connection(person1,person2,"Child");
			connections.add(x);
			numOfConnections++;
		}
	}

	public final void listCollections()
	{
		for (int i = 0;i < numOfConnections;i++)
		{
			System.out.print(connections.get(i).p1.name);
			System.out.print(" is connected to ");
			System.out.print(connections.get(i).p2.name);
			System.out.print(" as ");
			System.out.print(connections.get(i).typeOfConn);
			System.out.print("\n");
		}
	}

	
	public final boolean isConnected(String s1,String s2) {
		ArrayList<connection> ListOfConn=findConnection(s1);
		for (int i=0;i<ListOfConn.size();i++) {
			if (ListOfConn.get(i).p1.name.compareTo(s2)==0) {
				return true;
			}
			else if (ListOfConn.get(i).p2.name.compareTo(s2)==0) {
				return true;
			}
		}
		return false;
	}
}
