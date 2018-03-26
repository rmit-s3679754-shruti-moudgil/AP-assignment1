import java.util.Scanner;

public class Driver {
	public Driver()
	{
		mainClass main = new mainClass();
		@SuppressWarnings("resource")
		Scanner scan=new Scanner(System.in);
		main.addPerson("tushar", "/user", "Studying at RMIT", 25);
		main.addPerson("Bob", "/myDirectory", "Working as bartender", 22);
		main.addPerson("Cathy", "/xyz","Playing with dolls", 10);
		main.addPerson("david", "/poo", "Carpenter", 40);
		main.addPerson("jessica", "/poo", "Designer", 40);
		main.connect("Cathy", "david", "child");
		main.connect("Cathy", "jessica", "child");
		main.connect("jessica", "david", "spouse");
		while (true)
		{

			System.out.print("MiniNet Menu");
			System.out.print("\n");
			System.out.print("=====================");
			System.out.print("\n");
			System.out.print("1.Add person to social network");
			System.out.print("\n");
			System.out.print("2.List all the people present in the social network");
			System.out.print("\n");
			System.out.print("3.Display profile");
			System.out.print("\n");
			System.out.print("4. Make a connection");
			System.out.print("\n");
			System.out.print("5. List all the connections");
			System.out.print("\n");
			System.out.print("6. Update Profile");
			System.out.print("\n");
			System.out.print("7. delete Profile");
			System.out.print("\n");
			System.out.print("8. Find whether 2 persons are connected");
			System.out.print("\n");
			System.out.print("9. Exit");
			System.out.print("\n");
			int x;
			x = scan.nextInt();
			if (x == 1)
			{
				System.out.print("Enter name:");
				scan.nextLine();
				String a1 =scan.nextLine();
				System.out.print("Enter image location: ");
				String a2 = scan.nextLine();
				int age;
				System.out.print("Enter Status: ");
				String a3 = scan.nextLine();
				System.out.print("Enter age: ");
				age = scan.nextInt();
				scan.nextLine();
				if (age > 16)
				{
					main.addPerson(a1,a2,a3,age);
				}
				else
				{
					main.addPerson(a1,a2,a3,age);
					System.out.print("Please add the name 2 parents of this person as his/her age is under 16");
					System.out.print("\n");
					System.out.print("Parent1 name: ");
					String p1n =scan.nextLine();
					System.out.print("Parent2 name: ");
					String p2n =scan.nextLine();
					
					if (main.findMember(p1n)==null) {
						System.out.print("Parent1 image location: ");
						String p1i = scan.nextLine();
						int age1;
						System.out.print("Parent1 Status: ");
						String p1s = scan.nextLine();
						System.out.print("Parent1 age: ");
						age1 = scan.nextInt();
						scan.nextLine();
						main.addPerson(p1n,p1i,p1s,age1);
					}
					if (main.findMember(p2n)==null) {
						System.out.print("Parent2 image location: ");
						String p2i = scan.nextLine();
						int age2;
						System.out.print("Parent2 Status: ");
						String p2s = scan.nextLine();
						System.out.print("Parent2 age: ");
						age2 = scan.nextInt();
						scan.nextLine();
						main.addPerson(p2n,p2i,p2s,age2);
					}
					main.connect(a1,p1n,"Parent");
					main.connect(a1,p2n,"Parent");
					if (main.isConnected(p1n, p2n)==false) main.connect(p1n,p2n,"Spouse");
				}
			}
			else if (x == 2)
			{	
				main.listAllPersons();
			}

			else if (x == 3)
			{	System.out.print("Enter the name of profile to be viewed");
				scan.nextLine();
				String arr= scan.nextLine();
				main.displayProfile(arr);
			}
			else if (x == 4)
			{
				System.out.print("Enter names of 2 persons to be connected");
				System.out.print("\n");
				scan.nextLine();
				String a1= scan.nextLine();
				String a2 =scan.nextLine();
				main.connect(a1,a2,"Friend");
			}
			else if (x == 5)
			{
				main.listCollections();
			}

			else if (x==6) {
				System.out.print("Enter name of the person to update");
				scan.nextLine();
				String a=scan.nextLine();
				main.updateProfile(a);
			}
			
			else if (x==7) {
				System.out.print("Enter name of the person to delete");
				scan.nextLine();
				String a=scan.nextLine();
				main.deleteProfile(a);
				
			}
			else if (x==8) {
				System.out.print("Enter name of the person1: ");
				scan.nextLine();
				String a1=scan.nextLine();
				System.out.print("Enter name of the person2: ");
				String a2=scan.nextLine();
				if(main.isConnected(a1,a2)) System.out.print("\nYes they are connected\n");
				else System.out.print("\nNot connected\n");
			}
			
			//else if (x==9) break;
			else System.out.print("\nInvalid choice, try again\n\n");
			
		}
	}

}
