// Done

package model;

public class Person {
	
    protected int idPerson;
    protected String name;
	protected String password;
        protected String email;
	protected String address;
	protected String phone;
	
	static int currentIdNumber = 0;

	public Person(String name, String email, String password, String address, String phone) {
		
		this.name = name;
                this.email = email;
                this.password = password;
		this.address = address;
		this.phone = phone;
	}

	public Person() {
		super();
	}

	

	public int getIdPerson() {
		return idPerson;
	}

	public void setIdPerson(int idPerson) {
		this.idPerson = idPerson;
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
        
        public String getEmail(){
            return email;  
        }
        
        public void setEmail(String email){
            this.email = email;
        }

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
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
		System.out.println("ID: " + idPerson);
		System.out.println("Name: " + name);
                System.out.println("Password: " + password);
                
		System.out.println("Address: " + address);
		System.out.println("Phone : " + phone + "\n");
	}
	
	
	
	
}
