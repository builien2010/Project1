// Done

package model;

public class Person {
	
	protected int id;
	protected String name;
	protected String password;
	protected String address;
	protected int phone;
	
	static int currentIdNumber = 0;

	public Person(int dd, String name, String address, int phone) {
		
		currentIdNumber++;
		if ( dd == -1) {
			id = currentIdNumber;
		}else {
			id = dd;
		}
		
		this.name = name;
		password = Integer.toString(id);
		this.address = address;
		this.phone = phone;
	}

	public Person() {
		super();
	}

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public static int getCurrentIdNumber() {
		return currentIdNumber;
	}

	public static void setCurrentIdNumber(int currentIdNumber) {
		Person.currentIdNumber = currentIdNumber;
	}
	
	public void printInfo() {
		System.out.println("-----------------------------------------------");
		System.out.println("\nThe details are: \n");
		System.out.println("ID: " + id);
		System.out.println("Name: " + name);
		System.out.println("Address: " + address);
		System.out.println("Phone : " + phone + "\n");
	}
	
	
	
	
}
