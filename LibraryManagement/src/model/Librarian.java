// Done

package model;

public class Librarian extends Staff{
	
	int office;
	public static int currentOfficeNumber;

	public Librarian(int id, String name, String address, int phone, double salary, int of) {
		super(id, name, address, phone, salary);
		
		if ( of == -1) {
			office = currentIdNumber;
		}else {
			office = of;
		}
		
		currentIdNumber++;
		
	}
	
	@Override
	
	public void printInfo() {
		super.printInfo();
		System.out.println("Office Number: " + office);
	}
	
	

}
